package com.rsschallenger.intelygenz.sharedresources.linker;


import com.android.volley.Response;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public interface VolleyManager {
    void addStringRequest(String url, Response.Listener listener, Response.ErrorListener errorListener);
}