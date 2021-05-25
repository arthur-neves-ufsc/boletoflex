package com.boletoflex.userservice.controller;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.boletoflex.userservice.dto.ErrorDTO;
import com.boletoflex.userservice.exception.BusinessException;
import com.boletoflex.userservice.exception.NotFoundException;
import com.boletoflex.userservice.util.Utils;

public abstract class ApiController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleEntityNotFoundException(final Exception ex, final WebRequest request) throws Throwable {
        return handleBusinessException(null, request);
    }
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(final WebRequest request) {
        final ErrorDTO error = new ErrorDTO();
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        error.setTimestamp(new Date());
        error.setStatus(httpStatus.value());
        error.setError(httpStatus.getReasonPhrase());
        error.setMessageKey(ErrorDTO.UNEXPECTED_ERROR);
        error.setMessage(messageSource.getMessage(error.getMessageKey(), null, ErrorDTO.UNEXPECTED_ERROR, Utils.getLocale(getLanguage())));
        error.setPath(request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(error, httpStatus);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<Object> handleBusinessException(final BusinessException ex, final WebRequest request) {
        String businessException = "";
        final ErrorDTO error = new ErrorDTO();
        if (ex != null) {
            businessException = ex.getMessage();
            error.setParam(ex.getParam());
        }
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        error.setTimestamp(new Date());
        error.setStatus(httpStatus.value());
        error.setError(httpStatus.getReasonPhrase());
        final String messageKey = StringUtils.isNotBlank(businessException) ? businessException : ErrorDTO.UNEXPECTED_ERROR;
        error.setMessageKey(messageKey);
        error.setMessage(messageSource.getMessage(error.getMessageKey(), null, ErrorDTO.UNEXPECTED_ERROR, Utils.getLocale(getLanguage())));
        error.setPath(request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(error, httpStatus);
    }

	private String getLanguage() {
		
		
		return null;
	}
}
