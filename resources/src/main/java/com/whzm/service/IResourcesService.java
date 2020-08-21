package com.whzm.service;

import com.whzm.pojo.ResourceEntity;
import com.whzm.pojo.vo.ResourceDetailVo;
import com.whzm.util.ResponseEntity;

import java.util.List;


/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.service
 * @Author: 吴严
 * @CreateTime: 2020-08-12 20:16
 * @Description:
 */
public interface IResourcesService {

    ResponseEntity queryAll(ResourceEntity resourceEntity);

    ResponseEntity addResource(ResourceEntity resourceEntity);

    ResponseEntity getById(String id);
}
