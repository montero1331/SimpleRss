package com.rsschallenger.intelygenz.simplerss.viewPresenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rsschallenger.intelygenz.simplerss.R;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.domain.News;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.viewHolder.NewsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter {
    private List<News> newsList;
    private Context context;

    public NewsAdapter(Context c) {
        this.context = c;
        newsList = new ArrayList<News>();
    }

    public void add(News i) {
        newsList.add(i);
        notifyItemInserted(newsList.indexOf(i));
    }

    public void remove(News item) {
        int position = newsList.indexOf(item);

        if (position != -1) {
            newsList.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final News item = newsList.get(position);
        Glide.with(context).load(item.getImageUrl()).into(((NewsViewHolder) holder).imageView);
        ((NewsViewHolder) holder).titleTextView.setText(item.getTitle());
        ((NewsViewHolder) holder).descriptionTextView.setText(item.getDescription());
        ((NewsViewHolder) holder).titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
