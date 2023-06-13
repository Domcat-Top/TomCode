package com.tom.web;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tom.entity.Blog;
import com.tom.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
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

}















