package com.mtobdvlb.dto;

import lombok.Data;

@Data
public class ContactPageQueryDTO {
    /**
     * 名字
     */
    private String name;
    /**
     * 页数
     */
    private Integer page;
    /**
     * 页码数量
     */
    private Integer pageSize;
    /**
     * 用户id
     */
    private Long userId;
}
