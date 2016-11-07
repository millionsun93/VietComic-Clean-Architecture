package com.quanlt.vietcomicclean.presentation.view;

import com.quanlt.vietcomicclean.presentation.model.ComicModel;


public interface ComicDetailView extends LoadDataView {
    void renderComic(ComicModel comic);
    void renderChapter(ComicModel comic);
}
