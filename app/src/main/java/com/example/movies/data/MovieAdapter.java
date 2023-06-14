package com.example.movies.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.Model.Movie;
import com.example.movies.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie>movies;


    public MovieAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item,viewGroup, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i) {
        Movie curentMovie  = movies.get(i);

        String title = curentMovie.getTitle();
        String year = curentMovie.getYear();
        String posterrURL = curentMovie.getPosterURL();

        movieViewHolder.titleTextView.setText(title);
        movieViewHolder.yearTextView.setText(year);
        Picasso.get().load(posterrURL).fit().centerInside().into(movieViewHolder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView posterImageView;
        TextView titleTextView;
        TextView yearTextView;


        public MovieViewHolder(View itemView) {
            super(itemView);

            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titelTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);

        }
    }


}
