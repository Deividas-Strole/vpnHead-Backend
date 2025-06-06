package com.vpnhead.api.controller;

import com.vpnhead.api.dto.ArticleTitleDTO;
import com.vpnhead.api.model.Article;
import com.vpnhead.api.service.ArticleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/api/articles/titles")
    public List<ArticleTitleDTO> getArticleTitles() {
        return service.getAllArticleTitles();
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return service.getArticle(id);
    }

}
