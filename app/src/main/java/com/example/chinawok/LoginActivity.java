package com.example.chinawok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText txtUsername, txtPassword;
    Button buttonLogin;
    TextView textViewSignUpHere, textViewForgotPassword;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.username_login);
        txtPassword = findViewById(R.id.password_login);

        buttonLogin = findViewById(R.id.btn_login);

        textViewSignUpHere = findViewById(R.id.textView_SignUpHere);
        textViewForgotPassword = findViewById(R.id.textView_ForgotPassword_Login);

        progressBar = findViewById(R.id.progress_login);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username, password;

                username = String.valueOf(txtUsername.getText());
                password = String.valueOf(txtPassword.getText());

                if (!username.equals("") && !password.equals("")){
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";


                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("http://4.tcp.ngrok.io:19050/chinawok/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    progressBar.setVisibility(View.GONE);

                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        Intent intent = new Intent(LoginActivity.this, NavegationDrawerActivity.class);

                                        Bundle miBundle = new Bundle();
                                        miBundle.putString("user",username);
                                        intent.putExtras(miBundle);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                }
                            }

                        }});

                    //End Write and Read data with URL
                }else {
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }


            }
        });

        textViewSignUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


    }


}