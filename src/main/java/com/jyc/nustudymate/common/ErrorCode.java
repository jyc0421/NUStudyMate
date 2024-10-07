package com.jyc.nustudymate.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 错误码
 *
 * @Author jyc
 * @Date 2024/10/6 23:13
 */

public enum ErrorCode {
    SUCCESS(0, "ok", ""),
    PARAMS_ERROR(40000, "请求参数错误", "请求参数错误"),
    NOT_LOGIN(40100, "未登录", "未登录"),
    NO_AUTH(40101, "无权限", "无权限"),
    SYSTEM_ERROR(50000, "系统内部异常", "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败", "操作失败"),
    NOT_FOUND(40400, "未找到", "未找到"),
    REPEAT_ERROR(40001, "重复操作", "重复操作");

    private final int code;
    private final String description;
    private final String message;

    ErrorCode(int code, String description, String message) {
        this.code = code;
        this.description = description;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public String getMessage() {
        return message;
    }

}
