package com.jyc.nustudymate.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author jyc
 * @Date 2024/9/30 3:03
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;
    private String userAccount;
    private String userPassword;
}
