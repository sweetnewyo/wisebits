package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.connector.UsersClient;
import org.example.model.CreatedUserMessage;
import org.example.model.Details;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersClient usersClient;

    public CreatedUserMessage createUser(User user) throws UndeclaredThrowableException {
        return usersClient.createUser(user);
    }

    public List<Details> getUserById(long id) {
        return usersClient.getUserById(id);
    }
}

