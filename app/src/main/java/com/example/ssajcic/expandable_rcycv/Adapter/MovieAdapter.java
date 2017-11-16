package com.example.ssajcic.expandable_rcycv.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ssajcic.expandable_rcycv.Data.Movie;
import com.example.ssajcic.expandable_rcycv.Data.MovieCategory;
import com.example.ssajcic.expandable_rcycv.R;
import com.example.ssajcic.expandable_rcycv.ViewHolders.ChildViewHolder;
import com.example.ssajcic.expandable_rcycv.ViewHolders.ParentViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssajcic on 15.11.17..
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object> dataOfTheList = null;

    public MovieAdapter(ArrayList<Object> data) {
        dataOfTheList = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_movie_category, parent, false);
            return new ParentViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_movies, parent, false);
            return new ChildViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final View parent = holder.itemView;

        if (holder instanceof ParentViewHolder) {
            ((TextView) parent.findViewById(R.id.tvMovieCategory)).setText(((MovieCategory) dataOfTheList.get(position)).getCategoryName().toString());

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    List<Movie> movies = ((MovieCategory) dataOfTheList.get(position)).getMovies();
                    if(parent.isActivated()) {
                        ((ImageView) parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.left_arrow);
                        removeFrom(position, movies.size());
                    } else {
                        ((ImageView) parent.findViewById(R.id.ivMovieCategoryExpand)).setImageResource(R.drawable.down_arrow);
                        addInFrontOf(position, movies);
                    }
                    parent.setActivated(!parent.isActivated());
                    notifyDataSetChanged();
                }
            });
        } else {
            ((TextView) parent.findViewById(R.id.tvMovieName)).setText(((Movie) dataOfTheList.get(position)).getMovieName());
        }
    }

    @Override
    public int getItemCount() {
        if (dataOfTheList != null)
            return dataOfTheList.size();
        else return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (dataOfTheList.get(position) instanceof MovieCategory) return 1;
        else return 0;
    }

    public void addInFrontOf(int position, List<Movie> movies){
        for(int i = 0; i < movies.size(); i++)
            dataOfTheList.add(position+i+1, movies.get(i));
    }

    public void removeFrom(int position, int numOfMovies){
        for(int i = 0; i < numOfMovies; i++)
            dataOfTheList.remove(position+1);
    }
}

