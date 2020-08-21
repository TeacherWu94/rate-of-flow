package com.whzm.service;

import com.whzm.pojo.ResourceArea;
import com.whzm.pojo.ResourceCoop;
import com.whzm.util.ResponseEntity;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:32
 * @Description:
 */
public interface IResourceCoopService {

    Integer addResourceCoop(ResourceCoop resourceCoop);

    ResponseEntity queryAll();
}
