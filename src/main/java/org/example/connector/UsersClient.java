package org.example.connector;

import org.example.model.CreatedUserMessage;
import org.example.model.Details;
import org.example.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service",
        url = "${users.service.url}")
public interface UsersClient {
    @PostMapping("/create")
    CreatedUserMessage createUser(@RequestBody User user);

    @GetMapping("/get")
    List<Details> getUserById(@RequestParam("id") long id);
}
