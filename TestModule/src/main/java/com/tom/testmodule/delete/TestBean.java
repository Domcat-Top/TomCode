package com.tom.testmodule.delete;


import lombok.Data;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Tom
 * @date:
 * @description:
 */
@Data
// 标定这是一个实体
@Entity
// 表名
@Table(name = "myTest")
public class TestBean {
    // 主键
    @Id
    // 主键策略
    @GeneratedValue
    private Integer id;
    // 指定属性加载机制，比如懒加载，调用时才初始化
    @Basic(fetch = FetchType.LAZY)
    // 映射属性为数据库的大对象，如content，text等
    @Lob
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 其他注解功能
     * @JoinColumn 定义外键关联的字段名称
     * @OneToOne 关联关系
     * @OneToMany 与 @ManyToOne 可以相对存在，也可只存在一方
     * @ManyToMany 表示多对多，和 @OneToOne、@ManyToOne 一样也有单向、双向之分。单向双向和注解没有关系，只看实体类之间是否相互引用
     */
}












