package com.quanlt.vietcomicclean.presentation.view;

import android.content.Context;
import android.support.annotation.Nullable;


public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showRetry(@Nullable String message);

    void hideRetry();

    void showError(String message);

    Context context();

}
