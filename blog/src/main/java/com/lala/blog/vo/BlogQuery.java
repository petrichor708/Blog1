package com.lala.blog.vo;

import lombok.Data;

@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    public BlogQuery(String title, Long typeId, Boolean recommend) {
        this.title = title;
        this.typeId = typeId;
        this.recommend = recommend;
    }
}