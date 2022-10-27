package org.example.factory;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UserFactory {
    public User generateRandomUser() {
        int r = new Random().nextInt(1, 999);
        String username = RandomStringUtils.randomAlphabetic(r);
        String email = RandomStringUtils.randomAlphabetic(r) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(r);
        User user = new User();
        user.username = username;
        user.email = email;
        user.password = password;
        return user;
    }
}
