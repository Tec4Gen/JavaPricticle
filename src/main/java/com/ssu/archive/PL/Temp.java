package com.ssu.archive.PL;

import com.ssu.archive.dao.UserDao;
import com.ssu.archive.entity.UserAccount;
import com.ssu.archive.service.UserLogic;
import org.mindrot.jbcrypt.BCrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Temp {

    public static void main(String[] args) {
        UserLogic a = new UserLogic(new UserDao());
        var u = new UserAccount();

        u.setLogin("123");
        u.setFirstName("123123");
        u.setLastName("12312");

        String hashed = BCrypt.hashpw("111", BCrypt.gensalt());
        u.setHashPassword(hashed);
        a.registration(u);
        if(a.authorization(u.getLogin(), hashed)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
