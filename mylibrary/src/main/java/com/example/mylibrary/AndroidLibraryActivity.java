package com.example.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity {

    private  String mReceived_joke;
    private  TextView mLibraryWelcomeTextView;
    public static final String MY_JOKE = "my_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        mLibraryWelcomeTextView = (TextView) findViewById(R.id.libraryWelcomeTextView);

        Intent intent= getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            mReceived_joke = extras.getString(MY_JOKE); // retrieve the data using keyName
            mLibraryWelcomeTextView.setText(mReceived_joke);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
