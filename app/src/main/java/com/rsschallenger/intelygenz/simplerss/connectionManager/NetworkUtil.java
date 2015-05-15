package com.rsschallenger.intelygenz.simplerss.connectionManager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Jose Luis on 15/05/2015.
 */
public class NetworkUtil {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;


    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static boolean hasAnyConnectivity(Context context) {
        int conn = NetworkUtil.getConnectivityStatus(context);
        boolean hasConnectivity = false;
        if (conn == NetworkUtil.TYPE_WIFI) {
            hasConnectivity=true;
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            hasConnectivity=true;
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            hasConnectivity=false;
        }
        return hasConnectivity;
    }
}
