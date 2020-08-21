package com.whzm.service.impl;

import com.whzm.mapper.ResourceCoopMapper;
import com.whzm.pojo.Cooperation;
import com.whzm.pojo.ResourceCoop;
import com.whzm.service.IResourceCoopService;
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
public class ResourceCoopServiceImpl implements IResourceCoopService {

    @Autowired
    private ResourceCoopMapper resourceCoopMapper;

    @Override
    public Integer addResourceCoop(ResourceCoop resourceCoop) {
        resourceCoop.setId("C" + String.valueOf(System.currentTimeMillis() + "" + (int) (Math.random() * 100)).substring(3));
        return resourceCoopMapper.add(resourceCoop);
    }

    @Override
    public ResponseEntity queryAll() {
        List<Cooperation> cooperations = resourceCoopMapper.queryAll();
        return ResponseEntity.pageSuccess(200, "ok", cooperations, null);
    }
}
