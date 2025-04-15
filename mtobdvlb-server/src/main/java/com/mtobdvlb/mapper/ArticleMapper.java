package com.mtobdvlb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("select count(*) from article where user_id = #{id}")
    Integer getArticleNumberByUserId(Long id);
}
