package com.mtobdvlb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDTO {
    private String username;
    private Long id;
    private LocalDate birth_time;
    private String email;
    private String avatar;
}
