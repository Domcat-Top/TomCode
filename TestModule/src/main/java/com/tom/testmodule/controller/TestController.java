package com.tom.testmodule.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: Tom
 * @date: 2023/11/27 10:05
 * @description:
 */
@RestController
public class TestController {

    /**获取 druid 数据监控信息
     * http://127.0.0.1:8080/myDruid/stat
     */
    @GetMapping("myDruid/stat")
    public List<Map<String, Object>> druidStat() {
        List<Map<String, Object>> statDataList = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        return statDataList;
    }

}
