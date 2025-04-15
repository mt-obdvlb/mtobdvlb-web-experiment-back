package com.mtobdvlb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.dto.ArticleListDTO;
import com.mtobdvlb.entity.Article;
import com.mtobdvlb.exception.ArticleException;
import com.mtobdvlb.mapper.ArticleMapper;
import com.mtobdvlb.mapper.UserMapper;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.service.ArticleService;
import com.mtobdvlb.vo.ArticlePageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(Article article) {
        articleMapper.save(article);
    }

    @Override
    public void update(Article article) {
        if(articleMapper.getById(article.getId()) == null) {
            throw new ArticleException(MessageConstant.ARTICLE_NOT_EXIST);
        }
        articleMapper.update(article);
    }

    @Override
    public Article getById(Long id) {
        Article article = articleMapper.getById(id);
        if(article == null) {
            throw new ArticleException(MessageConstant.ARTICLE_NOT_EXIST);
        }
        return article;
    }

    @Override
    public void delete(Long id) {
        Article article = articleMapper.getById(id);
        if(article == null) {
            throw new ArticleException(MessageConstant.ARTICLE_NOT_EXIST);
        }
        articleMapper.delete(id);
    }

    @Override
    public PageResult pageQuery(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<ArticlePageQueryVO> pageVO = articleMapper.pageQuery();
        long total = pageVO.getTotal();
        List<ArticlePageQueryVO> records = pageVO.getResult();
        return new PageResult(total, records);
    }

    @Override
    public List<Article> list(ArticleListDTO articleListDTO) {
        return articleMapper.list(articleListDTO);
    }
}
