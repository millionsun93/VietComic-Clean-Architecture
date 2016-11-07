package com.quanlt.vietcomicclean.domain;

import java.util.Date;
import java.util.List;

public class Comic {
    private String id;
    private String title;
    private String status;
    private String source;
    private String description;
    private String thumbnail;
    private String latestChapter;
    private Date updateTime;
    private int viewers;
    private List<Chapter> chapters;
    private List<String> authors;
    private List<String> categories;

    public Comic(String id) {
        this.id = id;
    }

    public Comic() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getLastestChapter() {
        return latestChapter;
    }

    public void setLastestChapter(String lastestChapter) {
        this.latestChapter = lastestChapter;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLatestChapter() {
        return latestChapter;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "categories=" + categories +
                ", authors=" + authors +
                ", chapters=" + chapters +
                ", updateTime=" + updateTime +
                ", latestChapter='" + latestChapter + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
