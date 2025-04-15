package com.mtobdvlb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePageQueryVO {

    /**
     * id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;
    private Integer articleNumber;
}
