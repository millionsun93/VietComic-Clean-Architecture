package com.quanlt.vietcomicclean.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.domain.Comic;
import com.quanlt.vietcomicclean.presentation.di.component.ComicComponent;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.presenter.ComicListPresenter;
import com.quanlt.vietcomicclean.presentation.view.ComicListView;
import com.quanlt.vietcomicclean.presentation.view.adapter.ComicsAdapter;
import com.quanlt.vietcomicclean.presentation.view.util.ComicSelectedListener;
import com.quanlt.vietcomicclean.presentation.view.util.EndlessRecyclerViewOnScrollListener;
import com.quanlt.vietcomicclean.presentation.view.util.OnItemClickListener;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComicListFragment extends BaseFragment implements ComicListView, OnItemClickListener {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rl_progress)
    RelativeLayout progressView;
    @BindView(R.id.rv_comics)
    RecyclerView comicRecyclerView;
    @BindView(R.id.rl_retry)
    RelativeLayout retryView;
    private EndlessRecyclerViewOnScrollListener endlessRecyclerViewOnScrollListener;
    @Inject
    ComicListPresenter comicListPresenter;

    @Inject
    ComicsAdapter comicsAdapter;

    private ComicSelectedListener comicSelectedListener;
    private GridLayoutManager gridLayoutManager;

    public ComicListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComicSelectedListener) {
            comicSelectedListener = (ComicSelectedListener) context;
        } else {
            throw new IllegalStateException(context.toString() + " must implement " + comicSelectedListener.getClass().getSimpleName());
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ComicComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_comic_list, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.comicListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.comicListPresenter.initialize();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        comicListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        comicListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        comicRecyclerView.setAdapter(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.comicListPresenter.destroy();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        comicSelectedListener = null;
    }

    private void setupRecyclerView() {
        comicsAdapter.setOnItemClickListener(this);
        comicRecyclerView.setAdapter(comicsAdapter);
        gridLayoutManager = new GridLayoutManager(getActivity(), context().getResources().getInteger(R.integer.comics_column));
        comicRecyclerView.setLayoutManager(gridLayoutManager);
        comicRecyclerView.setItemAnimator(new DefaultItemAnimator());
        endlessRecyclerViewOnScrollListener = new EndlessRecyclerViewOnScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore() {
                comicListPresenter.loadMore();
            }
        };
        comicRecyclerView.addOnScrollListener(endlessRecyclerViewOnScrollListener);

    }


    @Override
    public void renderComicList(Collection<ComicModel> comicCollection) {
        endlessRecyclerViewOnScrollListener.setLoading(false);
        if (comicsAdapter != null) {
            comicsAdapter.setComicList(comicCollection);
        }
    }

    @Override
    public void viewComic(ComicModel comic) {
        comicSelectedListener.onComicSelected(comic);
    }

    @Override
    public void showLoading() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressView.setVisibility(View.GONE);
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
        Snackbar.make(swipeRefreshLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    @Override
    public void onItemClickListener(ComicModel comic) {
        comicListPresenter.onComicClicked(comic);
    }

    @OnClick(R.id.rl_retry)
    void onRetryClick() {
        comicListPresenter.initialize();
    }
}
