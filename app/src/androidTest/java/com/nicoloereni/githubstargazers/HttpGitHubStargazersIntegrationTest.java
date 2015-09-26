package com.nicoloereni.githubstargazers;

import android.test.AndroidTestCase;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class HttpGitHubStargazersIntegrationTest extends AndroidTestCase
{

    private HttpRequest httpRequest;

    public void setUp()
    {
        httpRequest = new HttpRequest("https://api.github.com/repos/xpmatteo/birthday-greetings-kata/stargazers");
    }

    public void testGetStargazersJsonObjectData() throws JSONException {
        List<JSONObject> stargazersData = httpRequest.all();
        assertNotNull(stargazersData);
        assertFalse(stargazersData.isEmpty());
    }

}
