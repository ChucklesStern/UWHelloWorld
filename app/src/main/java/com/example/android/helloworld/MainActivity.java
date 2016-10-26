package com.example.android.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.mailWidget);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Send email", "");
                    sendEmail();

            }
        });
    }

    protected void sendEmail() {


        String[] TO = {""};
        String[] CC = {""};
        //The defined Common intent lets Android know what type of new app to open and pass data to
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void startThirdActivity(View view) {
        Log.v("Hey!", "Third Activity Activate!");

        Intent explicitIntent3 = new Intent(MainActivity.this, ThirdActivity.class);

        startActivity(explicitIntent3);
    }

    public void sendMessage (View view){
    Log.v("Hey!", "Button Pressed!");
        //This syntax is useful for debugging as it enables us to acquire ID of the clicked object
        String showId = view.getResources().getResourceName(view.getId());
        Toast.makeText(MainActivity.this, showId, Toast.LENGTH_SHORT).show();

        Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);

        Bundle b = new Bundle();
        b.putString("Name", "Chuck");

        explicitIntent.putExtras(b);

        startActivity(explicitIntent);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "OnStop");
    }
//seems as if onDestroy does not trigger a breakpoint at all. Why??
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "OnDestroy");
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
