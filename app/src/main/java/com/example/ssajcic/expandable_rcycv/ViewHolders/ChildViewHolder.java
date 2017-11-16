package com.example.ssajcic.expandable_rcycv.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ssajcic.expandable_rcycv.R;

/**
 * Created by ssajcic on 15.11.17..
 */

public class ChildViewHolder extends RecyclerView.ViewHolder {

    private TextView movieName;
    private View cView;

    public ChildViewHolder(View itemView) {
        super(itemView);

        cView = itemView;
        movieName = itemView.findViewById(R.id.tvMovieName);
    }
}
