package com.nicoloereni.githubstargazers.api;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest
{
    private final String url;

    public HttpRequest(String url) {
        this.url = url;
    }

    public String getAllStringValueData()
    {
        try {

            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());
            return  IOUtils.toString(in, "UTF-8");

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public List<JSONObject> all() throws JSONException {

        List<JSONObject> allJsonObjectValue = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(getAllStringValueData());

        for(int index =0; index < jsonArray.length(); index++)
        {
            allJsonObjectValue.add(jsonArray.getJSONObject(index));
        }

        return allJsonObjectValue;
    }
}