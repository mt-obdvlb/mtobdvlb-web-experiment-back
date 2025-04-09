package com.mtobdvlb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO {
    private String username;
    private Long id;
    private String token;
    private String avatar;
    private String email;
    private LocalDate birthTime;
}
