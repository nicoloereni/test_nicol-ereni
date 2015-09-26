package com.nicoloereni.githubstargazers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class GitHubStargazersActivity extends AppCompatActivity {

    protected void showOnScreenError(final int message_string_id )
    {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(GitHubStargazersActivity.this, message_string_id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
