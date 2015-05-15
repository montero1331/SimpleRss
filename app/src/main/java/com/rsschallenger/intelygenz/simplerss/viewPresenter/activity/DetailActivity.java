package com.rsschallenger.intelygenz.simplerss.viewPresenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rsschallenger.intelygenz.sharedresources.domain.News;
import com.rsschallenger.intelygenz.simplerss.R;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.presenter.DetailPresenter;

import java.util.logging.Handler;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class DetailActivity extends Activity{
    private DetailPresenter presenter;
    private TextView titleTextView, descriptionlTextView;
    private Button webButton;
    private ImageView detailImageView;
    private String newUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_layout);
        presenter=createPresenter();
        titleTextView=(TextView)findViewById(R.id.newsTitleDetail);
        descriptionlTextView=(TextView)findViewById(R.id.newsDescriptionDetail);
        webButton=(Button)findViewById(R.id.webButtonDetail);
        detailImageView=(ImageView)findViewById(R.id.newsImageDetail);
        setInformation();
    }

        private void setInformation() {
            titleTextView.setText(getIntent().getStringExtra("title"));
            descriptionlTextView.setText(getIntent().getStringExtra("description"));
            Glide.with(this).load(getIntent().getStringExtra("image")).diskCacheStrategy(DiskCacheStrategy.ALL).into(detailImageView);
        newUrl = getIntent().getStringExtra("url");
            webButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.goToWeb(newUrl);
                }
            });
    }

    private DetailPresenter createPresenter() {
        return new DetailPresenter(this);
    }

}
