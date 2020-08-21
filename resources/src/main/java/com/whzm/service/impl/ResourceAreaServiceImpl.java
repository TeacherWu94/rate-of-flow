package com.whzm.service.impl;

import com.whzm.mapper.ResourceAreaMapper;
import com.whzm.pojo.Area;
import com.whzm.pojo.ResourceArea;
import com.whzm.service.IResourceAreaService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service.impl
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:32
 * @Description:
 */
@Service
public class ResourceAreaServiceImpl implements IResourceAreaService {

    @Autowired
    private ResourceAreaMapper resourceAreaMapper;

    @Override
    public Integer addResourceArea(ResourceArea resourceArea) {
        resourceArea.setId("A" + String.valueOf(System.currentTimeMillis() + "" + (int) (Math.random() * 100)).substring(3));
        return resourceAreaMapper.add(resourceArea);
    }

    @Override
    public ResponseEntity queryAll() {
        List<Area> areas = resourceAreaMapper.queryAll();
        return ResponseEntity.pageSuccess(200, "ok", areas, null);
    }
}
