package com.whzm.pojo.vo;

import com.whzm.pojo.Area;
import com.whzm.pojo.Cooperation;
import com.whzm.pojo.Implementation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.pojo
 * @Author: 吴严
 * @CreateTime: 2020-08-14 11:45
 * @Description: 封装资源大厅列表往前端展示
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcesListVo {
    //主键
    private String id;
    /**
     * 资源类型;资源的类型（1，流量；2，广告）
     */
    private Integer type;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源发布人;关联用户表主键
     */
    private String userId;
    /**
     * 资源流量落地类型;关联流量落地类型主键
     */
    private List<Implementation> implementations;
    /**
     * 资源流量所在区域;关联广告流量区域主键
     */
    private List<Area> areas;

    /**
     * 资源流量合作方式;关联流量合作方式
     */
    private List<Cooperation> cooperations;

    /**
     * 资源流量平台;从用户表中获取
     */
    private String company;

    /**
     * 资源发布时间;首次自动创建
     */
    private String createTime;


}
