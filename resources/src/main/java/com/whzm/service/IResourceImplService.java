package com.whzm.service;

import com.whzm.pojo.ResourceImpl;
import com.whzm.util.ResponseEntity;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:30
 * @Description:
 */
public interface IResourceImplService {

    Integer addResourceImpl(ResourceImpl resourceImpl);

    ResponseEntity queryAll();
}
