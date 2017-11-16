package com.example.ssajcic.expandable_rcycv.ViewHolders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ssajcic.expandable_rcycv.R;

/**
 * Created by ssajcic on 15.11.17..
 */

public class ParentViewHolder extends RecyclerView.ViewHolder {

    private TextView categoryMovie;
    private ImageView expandCategory;
    private View pView;

    public ParentViewHolder(View itemView) {
        super(itemView);
        pView = itemView;
        categoryMovie = pView.findViewById(R.id.tvMovieCategory);
        expandCategory = pView.findViewById(R.id.ivMovieCategoryExpand);
    }
}
