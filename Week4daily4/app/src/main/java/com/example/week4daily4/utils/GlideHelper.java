package com.example.week4daily4.utils;

import android.util.Log;

import com.example.week4daily4.model.photo.Photo;

import static com.example.week4daily4.model.datasources.ApiConstants.BUILD_PHOTO;

public class GlideHelper {
    public static String formatPhotoUrl(Photo photo) {
        String farm = String.valueOf(photo.getFarm());
        String server = photo.getServer();
        String id = photo.getId();
        String secret = photo.getSecret();
        String url = String.format(BUILD_PHOTO, farm, server, id, secret);
        Log.d("Log.d", url);
        return url;
    }
}
