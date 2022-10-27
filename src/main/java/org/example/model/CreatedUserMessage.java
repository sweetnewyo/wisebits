package org.example.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatedUserMessage {
    public boolean success;
    public Details details;
    public String message;
}
