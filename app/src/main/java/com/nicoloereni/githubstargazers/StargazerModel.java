package com.nicoloereni.githubstargazers;

import org.json.JSONException;
import org.json.JSONObject;

public class StargazerModel {

    public String name;
    public String avatarUrl;

    public StargazerModel(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("login");
        avatarUrl = jsonObject.getString("avatar_url");
    }

}
