package com.rsschallenger.intelygenz.sharedresources.linker;


import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ErrorResponse;
import com.rsschallenger.intelygenz.sharedresources.linker.netResponser.ProperResponse;

/**
 * Created by Jose Luis on 14/05/2015.
 */
public interface VolleyManager {
    void addStringRequest(String url, ProperResponse properResponse, ErrorResponse errorResponse);
}