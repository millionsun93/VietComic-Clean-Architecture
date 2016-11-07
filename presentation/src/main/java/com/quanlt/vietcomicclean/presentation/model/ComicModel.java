package com.quanlt.vietcomicclean.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ComicModel implements Parcelable {
    private String id;
    private String title;
    private String status;
    private String source;
    private String description;
    private String thumbnail;
    private String latestChapter;
    private Date updateTime;
    private int viewers;
    private List<ChapterModel> chapters;
    private List<String> authors;
    private List<String> categories;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLatestChapter() {
        return latestChapter;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public int getViewers() {
        return viewers;
    }

    public List<ChapterModel> getChapters() {
        return chapters;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public void setChapters(List<ChapterModel> chapters) {
        this.chapters = chapters;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.status);
        dest.writeString(this.source);
        dest.writeString(this.description);
        dest.writeString(this.thumbnail);
        dest.writeString(this.latestChapter);
        dest.writeLong(this.updateTime != null ? this.updateTime.getTime() : -1);
        dest.writeInt(this.viewers);
        dest.writeList(this.chapters);
        dest.writeStringList(this.authors);
        dest.writeStringList(this.categories);
    }

    public ComicModel() {
    }

    protected ComicModel(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.status = in.readString();
        this.source = in.readString();
        this.description = in.readString();
        this.thumbnail = in.readString();
        this.latestChapter = in.readString();
        long tmpUpdateTime = in.readLong();
        this.updateTime = tmpUpdateTime == -1 ? null : new Date(tmpUpdateTime);
        this.viewers = in.readInt();
        this.chapters = new ArrayList<>();
        in.readList(this.chapters, ChapterModel.class.getClassLoader());
        this.authors = in.createStringArrayList();
        this.categories = in.createStringArrayList();
    }

    public static final Parcelable.Creator<ComicModel> CREATOR = new Parcelable.Creator<ComicModel>() {
        @Override
        public ComicModel createFromParcel(Parcel source) {
            return new ComicModel(source);
        }

        @Override
        public ComicModel[] newArray(int size) {
            return new ComicModel[size];
        }
    };
}
