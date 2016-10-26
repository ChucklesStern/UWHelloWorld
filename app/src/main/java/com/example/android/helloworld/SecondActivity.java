package com.example.android.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


/**
 * Created by root on 10/24/16.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);




        Bundle b = getIntent().getExtras();

        Log.d("Name", b.getString("Name"));

        TextView tv = (TextView)findViewById(R.id.SecondA_0);

        tv.setText(b.getString("Name"));

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);

        String [] countries = getResources().getStringArray(R.array.countries_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, countries);

        textView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu2);
        return true;
    }




}
