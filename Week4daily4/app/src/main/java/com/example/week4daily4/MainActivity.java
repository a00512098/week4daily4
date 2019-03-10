package com.example.week4daily4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.week4daily4.model.datasources.PhotosResponseCallback;
import com.example.week4daily4.model.datasources.PhotosResponseRepository;
import com.example.week4daily4.model.photo.PhotosResponse;

public class MainActivity extends AppCompatActivity implements PhotosResponseCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhotosResponseRepository repository = new PhotosResponseRepository();
        repository.getPhotosResponse("perros", this);
    }

    @Override
    public void OnSuccess(PhotosResponse response) {
        Log.d("Log.d", "On Seuccess!!!");
        for (int i = 0; i < response.getPhotos().getPhoto().size(); i++) {
            Log.d("Log.d", response
                    .getPhotos()
                    .getPhoto()
                    .get(i)
                    .getTitle()
            );
        }
    }
}
