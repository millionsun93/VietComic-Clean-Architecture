package com.quanlt.vietcomicclean.presentation.presenter;

import com.quanlt.vietcomicclean.domain.Comic;
import com.quanlt.vietcomicclean.domain.exception.DefaultErrorBundle;
import com.quanlt.vietcomicclean.domain.exception.ErrorBundle;
import com.quanlt.vietcomicclean.domain.interactor.UseCase;
import com.quanlt.vietcomicclean.presentation.exception.ErrorMessageFactory;
import com.quanlt.vietcomicclean.presentation.mapper.ComicModelDataMapper;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.view.ComicDetailView;

import rx.Subscriber;

public class ComicDetailPresenter implements Presenter {
    private ComicDetailView comicDetailView;
    private final UseCase getComicDetailUseCase;
    private final ComicModelDataMapper comicModelDataMapper;

    public ComicDetailPresenter(UseCase getComicDetailUseCase, ComicModelDataMapper comicModelDataMapper) {
        this.getComicDetailUseCase = getComicDetailUseCase;
        this.comicModelDataMapper = comicModelDataMapper;
    }

    public void setView(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getComicDetailUseCase.unsubscribe();
        this.comicDetailView = null;
    }

    public void initialize() {
        loadComicDetail();
    }

    private void loadComicDetail() {
        hideRetryView();
        showLoadingView();
        getComicDetail();
    }

    private void showLoadingView() {
        comicDetailView.showLoading();
    }

    private void hideLoadingView() {
        comicDetailView.hideRetry();
    }

    private void showRetryView() {
        comicDetailView.showRetry("");
    }

    private void hideRetryView() {
        comicDetailView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(comicDetailView.context(), errorBundle.getException());
        comicDetailView.showError(errorMessage);
    }

    private void showComicDetailInView(Comic comic) {
        final ComicModel comicModel = comicModelDataMapper.transform(comic);
        this.comicDetailView.renderComic(comicModel);
    }

    private void getComicDetail() {
        getComicDetailUseCase.execute(new ComicDetailSubscriber());
    }

    private class ComicDetailSubscriber extends Subscriber<Comic> {
        @Override
        public void onCompleted() {
            hideLoadingView();
        }

        @Override
        public void onError(Throwable e) {
            hideLoadingView();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            showRetryView();
        }

        @Override
        public void onNext(Comic comic) {
            showComicDetailInView(comic);
        }
    }
}
