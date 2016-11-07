package com.quanlt.vietcomicclean.domain;

import java.util.List;

public class Chapter {
    private String title;
    private List<String> urls;

    public Chapter() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public boolean equals(Object obj) {
        return this.title.equals(((Chapter) obj).getTitle());
    }
}
