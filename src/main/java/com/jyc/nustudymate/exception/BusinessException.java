package com.jyc.nustudymate.exception;

import com.jyc.nustudymate.common.ErrorCode;

/**
 * @Author jyc
 * @Date 2024/10/7 0:51
 */

public class BusinessException extends RuntimeException {
    private final int code;
    private final String description;

    public BusinessException(String message, int code, String description)
    {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode)
    {
        this(errorCode.getMessage(), errorCode.getCode(), errorCode.getDescription());
    }

    public BusinessException(ErrorCode errorCode, String description)
    {
        this(errorCode.getMessage(), errorCode.getCode(), description);
    }

    public int getCode()
    {
        return code;
    }

    public String getDescription()
    {
     return description;
    }
}
