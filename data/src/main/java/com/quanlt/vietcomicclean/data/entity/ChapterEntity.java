package com.quanlt.vietcomicclean.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ChapterEntity implements Parcelable {
    private String title;
    private List<String> urls;

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeStringList(this.urls);
    }

    public ChapterEntity(String title) {
        this.title = title;
    }

    public ChapterEntity() {
    }

    protected ChapterEntity(Parcel in) {
        this.title = in.readString();
        this.urls = in.createStringArrayList();
    }

    public static final Creator<ChapterEntity> CREATOR = new Creator<ChapterEntity>() {
        @Override
        public ChapterEntity createFromParcel(Parcel source) {
            return new ChapterEntity(source);
        }

        @Override
        public ChapterEntity[] newArray(int size) {
            return new ChapterEntity[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        return this.title.equals(((ChapterEntity) obj).getTitle());
    }
}
