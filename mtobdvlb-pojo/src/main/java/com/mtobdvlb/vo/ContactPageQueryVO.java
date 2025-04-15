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
public class ContactPageQueryVO {
    /**
     * 地址
     */
    private String address;
    /**
     * 城市
     */
    private String city;
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 省份
     */
    private String province;
    private LocalDate date;
}
