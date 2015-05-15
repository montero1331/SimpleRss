package com.rsschallenger.intelygenz.sharedresources.utilities;

import com.rsschallenger.intelygenz.sharedresources.domain.News;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Jose Luis on 15/05/2015.
 */
public class NewsOperations {
    public static void sortNewsByDate(List<News> rssItems) {
        final SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
        Collections.sort(rssItems, new Comparator<News>() {
            @Override
            public int compare(News firstNews, News secondNews) {
                try {
                    Date date1 = format.parse(firstNews.getReleasedDate());
                    Date date2 = format.parse(secondNews.getReleasedDate());
                    return date2.compareTo(date1);
                } catch (ParseException e) {
                    return 0;
                }
            }
        });
    }
}
