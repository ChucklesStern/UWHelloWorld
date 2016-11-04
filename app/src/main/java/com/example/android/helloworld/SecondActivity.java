package com.example.android.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.helloworld.R.id.checkBox2;


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

        Switch togButt = (Switch) findViewById(R.id.toggle1);


        togButt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                    Context context = getApplicationContext();
                    if (isChecked) {
                    Log.d("OnCheckedChange", "Switch on!");
                  Toast toastA = Toast.makeText(context, "Switch ON!", Toast.LENGTH_SHORT);
                        toastA.setGravity(Gravity.TOP|Gravity.RIGHT, 15, 0);
                        toastA.show();
                } else {
                    Log.d("OnCheckedChange", "Switch off!");
                        Toast toastb = Toast.makeText(context, "Switch OFF!", Toast.LENGTH_SHORT);
                        toastb.setGravity(Gravity.TOP|Gravity.RIGHT, 60, 0);
                        toastb.show();
                }
            }


        });



    }


    public void onClicked(View view) {

        CheckBox CheckboxTwo = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox CheckboxOne = (CheckBox) findViewById(R.id.checkBox1);
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBox1:
                if (checked) {

                    CheckboxTwo.setChecked(false);
                } else {

                    CheckboxTwo.setChecked(true);
                }
                break;
            case checkBox2:
                if(checked){

                    CheckboxOne.setChecked(false);
                } else {

                    CheckboxOne.setChecked(true);
                }
                break;
        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu2);
        return true;
    }




}
