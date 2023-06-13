package com.tom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

    // 查询所有的内容
    List<Blog> queryAll();

}
