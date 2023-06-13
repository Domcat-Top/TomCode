package com.tom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tom.entity.Blog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tom
 * @since 2023-06-13
 */
public interface IBlogService extends IService<Blog> {

    // 查询所有的内容
    List<Blog> queryAll();

}
