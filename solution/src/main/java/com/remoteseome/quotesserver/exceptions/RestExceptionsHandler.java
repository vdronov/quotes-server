package com.remoteseome.quotesserver.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Vasiliy Dronov
 */
@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handle(Throwable e, HttpServletRequest request) throws Exception {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStackTrace(ExceptionUtils.getStackTrace(e));
        errorDto.setShortMessage(ExceptionUtils.getRootCauseMessage(e));

        HttpStatus code = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof NotFoundException){
            code = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<ErrorDto>(errorDto, code);
    }
}
