package com.google.bikehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.bikehelper.model.UsersModel;
import com.google.bikehelper.retrofit.APIClient;
import com.google.bikehelper.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button btn_login;
    EditText username;
    EditText password;

    // String objectLocal = DataLocalManager.getStringObject();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button register = (Button) findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skip = new Intent(Login.this, Register.class);
                startActivity(skip);
            }
        });

        // Toast.makeText(Login.this, objectLocal, Toast.LENGTH_SHORT).show();

        login();
    }

    private void login() {
        btn_login = findViewById(R.id.btn_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                Call<UsersModel> call = APIClient.getApiClient().create(APIInterface.class).performUserLogin(user, pass, "123");
                call.enqueue(new Callback<UsersModel>() {

                    @Override
                    public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                        if (response.code() == 200) {
                            if (response.body().getResult_code() == 1) {
                                if (response.body().getUsername().equals("admin")){
                                    Toast.makeText(Login.this, "Qua admin", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Login.this, "Login success", Toast.LENGTH_SHORT).show();
                                    Intent skip = new Intent(Login.this, User_rescuers.class);
                                    startActivity(skip);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UsersModel> call, Throwable t) {
                        Toast.makeText(Login.this,"Login fail", Toast.LENGTH_SHORT).show();

                    }

                });
            }
        });

    }


}

