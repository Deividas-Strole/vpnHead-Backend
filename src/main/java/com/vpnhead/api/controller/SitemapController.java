package com.vpnhead.api.controller;

import com.vpnhead.api.model.Article;
import com.vpnhead.api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletResponse;
// Correct for Spring Boot 3.x+
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@RestController
public class SitemapController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public void sitemap(HttpServletResponse response) throws IOException {
        List<Article> articles = articleRepository.findAll();

        StringBuilder sitemap = new StringBuilder();
        sitemap.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sitemap.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");

        sitemap.append("  <url>\n");
        sitemap.append("    <loc>").append("https://vpnHead.com").append("</loc>\n");
        sitemap.append("    <changefreq>daily</changefreq>\n");
        sitemap.append("    <priority>1.0</priority>\n");
        sitemap.append("  </url>\n");

        for (Article article : articles) {
            sitemap.append("  <url>\n");
            sitemap.append("    <loc>").append("https://vpnHead.com/article/").append(article.getId()).append("</loc>\n");
            sitemap.append("    <changefreq>weekly</changefreq>\n");
            sitemap.append("    <priority>0.8</priority>\n");
            sitemap.append("  </url>\n");
        }

        sitemap.append("</urlset>");

        response.setContentType("application/xml");
        response.getWriter().write(sitemap.toString());
    }
}
