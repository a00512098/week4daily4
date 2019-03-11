package com.example.week4daily4.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily4.R;
import com.example.week4daily4.model.photo.Photo;
import com.example.week4daily4.utils.GlideHelper;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView id, server, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle bundle = intent.getExtras();
            Photo photo = bundle.getParcelable("photo");
            initViews(photo);
        }
    }

    private void initViews(Photo photo) {
        id = findViewById(R.id.photoId);
        server = findViewById(R.id.photoServer);
        title = findViewById(R.id.photoTitle);
        imageView = findViewById(R.id.imageView);

        id.setText(String.format(getString(R.string.id_s), photo.getId()));
        server.setText(String.format(getString(R.string.server_s), photo.getServer()));
        title.setText(String.format(getString(R.string.title_s), photo.getTitle()));

        String url = GlideHelper.formatPhotoUrl(photo);
        Glide.with(this).load(url).centerCrop().into(imageView);
    }
}
