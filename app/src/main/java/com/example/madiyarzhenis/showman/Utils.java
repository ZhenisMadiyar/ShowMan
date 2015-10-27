package com.example.madiyarzhenis.showman;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by madiyarzhenis on 15.10.15.
 */
public class Utils {
    public static final String TAG_Name = "name";
    public static final String TAG_Phone = "phone";
    public static final String TAG_PrivateKey = "privateKey";
    public static final String TAG_UserId = "userId";
    public static final String TAG_UserCode = "userCode";
    public static final String TAG_Type_Id = "typeId";

    public static void setDefaults(Context context, String name, String phone, int userId) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_Name, name);
        editor.putString(TAG_Phone, phone);
        editor.putInt(TAG_Type_Id, userId);
        editor.apply();
    }

    public static String getDefaults(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public static int getTypeId(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }
}
