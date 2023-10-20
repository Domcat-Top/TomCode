package com.tom.testmodule.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.testmodule.entity.Blog;
import com.tom.testmodule.mapper.BlogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tom
 * @since 2023-06-13
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Resource
    private BlogMapper blogMapper;
}
