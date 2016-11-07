package com.quanlt.vietcomicclean.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.presenter.ComicDetailPresenter;
import com.quanlt.vietcomicclean.presentation.view.ComicDetailView;
import com.quanlt.vietcomicclean.presentation.view.ui.ImageAspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.gujun.android.taggroup.TagGroup;


public class ComicDetailFragment extends BaseFragment implements ComicDetailView {

    ComicDetailPresenter comicDetailPresenter;
    @BindView(R.id.iv_comic_thumbnail)
    ImageAspect thumbnailImageView;
    @BindView(R.id.tv_title)
    TextView titleTextView;
    @BindView(R.id.tv_update_time)
    TextView updateTimeTextView;
    @BindView(R.id.tv_viewer_count)
    TextView viewerCountTextView;
    @BindView(R.id.tg_categories)
    TagGroup categoriesTagGroup;
    @BindView(R.id.tg_author)
    TagGroup authorTagGroup;
    @BindView(R.id.tv_description)
    TextView descriptionTextView;
    @BindView(R.id.cv_description)
    CardView descriptionCardView;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.iv_retry_view)
    ImageView retryView;
    @BindView(R.id.rv_chapters)
    RecyclerView chptersRecyclerView;
    @BindView(R.id.cv_chapters)
    CardView chapterCardView;

    private final DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();

    public ComicDetailFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_comic_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        comicDetailPresenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        comicDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        comicDetailPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        comicDetailPresenter.destroy();
    }

    @Override
    public void renderComic(ComicModel comic) {
        if (comic != null) {
            titleTextView.setText(comic.getTitle());
            updateTimeTextView.setText(dateFormat.format(comic.getUpdateTime()));
            viewerCountTextView.setText(comic.getViewers());
            authorTagGroup.setTags(comic.getAuthors());
            categoriesTagGroup.setTags(comic.getCategories());
            Glide.with(this).load(comic.getThumbnail())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .centerCrop()
                    .into(thumbnailImageView);
            if (TextUtils.isEmpty(comic.getDescription())) {
                descriptionCardView.setVisibility(View.GONE);
            } else {
                descriptionCardView.setVisibility(View.VISIBLE);
                descriptionTextView.setText(comic.getDescription());
            }
        }
    }

    @Override
    public void renderChapter(ComicModel comic) {
        if (comic.getChapters() != null && comic.getChapters().size() > 0) {
            chapterCardView.setVisibility(View.VISIBLE);
        } else {
            chapterCardView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showRetry(String message) {
        retryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        retryView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    @OnClick(R.id.iv_retry_view)
    public void onClick() {

    }
}
