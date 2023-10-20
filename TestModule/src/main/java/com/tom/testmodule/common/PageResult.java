package com.tom.testmodule.common;

import lombok.Data;

/**
 * @author: Tom
 * @date: 2023/8/10 13:13
 * @description:
 */
@Data
public class PageResult {

    private int pageNum = 1;
    private int pageSize = 5;
}
