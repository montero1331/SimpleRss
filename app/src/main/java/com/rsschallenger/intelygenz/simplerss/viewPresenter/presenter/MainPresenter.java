package com.rsschallenger.intelygenz.simplerss.viewPresenter.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.rsschallenger.intelygenz.database.DataBaseHelper;
import com.rsschallenger.intelygenz.network.Network;
import com.rsschallenger.intelygenz.sharedresources.dependency.DependencyManager;
import com.rsschallenger.intelygenz.sharedresources.domain.News;
import com.rsschallenger.intelygenz.sharedresources.linker.DataBaseManager;
import com.rsschallenger.intelygenz.sharedresources.linker.VolleyManager;
import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ErrorResponse;
import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ProperResponse;
import com.rsschallenger.intelygenz.simplerss.parser.RSSParser;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.activity.DetailActivity;
import com.rsschallenger.intelygenz.simplerss.viewPresenter.activity.MainActivity;

import java.net.URISyntaxException;
import java.util.ArrayList;

import dagger.ObjectGraph;

/**
 * Created by Jose Luis on 15/05/2015.
 */
public class MainPresenter {

    MainActivity activity;
    ObjectGraph dependencyInjector;
    VolleyManager volleyManager;
    DataBaseManager dataBaseManager;

    public MainPresenter(MainActivity mainActivity) {
        this.activity=mainActivity;
        dependencyInjector=DependencyManager.createInjector();
        volleyManager=dependencyInjector.get(VolleyManager.class);
        dataBaseManager=dependencyInjector.get(DataBaseManager.class);
    }

    public void getData(String rssUrl) {
        volleyManager.addStringRequest(rssUrl, new ProperResponse() {
            @Override
            public void goodResponse(String message) {
                try {
                    ArrayList<News> resultArrayList = RSSParser.xmlToNewsList(message);
                    activity.setNews(resultArrayList);
                    sendNewsToDataBase(resultArrayList);

                } catch (URISyntaxException e) {
                    activity.showError("Invalid Resource");
                }
            }
        }, new ErrorResponse() {
            @Override
            public void badResponse(String message) {
                activity.showError(message);
            }
        });
    }

    private void sendNewsToDataBase(ArrayList<News> resultArrayList) {
        dataBaseManager.deleteAllMyNews();
        for(News news:resultArrayList)dataBaseManager.insertNews(news);
    }

    public void goToDetailActivity(News news) {
        Intent intent = new Intent();
        intent.setClass(activity, DetailActivity.class);
        intent.putExtra("title", news.getTitle().toString());
        intent.putExtra("description", news.getDescription().toString());
        intent.putExtra("url", news.getWebUrl().toString());
        intent.putExtra("image", news.getImageUrl().toString());
        intent.putExtra("ramon", "ramon");
        activity.startActivity(intent);

    }
}
