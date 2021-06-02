package com.ssu.archive.service;
import com.ssu.archive.dao.UserDao;
import com.ssu.archive.entity.UserAccount;
import org.mindrot.jbcrypt.BCrypt;


public class UserLogic {

    private final UserDao _userDao;

    public UserLogic (UserDao userDao)  {
        this._userDao = userDao;
    }

    public boolean registration(UserAccount userAccount) {
        userAccount.setHashPassword(BCrypt.hashpw(userAccount.getHashPassword(), BCrypt.gensalt()));
        return _userDao.registration(userAccount);
    }

    public boolean authorization(String login, String password) {

        return _userDao.authorization(login,password);
    }
}
