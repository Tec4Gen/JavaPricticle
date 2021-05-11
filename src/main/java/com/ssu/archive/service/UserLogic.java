package com.ssu.archive.service;

import com.ssu.archive.dao.UserDao;
import com.ssu.archive.entity.User;

import java.util.List;

public class UserLogic {
    private final UserDao _userDao;

    public UserLogic (UserDao userDao)  {
        this._userDao = userDao;
    }

    public boolean registration(User user) { return _userDao.registration(user); }

    public boolean authorization(String login, byte[] password) {
        return _userDao.auhtorization(login,password);
    }
}
