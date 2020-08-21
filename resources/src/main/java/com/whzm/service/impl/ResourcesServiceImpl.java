package com.whzm.service.impl;

import com.whzm.mapper.ResourcesMapper;
import com.whzm.pojo.*;
import com.whzm.pojo.vo.ResourceDetailVo;
import com.whzm.pojo.vo.ResourcesListVo;
import com.whzm.service.IResourceAreaService;
import com.whzm.service.IResourceCoopService;
import com.whzm.service.IResourceImplService;
import com.whzm.service.IResourcesService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service.impl
 * @Author: 吴严
 * @CreateTime: 2020-08-12 20:16
 * @Description:
 */
@Service
public class ResourcesServiceImpl implements IResourcesService {
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private IResourceImplService implService;

    @Autowired
    private IResourceAreaService areaService;

    @Autowired
    private IResourceCoopService coopService;

    @Override
    public ResponseEntity queryAll(ResourceEntity resourceEntity) {
        if (StringUtils.isEmpty(resourceEntity)) {
            return ResponseEntity.pageSuccess(200, "ok", resourcesMapper.queryAll(0), resourcesMapper.queryAll(0).size());
        }
        List<ResourcesListVo> resources = resourcesMapper.queryAll(resourceEntity.getType());
        Integer count = resources.size();
        if (!StringUtils.isEmpty(resourceEntity.getImplIds())) {
            System.out.println("进入了落地方式条件筛选");
            String[] implStrings = resourceEntity.getImplIds().split(",");
            for (int i = 0; i < resources.size(); i++) {
                List<Implementation> implementations = resources.get(i).getImplementations();
                List<String> implIdList = new ArrayList<>();
                for (Implementation implementation : implementations) {
                    implIdList.add(implementation.getImplementationId());
                }
                for (String implId : implStrings) {
                    if (!implIdList.contains(implId)) {
                        resources.remove(i);
                        i--;  //当list删除数据后，索引会自动更新，所以先减一，for里面再加一，保证元素顺序完整性
                        break;
                    }
                }
            }
        }
        if (!StringUtils.isEmpty(resourceEntity.getAreaIds())) {
            System.out.println("进入了地区条件筛选");
            String[] areaStrings = resourceEntity.getAreaIds().split(",");
            for (int i = 0; i < resources.size(); i++) {
                List<Area> areas = resources.get(i).getAreas();
                List<String> areaIdList = new ArrayList<>();
                for (Area area : areas) {
                    areaIdList.add(area.getAreaId());
                }
                for (String areaId : areaStrings) {
                    if (!areaIdList.contains(areaId)) {
                        resources.remove(i);
                        i--;  //当list删除数据后，索引会自动更新，所以先减一，for里面再加一，保证元素顺序完整性
                        break;
                    }
                }
            }
        }
        if (!StringUtils.isEmpty(resourceEntity.getCoopIds())) {
            System.out.println("进入了合作方式条件筛选");
            String[] coopStrings = resourceEntity.getCoopIds().split(",");
            for (int i = 0; i < resources.size(); i++) {
                List<Cooperation> cooperations = resources.get(i).getCooperations();
                List<String> coopIdList = new ArrayList<>();
                for (Cooperation cooperation : cooperations) {
                    coopIdList.add(cooperation.getCooperationId());
                }
                for (String coopId : coopStrings) {
                    if (!coopIdList.contains(coopId)) {
                        resources.remove(i);
                        i--;  //当list删除数据后，索引会自动更新，所以先减一，for里面再加一，保证元素顺序完整性
                        break;
                    }
                }
            }
        }
        System.out.println(resources.toString());
        List<ResourcesListVo> resourcesListVos = new ArrayList<>();
        Integer page = resourceEntity.getPage();
        Integer pageSize = resourceEntity.getPageSize();
        Integer start = (page - 1) * pageSize;
        Integer end = (page - 1) * pageSize + pageSize;
        resourcesListVos = resources.subList(start, end);
        return ResponseEntity.pageSuccess(200, "ok", resourcesListVos, count);
    }

    @Override
    @Transactional
    public ResponseEntity addResource(ResourceEntity resourceEntity) {
        if (StringUtils.isEmpty(resourceEntity)) {
            return ResponseEntity.tipsSuccess(500, "操作有误，请重试");
        }
        Resources resources = new Resources();
        String resourceId = "R" + String.valueOf(System.currentTimeMillis() + "" + (int) (Math.random() * 100)).substring(3);
        //利用spring中的copy对象的方法完成两个对象中相同字段的复制
        BeanUtils.copyProperties(resourceEntity, resources);
        resources.setId(resourceId);
        //将资源对象新增到资源表中
        Integer add = resourcesMapper.addResource(resources);
        //资源添加完成后，需要添加与资源信息关联的落地方式，地区，合作方式等信息
        if (add > 0) {
            String[] implIds = resourceEntity.getImplIds().split(",");
            for (String implId : implIds) {
                ResourceImpl resourceImpl = new ResourceImpl();
                resourceImpl.setImplementationId(implId);
                resourceImpl.setResourcesId(resourceId);
                implService.addResourceImpl(resourceImpl);
            }
            String[] areaIds = resourceEntity.getAreaIds().split(",");
            for (String areaId : areaIds) {
                ResourceArea resourceArea = new ResourceArea();
                resourceArea.setAreaId(areaId);
                resourceArea.setResourcesId(resourceId);
                areaService.addResourceArea(resourceArea);
            }
            String[] coopIds = resourceEntity.getCoopIds().split(",");
            for (String coopId : coopIds) {
                ResourceCoop resourceCoop = new ResourceCoop();
                resourceCoop.setCooperationId(coopId);
                resourceCoop.setResourcesId(resourceId);
                coopService.addResourceCoop(resourceCoop);
            }
            return ResponseEntity.tipsSuccess(200, "添加成功");
        }
        return ResponseEntity.tipsSuccess(500, "系统故障，添加失败");
    }

    @Override
    public ResponseEntity getById(String id) {
        List<ResourceDetailVo> resourceDetailVos = resourcesMapper.getById(id);
        return ResponseEntity.entitySuccess(200, "ok", resourceDetailVos.get(0));
    }

}
