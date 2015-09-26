package com.nicoloereni.githubstargazers;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StargazersFactory {
    private final HttpRequest httpRequest;

    public StargazersFactory(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public ArrayList<StargazerModel> all() throws JSONException {

        ArrayList<StargazerModel> stargazers = new ArrayList<>();

        for(JSONObject jsonObject: httpRequest.all()){
            stargazers.add(new StargazerModel(jsonObject));
        }

        return stargazers;
    }
}
