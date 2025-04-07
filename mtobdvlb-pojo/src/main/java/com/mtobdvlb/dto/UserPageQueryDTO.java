package com.mtobdvlb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserPageQueryDTO {
    private String username;
    private int page;
    private int pageSize;
    private LocalDate begin;
    private LocalDate end;
}
