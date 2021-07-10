package com.example.taveproject0701;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // toobar_edit 호출
        Toolbar tb_edit = (Toolbar)findViewById(R.id.toolbar_edit);
        setSupportActionBar(tb_edit);

    }
}