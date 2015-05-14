package com.rsschallenger.intelygenz.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rsschallenger.intelygenz.sharedresources.linker.VolleyManager;
import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ErrorResponse;
import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ProperResponse;

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
    public void addStringRequest(String url, final ProperResponse properResponse, final ErrorResponse errorResponse) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        properResponse.goodResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                errorResponse.badResponse(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }
}
