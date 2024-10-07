package com.jyc.nustudymate.exception;

import com.jyc.nustudymate.common.BaseResponse;
import com.jyc.nustudymate.common.ErrorCode;
import com.jyc.nustudymate.common.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author jyc
 * @Date 2024/10/8 0:39
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        return ResponseUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException: " + e.getMessage(), e);
        return ResponseUtils.error(ErrorCode.SYSTEM_ERROR);
    }
}
