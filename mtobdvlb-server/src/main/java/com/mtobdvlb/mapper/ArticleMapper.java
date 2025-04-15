package com.mtobdvlb.mapper;

import com.github.pagehelper.Page;
import com.mtobdvlb.entity.Article;
import com.mtobdvlb.vo.ArticlePageQueryVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("select count(*) from article where user_id = #{id}")
    Integer getArticleNumberByUserId(Long id);

    @Insert("insert into article (title, content,  user_id) values (#{title}, #{content},  #{userId})")
    void save(Article article);

    @Select("select * from article where id = #{id}")
    Article getById(Long id);

    void update(Article article);

    @Delete("delete from article where id = #{id}")
    void delete(Long id);

    @Select("select * from article")
    Page<ArticlePageQueryVO> pageQuery();
}
