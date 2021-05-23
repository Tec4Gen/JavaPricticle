package com.ssu.archive.PL;

import com.ssu.archive.dao.UserDao;
import com.ssu.archive.entity.UserAccount;
import com.ssu.archive.service.UserLogic;

public class Temp {
    public static void main(String[] args) {
        UserLogic a = new UserLogic(new UserDao());
        var u = new UserAccount();

        u.setLogin("125");
        u.setFirstName("123123");
        u.setLastName("12312");
        u.setHashPassword(new byte[] {1,2,2});
        a.registration(u);
    }
}
