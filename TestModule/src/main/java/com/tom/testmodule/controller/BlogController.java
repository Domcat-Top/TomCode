package com.tom.testmodule.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.tom.testmodule.common.Result;
import com.tom.testmodule.entity.Blog;
import com.tom.testmodule.service.IBlogService;
import com.tom.testmodule.vo.TestResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author tom
 * @since 2023-06-13
 */
@RestController
@RequestMapping("/pageTest")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/testGet/{pageNum}")
    public Result test(@PathVariable int pageNum) {
        PageHelper.startPage(pageNum);
        List<Blog> list = iBlogService.list(null);
        return Result.ok(list);
    }


}



































