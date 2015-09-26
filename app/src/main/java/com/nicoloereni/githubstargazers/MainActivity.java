package com.nicoloereni.githubstargazers;

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
        EditText usernameEditText = (EditText) findViewById(R.id.user_name_editText);
        EditText repoEditText = (EditText) findViewById(R.id.repo_name_editText);

        findStargazersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
