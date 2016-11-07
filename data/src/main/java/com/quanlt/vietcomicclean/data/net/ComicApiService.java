package com.quanlt.vietcomicclean.data.net;

import com.quanlt.vietcomicclean.data.entity.ChapterEntity;
import com.quanlt.vietcomicclean.data.entity.ComicEntity;
import com.quanlt.vietcomicclean.data.entity.ComicResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface ComicApiService {
    @GET("comics")
    Observable<ComicResponse<List<ComicEntity>>> getComics(@Query("page") Integer page);

    @GET("comics/{id}")
    Observable<ComicResponse<ComicEntity>> getComicDetail(@Path("id") String id);

    @GET("comics/{id}/{chapter}")
    Observable<ComicResponse<ChapterEntity>> getChapter(@Path("id") String comicId, @Path("chapter") String chapterName);

    @GET("comics")
    Observable<ComicResponse<List<ComicEntity>>> searchComic(@Query("search") String query);

}
