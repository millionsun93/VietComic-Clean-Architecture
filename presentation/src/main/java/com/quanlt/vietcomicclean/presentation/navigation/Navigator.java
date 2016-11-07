package com.quanlt.vietcomicclean.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.view.activity.ComicDetailActivity;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Navigator {
    @Inject
    public Navigator() {

    }

    public void navigateToComicList(Context context) {

    }

    public void navigateToComicDetails(Context context, ComicModel comicModel) {
        if (context != null) {
            Intent intent = ComicDetailActivity.getCallingIntent(context, comicModel);
            context.startActivity(intent);
        }
    }
}
