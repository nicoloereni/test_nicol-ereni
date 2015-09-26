package com.nicoloereni.githubstargazers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button findStargazersButton = (Button) findViewById(R.id.find_stargazers_button);
        final EditText usernameEditText = (EditText) findViewById(R.id.user_name_editText);
        final EditText repositoryNameEditText = (EditText) findViewById(R.id.repo_name_editText);

        findStargazersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StargazersActivity.class);
                intent.putExtra(GitHubRequest.USERNAME, usernameEditText.getText()+"");
                intent.putExtra(GitHubRequest.REPOSITORY_NAME, repositoryNameEditText.getText()+"");

                startActivity(intent);

            }
        });
    }
}
