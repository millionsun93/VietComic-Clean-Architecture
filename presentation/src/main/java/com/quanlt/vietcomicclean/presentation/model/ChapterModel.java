package com.quanlt.vietcomicclean.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class ChapterModel implements Parcelable {
    private String title;
    private List<String> urls;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeStringList(this.urls);
    }

    public ChapterModel() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getUrls() {
        return urls;
    }

    protected ChapterModel(Parcel in) {
        this.title = in.readString();
        this.urls = in.createStringArrayList();
    }

    public static final Parcelable.Creator<ChapterModel> CREATOR = new Parcelable.Creator<ChapterModel>() {
        @Override
        public ChapterModel createFromParcel(Parcel source) {
            return new ChapterModel(source);
        }

        @Override
        public ChapterModel[] newArray(int size) {
            return new ChapterModel[size];
        }
    };
}
