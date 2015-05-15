package com.rsschallenger.intelygenz.sharedresources.linker;

import com.rsschallenger.intelygenz.sharedresources.domain.News;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public interface DataBaseManager {

    String DATABASE_NAME = "rss-database.sqlite";
    int SCHEMA_VERSION = 1000;

    void insertNews(News news);
    ArrayList<News> getMyNews();
    void deleteAllMyNews();
    ArrayList<News> searchNews(String searchQuery);
}
