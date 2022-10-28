package org.example;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.example.factory.UserFactory;
import org.example.model.CreatedUserMessage;
import org.example.model.Details;
import org.example.model.User;
import org.example.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.example.constant.ResponseMessages.emailExists;
import static org.example.constant.ResponseMessages.usernameExists;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserFactory userFactory;

    @Test
    public void createUser() {
        User user = userFactory.generateRandomUser();
        CreatedUserMessage userMessage = usersService.createUser(user);
        log.info("created user" + userMessage.toString());
        List<Details> users = usersService.getUserById(userMessage.details.id);
        assertEquals(userMessage.details, users.get(0));
    }

    @Test
    public void sameUsernameOrEmail() {
        User user = userFactory.generateRandomUser();
        CreatedUserMessage userMessage = usersService.createUser(user);
        log.info("created user" + userMessage.toString());
        assertWithCatch(user, HttpStatus.BAD_REQUEST, usernameExists);
        user.username = userFactory.generateRandomUsername();
        assertWithCatch(user, HttpStatus.BAD_REQUEST, emailExists);
    }

    public void assertWithCatch(User user, HttpStatus httpStatus, String message) {
        try {
            usersService.createUser(user);
        } catch (FeignException.FeignClientException e) {
            assertEquals(e.status(), httpStatus.value());
            Assertions.assertTrue(e.getMessage().contains(message));
        }
    }
}


