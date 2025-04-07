package com.mtobdvlb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String username;
    private Long id;
    private LocalDate birth_time;
}
