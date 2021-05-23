package com.ssu.archive.service;

import com.ssu.archive.dao.UserDao;
import com.ssu.archive.entity.UserAccount;

public class UserLogic {

    private final UserDao _userDao;

    public UserLogic (UserDao userDao)  {
        this._userDao = userDao;
    }

    public boolean registration(UserAccount userAccount) { return _userDao.registration(userAccount); }

    public boolean authorization(String login, String password) {
        return _userDao.auhtorization(login,password);
    }
}
