package com.example.taveproject0701;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    // register
    EditText et_username;
    EditText et_email;
    EditText et_pwd;
    String et_gender;
    String et_isFare;

    // 성별, 보훈여부
    RadioButton rb_male;
    RadioButton rb_isFare;


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

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            return;
        }

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_pwd = findViewById(R.id.et_pwd);

        // gender, isFare처럼 RadioButton 형태는 boolean -> string으로 구현
        // 나머지 값은 addSpinner 형태의 string으로 구현

        // gender
        rb_male = (RadioButton)findViewById(R.id.btn_male);
        boolean isMale = rb_male.isChecked();
        if(isMale){
            et_gender = "남성";
        }
        else{
            et_gender = "여성";
        }

        // 보훈대상:
        rb_isFare = (RadioButton)findViewById(R.id.btn_true);
        boolean isFare = rb_isFare.isChecked();
        if(isFare){
            et_isFare = "보훈대상";
        }
        else{
            et_isFare = "해당없음";
        }

        Button btn_RegisEnd = (Button)findViewById(R.id.btn_register);
        btn_RegisEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser(){
        final String username = et_username.getText().toString().trim();
        final String email = et_email.getText().toString().trim();
        final String pwd = et_pwd.getText().toString().trim();
        final String gender = et_gender;
        final String isFare = et_isFare;
        final String income = tv_spinner.getText().toString().trim();
        final String address = addSpinner_tv1.getText().toString().trim();
        address.concat(" ").concat(addSpinner_tv2.getText().toString().trim());
        final String family = frSpinner_tv.getText().toString().trim();
        final String lifecycle = lcSpinner_tv.getText().toString().trim();
        final String obstacle = obsSpinner_tv.getText().toString().trim();


        if(TextUtils.isEmpty(username)){
            et_username.setError("이름을 입력하시기 바립니다.");
            et_username.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(email)){
            et_email.setError("이메일을 입력하시기 바립니다.");
            et_email.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(pwd)){
            et_pwd.setError("패스워드를 입력하시기 바립니다.");
            et_pwd.requestFocus();
        }

        if(TextUtils.isEmpty(gender)){
            rb_male.setError("성별을 입력해주시기 바립니다");
            rb_male.requestFocus();
        }

        if(TextUtils.isEmpty(isFare)){
            rb_isFare.setError("보훈 여부를 입력해주시기 바랍니다.");
            rb_isFare.requestFocus();
        }

        if(TextUtils.isEmpty(income)){
            tv_spinner.setError("소득분위를 입력해주시기 바랍니다.");
            tv_spinner.requestFocus();
        }
        if(TextUtils.isEmpty(address)){
            addSpinner_tv1.setError("주소를 입력해주시기 바립니다.");
            addSpinner_tv1.requestFocus();
        }
        if(TextUtils.isEmpty(family)){
            frSpinner_tv.setError("가족 관계를 입력해주시기 바랍니다.");
            frSpinner_tv.requestFocus();
        }
        if(TextUtils.isEmpty(lifecycle)){
            lcSpinner_tv.setError("생애주기를 입력해주시기 바랍니다.");
            lcSpinner_tv.requestFocus();
        }
        if(TextUtils.isEmpty(obstacle)){
            obsSpinner_tv.setError("장애여부를 입력해주시기 바랍니다.");
            obsSpinner_tv.requestFocus();
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.url_register,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                Toast.makeText(getApplicationContext(),obj.getString("message"), Toast.LENGTH_SHORT).show();

                                // getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getString("username"),
                                        userJson.getString("email"),
                                        userJson.getString("pwd"),
                                        userJson.getString("gender"),
                                        userJson.getString("isFare"),
                                        userJson.getString("income"),
                                        userJson.getString("address"),
                                        userJson.getString("family"),
                                        userJson.getString("lifecycle"),
                                        userJson.getString("obstacle")
                                );

                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                Toast.makeText(getApplicationContext(), "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", pwd);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}