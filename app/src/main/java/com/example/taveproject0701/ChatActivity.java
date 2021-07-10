package com.example.taveproject0701;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatActivity extends AppCompatActivity {


    private RecyclerView chatsRV;
    private EditText userMsgEdt;
    private Button sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatsModel>chatsModelArrayList;
    private ChatRVAdapter chatRVAdapter;

    // page 내 기능 구현:

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_2);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.navigation_1:
                        Intent intent1 = new Intent(ChatActivity.this, MainActivity.class);
                        startActivity(intent1);
                        //finish();
                        return true;
                    case R.id.navigation_2:
                        //Intent intent2 = new Intent(MainActivity.this, ChatActivity.class);
                        //startActivity(intent2);
                        //finish();
                        return true;
                    case R.id.navigation_3:
                        Intent intent3 = new Intent(ChatActivity.this, MapActivity.class);
                        startActivity(intent3);
                        //finish();
                        return true;
                    case R.id.navigation_4:
                        Intent intent4 = new Intent(ChatActivity.this, ProfileActivity.class);
                        startActivity(intent4);
                        //finish();
                        return true;
                }
                return false;
            }
        });


        chatsRV = findViewById(R.id.chatList);
        userMsgEdt = findViewById(R.id.et_message);
        Button sendMsgFAB = (Button) findViewById(R.id.btn_send);
        chatsModelArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModelArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);

        sendMsgFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(ChatActivity.this, "Please Enter your message", Toast.LENGTH_SHORT).show();
                    return;
                }

                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });


    }


    private void getResponse(String message){
        chatsModelArrayList.add(new ChatsModel(message, USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=157566&key=Cnof8hsjVlfgNq7z&uid=[uid]&msg=" + message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MsgModel> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if(response.isSuccessful()){
                    MsgModel model = response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(),BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                chatsModelArrayList.add(new ChatsModel("이해를 하지 못했어요. 다시 한번 말씀해주세요.", BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();

            }
        });
    }







}