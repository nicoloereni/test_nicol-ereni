package com.nicoloereni.githubstargazers;

public class GitHubRequest
{
    public static final String USERNAME = "username";
    public static final String REPOSITORY_NAME = "repository_name";

    public static String getRequest(String name, String repositoryName)
    {
        return "https://api.github.com/repos/"+name+"/"+repositoryName+"/stargazers";
    }
}
