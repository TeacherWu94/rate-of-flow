package com.whzm.service.impl;

import com.whzm.mapper.ResourceImplMapper;
import com.whzm.pojo.Implementation;
import com.whzm.pojo.ResourceImpl;
import com.whzm.service.IResourceImplService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service.impl
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:31
 * @Description:
 */
@Service
public class ResourceImplServiceImpl implements IResourceImplService {

    @Autowired
    private ResourceImplMapper resourceImplMapper;

    @Override
    public Integer addResourceImpl(ResourceImpl resourceImpl) {
        resourceImpl.setId("I" + String.valueOf(System.currentTimeMillis() + "" + (int) (Math.random() * 100)).substring(3));
        return resourceImplMapper.add(resourceImpl);
    }

    @Override
    public ResponseEntity queryAll() {
        List<Implementation> implementations = resourceImplMapper.queryAll();
        return ResponseEntity.pageSuccess(200, "ok", implementations, null);
    }
}
