package com.example.week4daily4.model.datasources;

import com.example.week4daily4.model.photo.PhotosResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4daily4.model.datasources.ApiConstants.API_KEY;
import static com.example.week4daily4.model.datasources.ApiConstants.API_KEY_VAL;
import static com.example.week4daily4.model.datasources.ApiConstants.BASE_URL;
import static com.example.week4daily4.model.datasources.ApiConstants.FORMAT;
import static com.example.week4daily4.model.datasources.ApiConstants.FORMAT_VAL;
import static com.example.week4daily4.model.datasources.ApiConstants.METHOD;
import static com.example.week4daily4.model.datasources.ApiConstants.METHOD_VAL;
import static com.example.week4daily4.model.datasources.ApiConstants.NO_CALLBACK_VAL;
import static com.example.week4daily4.model.datasources.ApiConstants.NO_JSON_CALLBACK;
import static com.example.week4daily4.model.datasources.ApiConstants.PER_PAGE;
import static com.example.week4daily4.model.datasources.ApiConstants.PER_PAGE_VAL;
import static com.example.week4daily4.model.datasources.ApiConstants.REST_API;
import static com.example.week4daily4.model.datasources.ApiConstants.TEXT;

class RetrofitHelper {
    private static Retrofit retrofit = null;

    private static Retrofit initRetrofit() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private static Retrofit getRetrofitInstance() {
        if (retrofit == null)
            retrofit = initRetrofit();

        return retrofit;
    }

    private static ObservableInterface createPhotosResponseInterface() {
        return getRetrofitInstance().create(ObservableInterface.class);
    }

    static Observable<PhotosResponse> getPhotosResponseObsevable(String searchText) {
        return createPhotosResponseInterface()
                .getPhotosResponseObservable(
                        METHOD_VAL,
                        API_KEY_VAL,
                        searchText,
                        PER_PAGE_VAL,
                        FORMAT_VAL,
                        NO_CALLBACK_VAL
        );
    }

    public interface ObservableInterface {
        @GET(REST_API)
        Observable<PhotosResponse> getPhotosResponseObservable(
                @Query(METHOD) String apiMethod,
                @Query(API_KEY) String apiKey,
                @Query(TEXT) String searchText,
                @Query(PER_PAGE) String resultsPerPage,
                @Query(FORMAT) String responseFormat,
                @Query(NO_JSON_CALLBACK) String noJsonCallback
        );
    }
}
