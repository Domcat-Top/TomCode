package com.tom.testmodule.delete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.util.List;

/**
 * @author: Tom
 * @date:
 * @description:
 */
// 泛型中的TestBean表示的是哪个实体类，Integer表示的是主键类型
public interface TestBeanDao extends JpaRepository<TestBean, Integer> {
    // 示例
    @Query("sql")
    List<TestBean> queryAll();
}
