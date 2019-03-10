package com.example.week4daily4.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.week4daily4.R;
import com.example.week4daily4.model.datasources.PhotosResponseCallback;
import com.example.week4daily4.model.datasources.PhotosResponseRepository;
import com.example.week4daily4.model.photo.Photo;
import com.example.week4daily4.model.photo.PhotosResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PhotosResponseCallback, TextView.OnEditorActionListener {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<Photo> photos;
    EditText searchET;
    PhotosResponseRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new PhotosResponseRepository();
        searchET = findViewById(R.id.search);
        searchET.setOnEditorActionListener(this);

        photos = new ArrayList<>();
        initRecyclerView(photos);
    }

    @Override
    public void OnSuccess(PhotosResponse response) {
        Log.d("Log.d", "On Seuccess!!!");
        photos.clear();
        photos.addAll(response.getPhotos().getPhoto());
        recyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(List<Photo> photos) {
        recyclerView = findViewById(R.id.recycler);
        recyclerAdapter = new RecyclerAdapter(photos);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);;
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            repository.getPhotosResponse(searchET.getText().toString(), this);
            // Hide keyboard and clear focus
            searchET.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(searchET.getWindowToken(), 0);

            return true;
        }
        return false;
    }
}
