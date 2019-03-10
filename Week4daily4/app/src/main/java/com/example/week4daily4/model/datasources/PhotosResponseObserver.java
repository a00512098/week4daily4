package com.example.week4daily4.model.datasources;

import com.example.week4daily4.model.photo.PhotosResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PhotosResponseObserver implements Observer<PhotosResponse> {
    private PhotosResponse photosResponse;
    private PhotosResponseCallback photosResponseCallback;

    PhotosResponseObserver(PhotosResponseCallback photosResponseCallback) {
        this.photosResponseCallback = photosResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(PhotosResponse photosResponse) {
        this.photosResponse = photosResponse;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        photosResponseCallback.OnSuccess(photosResponse);
    }
}
