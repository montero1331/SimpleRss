package com.rsschallenger.intelygenz.simplerss.viewPresenter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rsschallenger.intelygenz.simplerss.R;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class NewsViewHolder  extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView titleTextView,descriptionTextView;

    public NewsViewHolder(View v) {
        super(v);
        imageView = (ImageView) v.findViewById(R.id.newsImage);
        titleTextView = (TextView) v.findViewById(R.id.newsTitle);
        descriptionTextView = (TextView) v.findViewById(R.id.newsDescription);
    }
}
