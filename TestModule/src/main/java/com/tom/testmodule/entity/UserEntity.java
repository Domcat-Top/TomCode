package com.tom.testmodule.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Tom
 * @date: 2023/12/11 13:48
 * @description:
 */
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Long id;
    private String userName;
    private String passWord;

}
