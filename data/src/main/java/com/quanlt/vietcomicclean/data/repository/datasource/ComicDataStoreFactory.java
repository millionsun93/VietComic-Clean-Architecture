package com.quanlt.vietcomicclean.data.repository.datasource;

import com.quanlt.vietcomicclean.data.net.ComicApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ComicDataStoreFactory {
    private final ComicApiService retrofitDataStore;

    @Inject
    public ComicDataStoreFactory(ComicApiService retrofitDataStore) {
        this.retrofitDataStore = retrofitDataStore;
    }

    public ComicDataStore createCloudDataStore() {
        return new ComicRetrofitDataStore(retrofitDataStore);
    }
}
