package com.ainijar.modules.sys.service.Impl;

import com.ainijar.modules.sys.dao.UserDao;
import com.ainijar.modules.sys.model.User;
import com.ainijar.modules.sys.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByLoginName(String username) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("login_name", username));
        return user;
    }
}
