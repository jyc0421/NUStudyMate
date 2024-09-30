package com.jyc.nustudymate.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author jyc
 * @Date 2024/9/30 2:55
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
