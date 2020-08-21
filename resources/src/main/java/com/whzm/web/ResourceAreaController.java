package com.whzm.web;

import com.whzm.service.IResourceAreaService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.web
 * @Author: 吴严
 * @CreateTime: 2020-08-19 12:19
 * @Description:
 */
@RestController
public class ResourceAreaController {


    @Autowired
    private IResourceAreaService areaService;

    @GetMapping("queryAreas")
    public ResponseEntity queryAll() {
        return areaService.queryAll();
    }
}
