package com.nicoloereni.githubstargazers;

import android.test.AndroidTestCase;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class StargazersFactoryTest extends AndroidTestCase {

    @Mock
    private HttpRequest httpRequest;
    private final String FAKE_RESPONSE =
            "    {\n" +
            "    \"login\": \"pino1068\",\n" +
            "    \"id\": 145005,\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/145005?v=3\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/pino1068\",\n" +
            "    \"html_url\": \"https://github.com/pino1068\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/pino1068/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/pino1068/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/pino1068/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/pino1068/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/pino1068/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/pino1068/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/pino1068/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/pino1068/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/pino1068/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "    }";


    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.setProperty(
                "dexmaker.dexcache",
                getContext().getCacheDir().getPath());
        MockitoAnnotations.initMocks(this);
    }

    public void testCreateStargazersList() throws JSONException {

        List<JSONObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(new JSONObject(FAKE_RESPONSE));

        when(httpRequest.all()).thenReturn(jsonObjectList);

        StargazersFactory stargazersFactory = new StargazersFactory(httpRequest);
        ArrayList<StargazerModel> stargazerModels = stargazersFactory.all();
        assertNotNull(stargazerModels);
        assertFalse(stargazerModels.isEmpty());
        assertEquals(1, stargazerModels.size());
        assertNotNull(stargazerModels.get(0));
    }

}
