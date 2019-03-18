package com.ainijar.modules.sys.controller;

import com.ainijar.modules.sys.model.User;
import com.ainijar.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("${adminPath}")
public class LoginController {

    /**
     * 管理基础路径
     */
    @Value("${adminPath}")
    protected String adminPath;

    @GetMapping("/login")
    public String login() {
        return "modules/login";
    }

    /**
     * 登录失败，真正登录的POST请求由SystemAuthorizingRealm完成
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = UserUtils.getPrincipal();
        if (user != null) {
            return "redirect:" + adminPath;
        }
        String username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String message = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")) {
            message = "用户或密码错误, 请重试.";
        }
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, exception);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, message);
        return "modules/login";
    }

    /**
     * 登录成功，进入管理首页
     */
    @RequestMapping
    public String index(HttpServletRequest request, HttpServletResponse response) {
        User user = UserUtils.getPrincipal();
        return "modules/index";
    }
}
