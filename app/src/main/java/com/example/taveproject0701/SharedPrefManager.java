package com.example.taveproject0701;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String KEY_ID = "keyid";
    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_PWD = "keypwd";
    private static final String KEY_GENDER = "keygender";
    private static final String KEY_ISFARE = "keyisfare";
    private static final String KEY_INCOME = "keyincome";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_FAMILY = "keyfamily";
    private static final String KEY_LIFECYCLE = "keylifecycle";
    private static final String KEY_OBSTACLE = "keyobstacle";


    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PWD, user.getPwd());
        editor.putString(KEY_GENDER, user.getGender());
        editor.putString(KEY_INCOME, user.getIncome());
        editor.putString(KEY_ADDRESS, user.getIncome());
        editor.putString(KEY_ISFARE, user.getIsFare());
        editor.putString(KEY_FAMILY, user.getFamily());
        editor.putString(KEY_LIFECYCLE, user.getLifecycle());
        editor.putString(KEY_OBSTACLE, user.getObstacle());

        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PWD, null),
                sharedPreferences.getString(KEY_GENDER, null),
                sharedPreferences.getString(KEY_ISFARE, null),
                sharedPreferences.getString(KEY_INCOME, null),
                sharedPreferences.getString(KEY_ADDRESS, null),
                sharedPreferences.getString(KEY_FAMILY, null),
                sharedPreferences.getString(KEY_LIFECYCLE, null),
                sharedPreferences.getString(KEY_OBSTACLE, null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginActivity.class));
    }
}
