package org.example.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class CreatedUserMessage {
    public boolean success;
    public Details details;
    public String message;
}
