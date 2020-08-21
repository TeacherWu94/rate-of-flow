package com.whzm.service;

import com.whzm.pojo.ResourceArea;
import com.whzm.pojo.ResourceImpl;
import com.whzm.util.ResponseEntity;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:31
 * @Description:
 */
public interface IResourceAreaService {

    Integer addResourceArea(ResourceArea resourceArea);

    ResponseEntity queryAll();
}
