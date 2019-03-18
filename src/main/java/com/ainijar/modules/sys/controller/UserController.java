package com.ainijar.modules.sys.controller;

import com.ainijar.modules.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${adminPath}/user")
public class UserController  {

    @Autowired
    private IUserService iUserService;


}
