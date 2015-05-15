package com.rsschallenger.intelygenz.simplerss.parser;

import android.text.Html;

import com.rsschallenger.intelygenz.sharedresources.domain.News;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class RSSParser {

    public static ArrayList<News> xmlToNewsList(String response) throws URISyntaxException {
        ArrayList<News> newsArrayList = new ArrayList<>();

        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        String tagname;
        InputStream is = new ByteArrayInputStream(response.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
            parser.setInput(br);
            int eventType = parser.getEventType();
            News news = new News();
            String text = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                tagname = parser.getName();
                //Log.d(tagname, "tagname");
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            news = new News();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            newsArrayList.add(news);
                        } else if (tagname.equalsIgnoreCase("title")) {
                            news.setTitle(text);
                        } else if (tagname.equalsIgnoreCase("description")) {
                            news.setDescription(text);
                            if (news.getImageUrl() == null) {
                                getImageFromDescription(news);
                            }
                            plainTextDescription(news);
                        } else if (tagname.equalsIgnoreCase("link")) {
                            news.setWebUrl(text);
                        } else if (tagname.equalsIgnoreCase("thumbnail")) {
                            news.setImageUrl(parser.getAttributeValue(null, "url"));
                        } else if (tagname.equalsIgnoreCase("pubDate")) {
                            news.setReleasedDate(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();

        }

        return newsArrayList;
    }

    //TODO Hot Fix Due To Lack Of Time
    private static void getImageFromDescription( News news) throws XmlPullParserException, IOException {
        String str=news.getDescription();
        try {
            String result = str.substring(str.indexOf("src=\"http:") + 5,str.length());
            result=result.substring(0,result.indexOf("\" class"));
            news.setImageUrl(result);
        }catch (Exception ignored){

        }

    }
    private static void plainTextDescription(News news) throws XmlPullParserException, IOException {
        String str=news.getDescription();
        try {
            String cleanDescription=Html.fromHtml(Html.fromHtml(str).toString()).toString();
            news.setDescription(cleanDescription);
        }catch (Exception ignored){

        }

    }

}
