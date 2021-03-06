package com.rsschallenger.intelygenz.simplerss.viewPresenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rsschallenger.intelygenz.sharedresources.domain.News;
import com.rsschallenger.intelygenz.simplerss.R;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.adapter.NewsAdapter;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.presenter.MainPresenter;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter newsAdapter;
    private String rssUrl="http://www.xatakandroid.com/tag/feeds/rss2.xml";
    private MainPresenter presenter;
    private EditText searchEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        if(savedInstanceState!=null)
        rssUrl=savedInstanceState.getString("url","http://www.xatakandroid.com/tag/feeds/rss2.xml");
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        searchEditText =(EditText) findViewById(R.id.searchText);
        searchButton =(Button) findViewById(R.id.searchButton);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        newsAdapter = new NewsAdapter(this,new NewsAdapter.customOnClickListener(){
            @Override
            public void customOnItemSelected(News news) {
                presenter.goToDetailActivity(news);
            }
        });
        recyclerView.setAdapter(newsAdapter);
        presenter.getData(rssUrl);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchQuery=searchEditText.getText().toString();
                presenter.searchNews(searchQuery);
            }
        });
    }

    private MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void setNews(ArrayList<News> newsArrayList) {
        newsAdapter.removeData();
        for (News news:newsArrayList) newsAdapter.add(news);
        recyclerView.setAdapter(newsAdapter);
    }
}
