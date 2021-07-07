package com.example.taveproject0701;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    // page 내 기능 구현:

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_4);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.navigation_1:
                        Intent intent1 = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent1);
                        //finish();
                        return true;
                    case R.id.navigation_2:
                        Intent intent2 = new Intent(ProfileActivity.this, ChatActivity.class);
                        startActivity(intent2);
                        //finish();
                        return true;
                    case R.id.navigation_3:
                        Intent intent3 = new Intent(ProfileActivity.this, MapActivity.class);
                        startActivity(intent3);
                        //finish();
                        return true;
                    case R.id.navigation_4:
                        //Intent intent4 = new Intent(ProfileActivity.this, ProfileActivity.class);
                        //startActivity(intent4);
                        //finish();
                        return true;
                }
                return false;
            }
        });
    }

}