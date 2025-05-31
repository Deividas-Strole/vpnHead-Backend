package com.vpnhead.api.dto;

public class ArticleTitleDTO {
    private Long id;
    private String title;

    public ArticleTitleDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
