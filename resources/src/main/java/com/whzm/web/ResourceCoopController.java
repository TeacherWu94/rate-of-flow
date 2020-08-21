package com.whzm.web;

import com.whzm.service.IResourceCoopService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.web
 * @Author: 吴严
 * @CreateTime: 2020-08-19 15:56
 * @Description:
 */
@RestController
public class ResourceCoopController {

    @Autowired
    private IResourceCoopService coopService;

    @GetMapping("queryCoops")
    public ResponseEntity queryCoops() {
        return coopService.queryAll();
    }
}
