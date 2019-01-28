package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mylibrary.AndroidLibraryActivity;

/**
 * Created by Mohamed Ben Abdelkader.
 */

public class MainActivity extends AppCompatActivity {

    public static final String MY_JOKE = "my_joke";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
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

   /*
   Retrieve joke string from AsyncTask and open activity
   in android library to display jokes
    */
    public void getJoke(View view) {
        EndpointsAsyncTask.getInstance(new OnFindJokeListener() {

            @Override
            public void onFindJokeStart() {
            }

            @Override
            public void onFindJokeFinish(@Nullable String result) {
                launchJokeActivity(result);
            }
        });
    }

    // Open the activity from Android library to show joke
    private void launchJokeActivity(@Nullable String result) {
        Intent myIntent = new Intent(mContext, AndroidLibraryActivity.class);
        myIntent.putExtra(MY_JOKE,result);
        mContext.startActivity(myIntent);
    }

}
