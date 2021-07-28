package com.example.api_php_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.api_php_demo.model.AppMenuResponse;
import com.example.api_php_demo.model.Variablebag;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    EditText user_id, user_name, user_mobile, user_password, create_date;
    Button login;
    RestCall call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_id = (EditText) findViewById(R.id.user_id);
        user_name = (EditText) findViewById(R.id.user_name);
        user_mobile = (EditText) findViewById(R.id.user_mobile);
        user_password = (EditText) findViewById(R.id.user_password);
        create_date = (EditText) findViewById(R.id.create_date);

        login = (Button) findViewById(R.id.login_btn);

        call = RestClient.createService(RestCall.class, Variablebag.BaseUrl,
                "",
                "", "");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                getAppmenu();
            }
        });
    }

    private void getAppmenu() {

//        call.getAppMenu("123567890", "dhruvi@123", "checklogin")
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<AppMenuResponse>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(AppMenuResponse appMenuResponse) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (appMenuResponse.getStatus().equals("200")) {
//                                    Toast.makeText(MainActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
//
//                                    if (appMenuResponse.getUserId() == String.valueOf(true)) {
//                                        String id = user_id.getText().toString();
//                                        String name = user_name.getText().toString();
//
//                                        user_id.setText(id);
//                                        user_name.setText(name);
//                                    } else {
//                                        Toast.makeText(MainActivity.this, "Failed!!", Toast.LENGTH_SHORT).show();
//
//                                    }
//
////                                    Toast.makeText(MainActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    }
//                });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Variablebag.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestCall api = retrofit.create(RestCall.class);
        Call<AppMenuResponse> call = api.getAppMenu("123567890", "dhruvi@123", "checklogin");
        call.enqueue(new Callback<AppMenuResponse>() {
            @Override
            public void onResponse(Call<AppMenuResponse> call, Response<AppMenuResponse> response) {
                if (response.isSuccessful()) {
                    user_id.setText("");
                    user_name.setText("");
                    user_mobile.setText("");
                    user_password.setText("");
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AppMenuResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void onStop() {
        super.onStop();
    }
}