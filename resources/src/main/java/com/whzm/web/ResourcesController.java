package com.whzm.web;

import com.whzm.pojo.ResourceEntity;
import com.whzm.service.IResourcesService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.web
 * @Author: 吴严
 * @CreateTime: 2020-08-12 20:14
 * @Description: 资源总表控制层
 */
@RestController
public class ResourcesController {

    @Autowired
    private IResourcesService resourcesService;

    @GetMapping("visitResources")
    public String visitResources() {
        return "访问Resources";
    }

    /**
     * 查询所有资源列表信息（分广告和流量）
     *
     * @param resourceEntity
     * @return
     */
    @PostMapping("queryAll")
    public ResponseEntity queryAll(@RequestBody ResourceEntity resourceEntity) {
        return resourcesService.queryAll(resourceEntity);
    }

    @PostMapping("addResource")
    public ResponseEntity addResource(@RequestBody ResourceEntity resourceEntity) {
        return resourcesService.addResource(resourceEntity);
    }

    @PostMapping("getById")
    public ResponseEntity getById(@RequestBody ResourceEntity resourceEntity) {
        System.out.println(resourceEntity.getId());
        return resourcesService.getById(resourceEntity.getId());
    }

}
