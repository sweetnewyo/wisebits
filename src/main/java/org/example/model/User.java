package org.example.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class User {
    public String username;
    public String email;
    public String password;
}
