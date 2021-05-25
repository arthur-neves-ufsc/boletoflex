package com.boletoflex.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public static final String USER_NOT_FOUND = "user_not_found";

    public NotFoundException(String message) {
        super(message);
    }

}
