package com.tom.testmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.testmodule.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tom
 * @since 2023-06-13
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
