package com.example.week4daily4.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily4.R;
import com.example.week4daily4.model.photo.Photo;

import java.util.List;

import static com.example.week4daily4.model.datasources.ApiConstants.BUILD_PHOTO;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Photo> photos;

    public RecyclerAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_photo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Photo photo = photos.get(i);
        viewHolder.title.setText(photo.getTitle());
        String url = formatPhotoUrl(photo);
        Glide.with(viewHolder.itemView.getContext()).load(url).centerCrop().into(viewHolder.photo);
    }

    private String formatPhotoUrl(Photo photo) {
        String farm = String.valueOf(photo.getFarm());
        String server = photo.getServer();
        String id = photo.getId();
        String secret = photo.getSecret();
        String url = String.format(BUILD_PHOTO, farm, server, id, secret);
        Log.d("Log.d", url);
        return url;
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            title = itemView.findViewById(R.id.title);
        }
    }
}
