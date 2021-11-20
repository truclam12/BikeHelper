package com.google.bikehelper.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreference {
    private static MyPreference myPreference;
    private SharedPreferences sharedPreferences;

    public static MyPreference getInstance(Context context) {
        if (myPreference == null) {
            myPreference = new MyPreference(context);
        }
        return myPreference;
    }

    private MyPreference(Context context) {
        sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);;
    }

    public void saveData(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public String getData(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }
}
