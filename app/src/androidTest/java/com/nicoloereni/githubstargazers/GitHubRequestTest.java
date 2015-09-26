package com.nicoloereni.githubstargazers;

import android.test.AndroidTestCase;

public class GitHubRequestTest extends AndroidTestCase {

    public void testGetGitHubRequest(){
        assertEquals("https://api.github.com/repos/bobby/karatechop/stargazers", GitHubRequest.getRequest("bobby", "karatechop"));
    }

}
