package com.example.week4daily4.view;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.week4daily4.utils.GlideHelper;

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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Photo photo = photos.get(i);
        viewHolder.title.setText(photo.getTitle());
        String url = GlideHelper.formatPhotoUrl(photo);
        Glide.with(viewHolder.itemView.getContext()).load(url).centerCrop().into(viewHolder.photo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("photo", photo);
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
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
            photo = itemView.findViewById(R.id.photoServer);
            title = itemView.findViewById(R.id.title);
        }
    }
}
