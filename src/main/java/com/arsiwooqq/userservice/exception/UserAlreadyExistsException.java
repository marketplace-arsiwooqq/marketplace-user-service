package com.arsiwooqq.userservice.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String identifier) {
        super("User " + identifier + " already exists!", HttpStatus.CONFLICT);
    }
}
