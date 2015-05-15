package com.rsschallenger.intelygenz.simplerss.viewPresenter.presenter;

import android.content.Intent;
import android.net.Uri;

import com.rsschallenger.intelygenz.simplerss.viewPresenter.activity.DetailActivity;

/**
 * Created by Jose Luis on 15/05/2015.
 */
public class DetailPresenter {
    DetailActivity activity;
    public DetailPresenter(DetailActivity detailActivity) {
        this.activity=detailActivity;
    }

    public void goToWeb(String newUrl) {
        Uri uriUrl = Uri.parse(newUrl);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        activity.startActivity(launchBrowser);
    }
}
