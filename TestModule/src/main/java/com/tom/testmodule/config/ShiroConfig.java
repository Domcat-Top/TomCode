package com.tom.testmodule.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Tom
 * @date:
 * @description: Shiro的配置类可以有多个，也可以有多个UserRealm实现类，实现多种不同的Shiro策略
 */
@Configuration
public class ShiroConfig {

    // 初始化
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // 把Shiro和UserRealm对象进行关联
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier(value = "userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 具体拦截策略，在这里配置
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier(value = "getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        // 实现 shiro 的内置过滤器
        /**
         * anon: 无需认证就可以访问
         * authc: 必须认证了才能访问
         * user: 必须拥有记住我功能才能用
         * perms: 拥有对某个资源的权限才能访问
         * role: 拥有某个角色权限
         */
        // 拦截
        Map<String, String> filter = new LinkedHashMap<>();
        // 授权，正常的情况下，未授权跳转到未授权页面
        filter.put("/user/add","perms[user:add]");
        bean.setFilterChainDefinitionMap(filter);
        // 设置登录的请求
        bean.setLoginUrl("/toLogin");
        // 未授权页面
        bean.setUnauthorizedUrl("/noAuth");
        return bean;
    }

}














