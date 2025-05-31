package com.vpnhead.api.repository;

import com.vpnhead.api.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // No extra methods needed for now
}
