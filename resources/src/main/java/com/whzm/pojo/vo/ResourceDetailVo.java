package com.whzm.pojo.vo;

import com.whzm.pojo.Cooperation;
import com.whzm.pojo.Implementation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.pojo.vo
 * @Author: 吴严
 * @CreateTime: 2020-08-20 11:36
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDetailVo {

    private String resourceId;

    private String userId;

    private String name;

    private List<Implementation> implementations;

    private List<Cooperation> cooperations;

    private String company;

    private String number;

    private String detail;

    private String userName;

    private String phone;

    private String wechat;

}
