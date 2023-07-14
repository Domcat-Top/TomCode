package com.tom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.tom.entity.Blog;
import com.tom.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tom
 * @since 2023-06-13
 */
@RestController
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    // 测试接口通了没
    @GetMapping("/test/{pageNum}")
    public String test(@PathVariable("pageNum") int pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Blog> list = iBlogService.queryAll();

        StringBuffer sb = new StringBuffer();
        list.forEach((blog) -> {
            sb.append(blog.getId() + " ");
        });
        return sb.toString();
    }

    /**
     * 测试plus是否正确
     * @return
     */
    @GetMapping("/wrapper")
    public String testWrapper() {
        // 这个不能简写，不能写为继承的写法，他底层貌似是独立封装的，子类没有全部继承自父类
        QueryWrapper<Blog> queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("id");
        PageHelper.startPage(1, 2);
        List<Blog> list = iBlogService.list(queryWrapper);
        list.forEach((blog) -> {
            System.out.println(blog.getBlogName() + "*****");
        });
        return null;
    }
}















