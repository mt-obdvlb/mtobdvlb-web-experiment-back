package com.mtobdvlb.controller;

import com.mtobdvlb.entity.Article;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.result.Result;
import com.mtobdvlb.service.ArticleService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public Result save(@RequestBody Article article) {
        log.info("保存文章：{}", article);
        articleService.save(article);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Article article) {
        log.info("修改文章：{}", article);
        articleService.update(article);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Article> getById(@PathVariable Long id) {
        log.info("根据id查询文章：{}", id);
        Article article = articleService.getById(id);
        return Result.success(article);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("根据id删除文章：{}", id);
        articleService.delete(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> pageQuery(Integer page, Integer pageSize) {
        log.info("分页查询文章：{} {}", page, pageSize);
        PageResult pageResult = articleService.pageQuery(page, pageSize);
        return Result.success(pageResult);
    }

}
