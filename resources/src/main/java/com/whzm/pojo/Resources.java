package com.whzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.pojo
 * @Author: 吴严
 * @CreateTime: 2020-08-12 20:18
 * @Description: 资源实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources implements Serializable {
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
     * 资源流量变现额;可变现流量数
     */
    private String number;

    /**
     * 资源流量平台;从用户表中获取
     */
    private String company;

    /**
     * 资源发布时间;首次自动创建
     */
    private String createTime;
    /**
     * 资源状态;1，已匹配；0，未匹配
     */
    private Integer status;
    /**
     * 更新人;从用户表中获取
     */
    private String updateUser;
    /**
     * 更新时间;时间戳更新
     */
    private String updateTime;
    /**
     * 是否删除;1，已删除；0，正常
     */
    private Integer isDeleted;


    //资源详情描述
    private String detail;


}
