package com.nicoloereni.githubstargazers;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends GitHubStargazersActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFindStargazersButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStargazersActivity();
            }
        });

        getRepositoryNameEditText().setOnEditorActionListener(
                new EditText.OnEditorActionListener()
                {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
                    {
                        if (actionId == EditorInfo.IME_ACTION_DONE)
                        {
                            goToStargazersActivity();
                            return true;
                        }
                        return false;
                    }
                }
        );
    }

    private Button getFindStargazersButton() {
        return (Button) findViewById(R.id.find_stargazers_button);
    }

    private void goToStargazersActivity() {

        if(isNetworkConnected())
        {
            Intent intent = new Intent(MainActivity.this, StargazersActivity.class);
            intent.putExtra(GitHubRequest.USERNAME, getUsernameEditText().getText() + "");
            intent.putExtra(GitHubRequest.REPOSITORY_NAME, getRepositoryNameEditText().getText() + "");

            startActivity(intent);
        }
        else
        {
            showOnScreenError(R.string.no_connection_message);
        }
    }

    private EditText getRepositoryNameEditText() {
        return getEditText(R.id.repo_name_editText);
    }

    private EditText getUsernameEditText() {
        return getEditText(R.id.user_name_editText);
    }

    private EditText getEditText(int user_name_editText) {
        return (EditText) findViewById(user_name_editText);
    }

    private boolean isNetworkConnected(){
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
