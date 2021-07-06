package com.example.taveproject0701;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class ChatbotActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        //Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.menu_chatbot);

        //Perform ItemSelectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_chatbot:
                        return true;

                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_map:
                        startActivity(new Intent(getApplicationContext(), MapActivity.class ));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });
    }
}