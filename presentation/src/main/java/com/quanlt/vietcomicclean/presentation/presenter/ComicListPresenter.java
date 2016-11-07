package com.quanlt.vietcomicclean.presentation.presenter;

import android.os.Looper;
import android.util.Log;

import com.quanlt.vietcomicclean.domain.Comic;
import com.quanlt.vietcomicclean.domain.exception.DefaultErrorBundle;
import com.quanlt.vietcomicclean.domain.exception.ErrorBundle;
import com.quanlt.vietcomicclean.domain.interactor.DefaultSubscriber;
import com.quanlt.vietcomicclean.domain.interactor.GetComicList;
import com.quanlt.vietcomicclean.domain.interactor.UseCase;
import com.quanlt.vietcomicclean.presentation.di.PerActivity;
import com.quanlt.vietcomicclean.presentation.exception.ErrorMessageFactory;
import com.quanlt.vietcomicclean.presentation.mapper.ComicModelDataMapper;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.view.ComicListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by quanlt on 06/11/2016.
 */
@PerActivity
public class ComicListPresenter implements Presenter {
    private ComicListView comicListView;
    private final GetComicList getComicListUseCase;
    private final ComicModelDataMapper comicModelDataMapper;
    private boolean isLoading = false;
    private int page = 1;

    @Inject
    public ComicListPresenter(@Named("comicList") UseCase getComicListUseCase,
                              ComicModelDataMapper comicModelDataMapper) {
        this.getComicListUseCase = (GetComicList) getComicListUseCase;
        this.comicModelDataMapper = comicModelDataMapper;
    }

    public void setView(ComicListView view) {
        this.comicListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getComicListUseCase.unsubscribe();
        this.comicListView = null;
    }

    public void initialize() {
        this.loadComicList();
    }

    public void loadMore() {
        if (isLoading) {
            return;
        }
        isLoading = true;
        page++;
        getComicList();
    }

    private void loadComicList() {
        hideRetryView();
        showLoadingView();
        getComicList();
    }

    public void onComicClicked(ComicModel comicModel) {
        comicListView.viewComic(comicModel);
    }

    private void showLoadingView() {
        this.comicListView.showLoading();
    }

    private void hideLoadingView() {
        this.comicListView.hideLoading();
    }

    private void showRetryView() {
        this.comicListView.showRetry("");
    }

    private void hideRetryView() {
        this.comicListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.comicListView.context(),
                errorBundle.getException());
        this.comicListView.showError(errorMessage);
    }

    private void showComicsCollectionInView(Collection<Comic> comicCollection) {
        final Collection<ComicModel> comicModelCollection = comicModelDataMapper.transform(comicCollection);
        this.comicListView.renderComicList(comicModelCollection);
    }

    private void getComicList() {
        this.getComicListUseCase.setPage(page).execute(new ComicListSubscriber());
    }

    private final class ComicListSubscriber extends DefaultSubscriber<List<Comic>> {
        @Override
        public void onCompleted() {
            hideLoadingView();
            isLoading = false;
        }

        @Override
        public void onError(Throwable e) {
            Log.d(getClass().getSimpleName(), e.getMessage());
            hideLoadingView();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            showRetryView();
            isLoading = false;
        }

        @Override
        public void onNext(List<Comic> comics) {
            showComicsCollectionInView(comics);
        }
    }
}
