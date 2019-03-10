package com.example.week4daily4.model.datasources;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotosResponseRepository {

    public void getPhotosResponse(String search, PhotosResponseCallback callback) {
        RetrofitHelper.getPhotosResponseObsevable(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PhotosResponseObserver(callback));
    }
}
