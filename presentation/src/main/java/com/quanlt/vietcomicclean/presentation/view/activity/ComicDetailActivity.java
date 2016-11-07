package com.quanlt.vietcomicclean.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.presentation.di.HasComponent;
import com.quanlt.vietcomicclean.presentation.di.component.ComicComponent;
import com.quanlt.vietcomicclean.presentation.di.component.DaggerComicComponent;
import com.quanlt.vietcomicclean.presentation.di.module.ComicModule;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;

public class ComicDetailActivity extends BaseActivity implements HasComponent<ComicComponent> {

    private static final String INTENT_COMIC_PARAM = "Intent_Comic";
    private ComicComponent comicComponent;
    private ComicModel comicModel;

    public static Intent getCallingIntent(Context context, ComicModel comic) {
        Intent intent = new Intent(context, ComicDetailActivity.class);
        intent.putExtra(INTENT_COMIC_PARAM, comic);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        comicModel = getIntent().getParcelableExtra(INTENT_COMIC_PARAM);
        this.comicComponent = DaggerComicComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .comicModule(new ComicModule(comicModel.getId()))
                .build();
    }

    @Override
    public ComicComponent getComponent() {
        return comicComponent;
    }
}
