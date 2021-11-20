package com.google.bikehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.bikehelper.model.UsersModel;
import com.google.bikehelper.model.UsersRegister;
import com.google.bikehelper.retrofit.APIClient;
import com.google.bikehelper.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Button btn_register;
    EditText full_name;
    EditText username;
    EditText password;
    EditText phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register();
    }
    private void register() {
        btn_register = findViewById(R.id.btn_register);
        full_name = findViewById(R.id.full_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phone_number = findViewById(R.id.phone_number);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String name = full_name.getText().toString();
                String phone = phone_number.getText().toString();

                Call<UsersRegister> call = APIClient.getApiClient().create(APIInterface.class).performUserLogin(user, pass, name, phone);
                call.enqueue(new Callback<UsersRegister>() {

                    @Override
                    public void onResponse(Call<UsersRegister> call, Response<UsersRegister> response) {
                        if (response.code() == 200) {
                            if (response.body().getResult_code() == 1) {
                                Toast.makeText(Register.this, "Register success", Toast.LENGTH_SHORT).show();
                                Intent skip = new Intent(Register.this, Login.class);
                                startActivity(skip);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UsersRegister> call, Throwable t) {
                        Toast.makeText(Register.this, "Register fail", Toast.LENGTH_SHORT).show();

                    }

                });
            }
        });

    }

}
