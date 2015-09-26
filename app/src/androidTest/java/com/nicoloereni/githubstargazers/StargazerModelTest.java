package com.nicoloereni.githubstargazers;


import android.test.AndroidTestCase;

import org.json.JSONException;
import org.json.JSONObject;

public class StargazerModelTest extends AndroidTestCase{

        private static final String FAKE_STARGAZE = "{\n" +
                "    \"login\": \"mattdsteele\",\n" +
                "    \"id\": 389077,\n" +
                "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/389077?v=3\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/mattdsteele\",\n" +
                "    \"html_url\": \"https://github.com/mattdsteele\",\n" +
                "    \"followers_url\": \"https://api.github.com/users/mattdsteele/followers\",\n" +
                "    \"following_url\": \"https://api.github.com/users/mattdsteele/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github.com/users/mattdsteele/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github.com/users/mattdsteele/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github.com/users/mattdsteele/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github.com/users/mattdsteele/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/mattdsteele/repos\",\n" +
                "    \"events_url\": \"https://api.github.com/users/mattdsteele/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github.com/users/mattdsteele/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  }";

        public void testCreateStargaze() throws JSONException {
                StargazerModel stargazeModel = new StargazerModel(new JSONObject(FAKE_STARGAZE));
                assertNotNull(stargazeModel);
                assertEquals("mattdsteele", stargazeModel.name);
                assertEquals("https://avatars.githubusercontent.com/u/389077?v=3&s=100", stargazeModel.avatarUrl);
        }

}
