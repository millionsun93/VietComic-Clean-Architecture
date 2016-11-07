package com.quanlt.vietcomicclean.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComicEntity implements Parcelable {
    @SerializedName("_id")
    private String id;
    private String title;
    private String status;
    private String source;
    private String description;
    private String thumbnail;
    private String latestChapter;
    private Date updateTime;
    private int viewers;
    private List<ChapterEntity> chapters;
    private List<String> authors;
    private List<String> categories;

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

    public List<ChapterEntity> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterEntity> chapters) {
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
        dest.writeInt(this.viewers);
        dest.writeString(this.latestChapter);
        dest.writeLong(this.updateTime != null ? this.updateTime.getTime() : -1);
        dest.writeList(this.chapters);
        dest.writeStringList(this.authors);
        dest.writeStringList(this.categories);
    }

    public ComicEntity() {
    }

    protected ComicEntity(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.status = in.readString();
        this.source = in.readString();
        this.description = in.readString();
        this.thumbnail = in.readString();
        this.viewers = in.readInt();
        this.latestChapter = in.readString();
        long tmpUpdateTime = in.readLong();
        this.updateTime = tmpUpdateTime == -1 ? null : new Date(tmpUpdateTime);
        this.chapters = new ArrayList<>();
        in.readList(this.chapters, ChapterEntity.class.getClassLoader());
        this.authors = in.createStringArrayList();
        this.categories = in.createStringArrayList();
    }

    public static final Creator<ComicEntity> CREATOR = new Creator<ComicEntity>() {
        @Override
        public ComicEntity createFromParcel(Parcel source) {
            return new ComicEntity(source);
        }

        @Override
        public ComicEntity[] newArray(int size) {
            return new ComicEntity[size];
        }
    };
}
