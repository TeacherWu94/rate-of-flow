package com.whzm.mapper;

import com.whzm.pojo.Area;
import com.whzm.pojo.ResourceArea;
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
public interface ResourceAreaMapper {

    Integer add(ResourceArea resourceArea);

    @Select("select area_id areaId,address_detail addressDetail from flow_area")
    List<Area> queryAll();
}
