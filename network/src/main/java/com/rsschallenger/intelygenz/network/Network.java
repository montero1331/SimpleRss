package com.rsschallenger.intelygenz.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rsschallenger.intelygenz.sharedresources.linker.VolleyManager;

import java.net.URL;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public class Network implements VolleyManager {

    private final RequestQueue requestQueue;

    Network(Context context){
        requestQueue= Volley.newRequestQueue(context);
    }

    @Override
    public void addStringRequest(String url, Response.Listener listener, Response.ErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,listener, errorListener);
        requestQueue.add(stringRequest);
    }
}
