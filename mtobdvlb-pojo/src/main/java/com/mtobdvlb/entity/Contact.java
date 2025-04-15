package com.mtobdvlb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    /**
     * 地址
     */
    private String address;
    /**
     * 城市
     */
    private String city;
    /**
     * 日期
     */
    private String date;
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
    /**
     * 用户id
     */
    private Long userId;
}