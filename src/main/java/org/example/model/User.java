package org.example.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.ToString;

@JsonAutoDetect
@ToString
public class User {
    public String username;
    public String email;
    public String password;
}
