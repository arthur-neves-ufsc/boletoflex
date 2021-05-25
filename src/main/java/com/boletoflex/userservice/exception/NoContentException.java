package com.boletoflex.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoContentException() {
        super("no_content");
    }

}
