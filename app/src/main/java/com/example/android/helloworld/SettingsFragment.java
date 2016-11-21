package com.example.android.helloworld;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by root on 11/21/16.
 */


    public class SettingsFragment extends PreferenceFragment {

        public SettingsFragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.settings);
        }
    }

