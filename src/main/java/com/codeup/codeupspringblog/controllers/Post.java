package com.codeup.codeupspringblog.controllers;

public class Post {
    private String title;
    private String body;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}