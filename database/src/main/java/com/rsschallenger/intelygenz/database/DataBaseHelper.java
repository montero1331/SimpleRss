package com.rsschallenger.intelygenz.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rsschallenger.intelygenz.sharedresources.domain.News;
import com.rsschallenger.intelygenz.sharedresources.linker.DataBaseManager;

import java.util.ArrayList;


public class DataBaseHelper implements DataBaseManager {

    private SQLiteDatabase db;

    public DataBaseHelper(Context context){
        OpenHelper openHelper = new OpenHelper(context.getApplicationContext());
        db = openHelper.getWritableDatabase();
    }

    @Override
    public void insertNews(News news) {
        NewsAgent.insert(db,news);
    }

    @Override
    public ArrayList<News> getMyNews() {
        return NewsAgent.getAll(db);
    }

    @Override
    public void deleteAllMyNews() {
        NewsAgent.deleteAll(db);
        NewsAgent.createTable(db);
    }

    private static class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTable(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

        private void createTable(SQLiteDatabase db) {
            NewsAgent.createTable(db);
        }
    }

    public SQLiteDatabase getDataBase() {
        return db;
    }
}
