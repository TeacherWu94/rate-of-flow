package com.whzm.mapper;

import com.whzm.pojo.Cooperation;
import com.whzm.pojo.ResourceCoop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.mapper
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:56
 * @Description:
 */
@Mapper
public interface ResourceCoopMapper {

    Integer add(ResourceCoop resourceCoop);

    @Select("select cooperation_id cooperationId,cooperation_name cooperationName from cooperation_type")
    List<Cooperation> queryAll();
}
