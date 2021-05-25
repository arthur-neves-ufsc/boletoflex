package com.boletoflex.userservice.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDTO {

    public static final String UNEXPECTED_ERROR = "unexpected_error";
    private Date timestamp;

    private Integer status;

    private String error;

    private String messageKey;

    private String message;

    private String path;
    private String[] param;
}
