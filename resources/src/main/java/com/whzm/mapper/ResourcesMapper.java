package com.whzm.mapper;

import com.whzm.pojo.Resources;
import com.whzm.pojo.vo.ResourceDetailVo;
import com.whzm.pojo.vo.ResourcesListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.mapper
 * @Author: 吴严
 * @CreateTime: 2020-08-13 15:05
 * @Description:
 */
@Mapper
public interface ResourcesMapper {

    List<ResourcesListVo> queryAll(@Param("type") Integer type);

    Integer addResource(Resources resources);

    List<ResourceDetailVo> getById(String id);
}
