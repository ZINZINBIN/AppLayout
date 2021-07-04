package com.example.taveproject0701;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_RegisEnd;

    String[] items = {"1분위", "2분위", "3분위", "4분위", "5분위", "6분위", "7분위", "8분위","9분위"};
    TextView tv_spinner;

    String[] city_items = {"서울특별시"};
    String[] local_items = {"강북구","강서구", "강동구", "강남구", "마포구", "영등포구", "관악구", "종로구", "노원구)"};
    TextView addSpinner_tv1;
    TextView addSpinner_tv2;

    String[] family_relationships = {"한부모","다문화","저소득층","소년,소녀 가장"};
    TextView frSpinner_tv;

    String[] life_cycle = {"영유아","아동,청소","청년", "중장년", "노년", "임신,출산"};
    TextView lcSpinner_tv;

    String[] obs_items = {"해당사항 없음","시각 장애", "청각 장애", "지체 장애", "신체 장애","기타"};
    TextView obsSpinner_tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //hide actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // spinner(소득분위)
        Spinner spinner = findViewById(R.id.spinner);
        tv_spinner = findViewById(R.id.spinner_tv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_spinner.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv_spinner.setText("소득분위: 선택");
            }
        });

        // spinner(주소)
        Spinner spinner_add1 = findViewById(R.id.spinner_add1);
        Spinner spinner_add2 = findViewById(R.id.spinner_add2);

        addSpinner_tv1 = findViewById(R.id.addSpinner_tv1);
        addSpinner_tv2 = findViewById(R.id.addSpinner_tv2);

        ArrayAdapter<String> adapter_add1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city_items);
        adapter_add1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_add1.setAdapter(adapter_add1);
        spinner_add1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addSpinner_tv1.setText(city_items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                addSpinner_tv1.setText("선택)");
            }
        });

        ArrayAdapter<String> adapter_add2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, local_items);
        adapter_add2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_add2.setAdapter(adapter_add2);
        spinner_add2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addSpinner_tv2.setText(local_items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                addSpinner_tv2.setText("선택)");
            }
        });


        //spinner(가족관계)

        Spinner spinner_fr = findViewById(R.id.spinner_fr);
        frSpinner_tv = findViewById(R.id.frSpinner_tv);

        ArrayAdapter<String> adapter_fr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, family_relationships);
        adapter_fr.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_fr.setAdapter(adapter_fr);
        spinner_fr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                frSpinner_tv.setText(family_relationships[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                frSpinner_tv.setText("가족관계: 선택");
            }
        });


        //spinner(생애주기)

        Spinner spinner_lc = findViewById(R.id.spinner_lc);
        lcSpinner_tv = findViewById(R.id.lcSpinner_tv);

        ArrayAdapter<String> adapter_lc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, life_cycle);
        adapter_lc.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_lc.setAdapter(adapter_lc);
        spinner_lc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lcSpinner_tv.setText(life_cycle[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lcSpinner_tv.setText("생애주기: 선택");
            }
        });

        // spinner(장애 여부)
        Spinner spinner_obs = findViewById(R.id.spinner_obs);
        obsSpinner_tv = findViewById(R.id.obsSpinner_tv);

        ArrayAdapter<String> adapter_obs = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obs_items);
        adapter_obs.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_obs.setAdapter(adapter_obs);
        spinner_obs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                obsSpinner_tv.setText(obs_items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                obsSpinner_tv.setText("장애여부: 선택");
            }
        });



        // register process
        Button btn_RegisEnd = (Button)findViewById(R.id.btn_RegisEnd);
        btn_RegisEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}