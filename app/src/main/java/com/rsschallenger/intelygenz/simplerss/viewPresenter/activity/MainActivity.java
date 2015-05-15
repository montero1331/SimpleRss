package com.rsschallenger.intelygenz.simplerss.viewPresenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        if(savedInstanceState!=null)
        rssUrl=savedInstanceState.getString("url","http://www.xatakandroid.com/tag/feeds/rss2.xml");
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        newsAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(newsAdapter);

        presenter.getData(rssUrl);
    }

    private MainPresenter createPresenter() {
        return new MainPresenter(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void setNews(ArrayList<News> newsArrayList) {
        for (News news:newsArrayList) newsAdapter.add(news);
    }
}
