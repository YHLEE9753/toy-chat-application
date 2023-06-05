package com.toy.global.error;

import com.toy.global.error.dto.ErrorCode;
import com.toy.global.error.dto.ErrorResponse;
import com.toy.global.error.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException ex, BindingResult bindingResult) {
        log.info("Got BindException: {}", ex.getMessage(), ex);

        return ErrorResponseMapper.toErrorResponse(ErrorCode.INVALID_METHOD_ARGUMENT, bindingResult);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        log.info("Got BusinessException: {}", ex.getMessage(), ex);

        return ErrorResponseMapper.toErrorResponse(ex.getErrorCode());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {
        log.info("Got HttpRequestMethodNotSupportedException: {}", ex.getMessage(), ex);

        return ErrorResponseMapper.toErrorResponse(ErrorCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("Got Exception: {}", ex.getMessage(), ex);

        return ErrorResponseMapper.toErrorResponse(ErrorCode.UNKNOWN_SERVER_ERROR);
    }
}
