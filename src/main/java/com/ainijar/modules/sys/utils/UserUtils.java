package com.ainijar.modules.sys.utils;

import com.ainijar.modules.sys.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 用户工具类
 */
public class UserUtils {

    /**
     * 获取当前登录者对象
     */
    public static User getPrincipal() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (user != null) {
            return user;
        }
        return null;
    }

}
