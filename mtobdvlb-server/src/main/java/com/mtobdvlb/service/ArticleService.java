package com.mtobdvlb.service;

import com.mtobdvlb.dto.ArticleListDTO;
import com.mtobdvlb.entity.Article;
import com.mtobdvlb.result.PageResult;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    void update(Article article);

    Article getById(Long id);

    void delete(Long id);

    PageResult pageQuery(Integer page, Integer pageSize);

    List<Article> list(ArticleListDTO articleListDTO);
}
