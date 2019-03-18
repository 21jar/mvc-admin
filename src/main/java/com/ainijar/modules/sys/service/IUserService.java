package com.ainijar.modules.sys.service;

import com.ainijar.modules.sys.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {

    User getUserByLoginName(String username);
}
