package com.whzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.pojo
 * @Author: 吴严
 * @CreateTime: 2020-08-18 11:17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceEntity {
    private String id;

    private Integer type;

    private String name;

    private String userId;

    private String company;

    private String number;

    private String detail;

    private String areaIds;

    private String implIds;

    private String coopIds;

    private Integer page;

    private Integer pageSize;

}
