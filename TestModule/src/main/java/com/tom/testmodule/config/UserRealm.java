package com.tom.testmodule.config;

import com.tom.testmodule.service.UserService;
import com.tom.testmodule.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * @author: Tom
 * @date:
 * @description:
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    // 如果涉及到操作数据库的内容，则需要在这里引入
    @Resource
    private UserService userService;

    /**
     * 认证方法
     * @param authenticationToken the authentication token containing the user's principal and credentials.
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了 => 认证doGetAuthorizationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        // 调库
        User user = userService.queryUserByName(userToken.getUsername());
        // 没有这个人
        if (user == null) {
            // UnknownAccountException
            return null;
        }
//        如果是存放在Session中的，也可以这样操作
//        Subject currentSubject = SecurityUtils.getSubject();
//        Session session = currentSubject.getSession();
//        session.setAttribute("loginUser",user);

        // 可以加密，MD5:e10adc3949ba59abbe56e057f20f883e  MD5:盐值加密
        // 密码认证，shiro做
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了 => 授权doGetAuthorizationInfo");
        // SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        // 拿到User
        User currentUser = (User) subject.getPrincipal();
        // 设置当前用户的权限
        // 如果存在多个权限，则对字符串进行一个分割，比如按照 ； | 等分隔符进行分割，然后进行addStringPermission
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

}










