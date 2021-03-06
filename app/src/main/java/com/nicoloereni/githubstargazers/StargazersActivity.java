package com.nicoloereni.githubstargazers;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.nicoloereni.githubstargazers.api.HttpRequest;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class StargazersActivity extends GitHubStargazersActivity
{

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stargazers);
        setActionBarTitle();

        AsyncTask asyncTask = new AsyncTask()
        {
            @Override
            protected ArrayList doInBackground(Object[] params) {
                try
                {
                    showProgressDialog();
                    return getStargazersFactory().all();
                } catch (JSONException e)
                {
                    StargazersActivity.this.showOnScreenError(R.string.stargazers_not_found_error_message);
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

                dismissProgressDialog();
            }
        };

        asyncTask.execute();

    }

    private void showProgressDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                getProgressDialog().show();
            }
        });
    }

    private void dismissProgressDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                getProgressDialog().dismiss();
            }
        });
    }

    @NonNull
    private ProgressDialog getProgressDialog() {

        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(getString(R.string.loading_title));
        }

        return progressDialog;
    }

    @NonNull
    private StargazersFactory getStargazersFactory() {
        return new StargazersFactory(
                new HttpRequest(
                        GitHubRequest.getRequest(getStargazerNameFromIntent(), getStargazerRepoNameFromIntent())
                )
        );
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

    private void setActionBarTitle()
    {
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
    }

}
