package com.smartclient.params;

import java.util.HashMap;

/**
 * Created by Bhavesh Patel
 */
public class Headers {

    public static final String CONTENT_TYPE = "json";
    public static final String ACCEPT = "Accept";
    public static final String COOKIE = "Cookie";


    public static HashMap<String, String> getHeaders(String token) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, "application/json");
        headers.put(ACCEPT, "application/json");
        headers.put(COOKIE, "token=" + token);
        return headers;
    }
}
