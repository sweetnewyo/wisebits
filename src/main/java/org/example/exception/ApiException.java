package org.example.exception;

import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ApiException extends Exception {
    public HttpStatus httpStatus;
    public Response.Body body;


    public ApiException(HttpStatus httpStatus, Response.Body body) {
        this.httpStatus = httpStatus;
        this.body = body;
    }

}
