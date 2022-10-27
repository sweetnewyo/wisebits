package org.example;

import feign.FeignException;
import org.example.factory.UserFactory;
import org.example.model.CreatedUserMessage;
import org.example.model.Details;
import org.example.model.User;
import org.example.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<Details> users = usersService.getUserById(userMessage.details.id);
        assertEquals(userMessage.details, users.get(0));
    }

    public void assertWithCatch(User user) {
        try {
            usersService.createUser(user);
        } catch (FeignException.FeignClientException e) {
            assertEquals(e.status(), HttpStatus.BAD_REQUEST.value());
        }
    }
}


