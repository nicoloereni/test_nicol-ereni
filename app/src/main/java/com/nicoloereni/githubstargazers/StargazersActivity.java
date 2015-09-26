package com.nicoloereni.githubstargazers;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import java.util.ArrayList;

public class StargazersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stargazers);

        setActionBarTitle();

        String name = getIntent().getStringExtra(GitHubRequest.USERNAME);
        String repositoryName = getIntent().getStringExtra(GitHubRequest.REPOSITORY_NAME);

        final StargazersFactory stargazersFactory =
                new StargazersFactory(new HttpRequest(GitHubRequest.getRequest(name, repositoryName)));

        ListView stargazersListView = (ListView) findViewById(R.id.stargazers_listView);

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected ArrayList doInBackground(Object[] params) {

                try {
                    //TODO parte lo spinner
                    return stargazersFactory.all();
                } catch (Exception e) {
                    //TODO messaggio di errore
                    return null;
                }

            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                if(o != null) {
                    //TODO popola la lista
                }

                //TODO spengo spinner

            }
        };

        asyncTask.execute();

    }

    private void setActionBarTitle() {
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
    }
}
