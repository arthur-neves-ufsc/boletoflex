package com.boletoflex.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String USER_WITHOUT_NAME = "user_without_name";
    public static final String USER_WITHOUT_EMAIL = "user_without_email";
    public static final String USER_WITHOUT_PHONE = "user_without_phone";
    
    public static final String ERROR_TO_SAVE_USER = "error_to_save_user";
    
    public static final String MIN_PHOTO_WIDTH_ERROR = "min_photo_width_error";
    public static final String MAX_PHOTO_FILE_SIZE = "max_photo_file_size";
    public static final String IMAGE_NOT_FOUND = "image_not_found";

    private String[] param;

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final String... param) {
        super(message);
        this.param = param;
    }

    public String[] getParam() {
        return param;
    }

}
