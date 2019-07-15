package com.example.flickster.adapters;
import android.content.Context;
import android.content.res.Configuration;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flickster.R;
import com.example.flickster.models.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter <MoviesAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;


    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.d("smile", "onCreateViewHolder" + i);

        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("smile", "onBindViewHolder:" + i);
        Movie movie = movies.get(i);
        viewHolder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle7;
        TextView tvoverView;
        ImageView ivPoster1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle7 = itemView.findViewById(R.id.tvTitle7);
            tvoverView = itemView.findViewById(R.id.tvoverView);
            ivPoster1 = itemView.findViewById(R.id.ivPoster1);
        }

        public void bind(Movie movie) {
            tvTitle7.setText(movie.getTitle());
            tvoverView.setText(movie.getOverview());

            String imageUrl = movie.getPosterPath();
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imageUrl = movie.getBackdropPath();
            }
            Glide.with(context).load(imageUrl).into(ivPoster1);


        }
    }
}

