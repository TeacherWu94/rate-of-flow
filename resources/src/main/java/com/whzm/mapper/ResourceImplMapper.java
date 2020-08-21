package com.whzm.mapper;

import com.whzm.pojo.Cooperation;
import com.whzm.pojo.Implementation;
import com.whzm.pojo.ResourceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: rate-of-flow
 * @BelongsPackage: com.whzm.mapper
 * @Author: 吴严
 * @CreateTime: 2020-08-18 14:55
 * @Description:
 */
@Mapper
public interface ResourceImplMapper {

    Integer add(ResourceImpl resourceImpl);

    @Select("select implementation_id implementationId,implementation_name implementationName from flow_implementation")
    List<Implementation> queryAll();
}
