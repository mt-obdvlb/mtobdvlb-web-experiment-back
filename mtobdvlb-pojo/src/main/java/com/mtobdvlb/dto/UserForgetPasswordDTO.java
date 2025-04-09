package com.mtobdvlb.dto;

import lombok.Data;

@Data
public class UserForgetPasswordDTO {
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String passwordConfirmation;
    /**
     * 用户名
     */
    private String username;
}
