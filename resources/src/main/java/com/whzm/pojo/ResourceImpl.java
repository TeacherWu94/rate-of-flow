package com.whzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.pojo
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:36
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceImpl {
    private String id;
    private String resourcesId;
    private String implementationId;
}
