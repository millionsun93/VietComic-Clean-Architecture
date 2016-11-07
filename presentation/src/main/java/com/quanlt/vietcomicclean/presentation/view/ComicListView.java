package com.quanlt.vietcomicclean.presentation.view;

import com.quanlt.vietcomicclean.presentation.model.ComicModel;

import java.util.Collection;

public interface ComicListView extends LoadDataView {
    void renderComicList(Collection<ComicModel> comicCollection);

    void viewComic(ComicModel comic);
}
