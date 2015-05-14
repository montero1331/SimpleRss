package com.rsschallenger.intelygenz.simplerss;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.rsschallenger.intelygenz.sharedresources.domain.News;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.adapter.NewsAdapter;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        newsAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(newsAdapter);

        //Precarga de datos de ejemplo
        for (int i = 0; i < 5; i++) {
            newsAdapter.add(new News("Holaaaaaaaaaaaa"+i,"iiiiiiiiiieeeeeeeeeee"+i,"12/12/12","http://2.bp.blogspot.com/-fHwVWVUS26Q/VP7PTAtWKpI/AAAAAAAABQU/cydQgiPMHP8/s1600/LayoutManager.png",""));
        }
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
}
