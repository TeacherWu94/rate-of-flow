package com.whzm.web;

import com.whzm.service.IResourceImplService;
import com.whzm.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.web
 * @Author: 吴严
 * @CreateTime: 2020-08-19 15:52
 * @Description:
 */
@RestController
public class ResourceImplController {

    @Autowired
    private IResourceImplService implService;

    @GetMapping("queryImpls")
    public ResponseEntity queryImpls(){
        return implService.queryAll();
    }
}
