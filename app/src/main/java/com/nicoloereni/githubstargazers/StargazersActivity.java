package com.nicoloereni.githubstargazers;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class StargazersActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stargazers);

        setActionBarTitle();

        final StargazersFactory stargazersFactory =
                new StargazersFactory(
                        new HttpRequest(
                                GitHubRequest.getRequest(getStargazerNameFromIntent(), getStargazerRepoNameFromIntent())
                        )
                );

        AsyncTask asyncTask = new AsyncTask()
        {
            @Override
            protected ArrayList doInBackground(Object[] params) {
                try
                {
                    //TODO parte lo spinner
                    return stargazersFactory.all();
                } catch (Exception e)
                {
                    showOnScreenError();
                    return new ArrayList();
                }
            }

            @Override
            protected void onPostExecute(Object o)
            {
                super.onPostExecute(o);

                getStargazersListView().setAdapter(
                        new StargazersArrayAdapter(
                                StargazersActivity.this,
                                R.layout.stargazers_list_item,
                                (List<StargazerModel>) o));

                //TODO spengo spinner

            }
        };

        asyncTask.execute();

    }

    private ListView getStargazersListView() {
        return (ListView) findViewById(R.id.stargazers_listView);
    }

    private String getStargazerRepoNameFromIntent() {
        return getIntent().getStringExtra(GitHubRequest.REPOSITORY_NAME);
    }

    private String getStargazerNameFromIntent() {
        return getIntent().getStringExtra(GitHubRequest.USERNAME);
    }

    private void showOnScreenError()
    {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(StargazersActivity.this, R.string.stargazers_error_message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setActionBarTitle()
    {
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
    }
}
