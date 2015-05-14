package com.rsschallenger.intelygenz.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rsschallenger.intelygenz.sharedresources.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAgent {

    public final static String TABLE_NEWS = "NEWS";
    public final static String FIELD_TITLE = "TITLE";
    public final static String FIELD_DESCRIPTION = "DESCRIPTION";
    public final static String FIELD_DATE = "DATE";
    public final static String FIELD_IMAGE = "IMAGE";
    public final static String FIELD_URL = "URL";

    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS '" + TABLE_NEWS + "' ('" + FIELD_TITLE + "' TEXT PRIMARY KEY NOT NULL, '" +
                FIELD_DESCRIPTION + "' TEXT NOT NULL,'" + FIELD_DATE + "' TEXT NOT NULL, '" + FIELD_IMAGE + "' TEXT NOT NULL," +
                ", '" + FIELD_URL + "' TEXT NOT NULL);");
    }

    public static void insert(SQLiteDatabase db, News news) {
        String query = "INSERT OR IGNORE INTO " + TABLE_NEWS + " VALUES (?, ?, ?, ?,?);";
        db.execSQL(query, new String[]{news.getTitle(), news.getDescription(),news.getReleasedDate(),
                news.getImageUrl(),news.getWebUrl()});
    }

    public static ArrayList<News> getAll(SQLiteDatabase db) {
        ArrayList<News> newsList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NEWS + " ORDER BY " + FIELD_DATE + " DESC ", null);
        if (cursor.moveToFirst()) {
            do {
                newsList.add(cursorToNews(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return newsList;
    }

    private static News cursorToNews(Cursor cursor) {
        return new News(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
    }

    public static void deleteAll(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);

    }
}
