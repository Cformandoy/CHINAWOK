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

public class SignUpActivity extends AppCompatActivity {


    TextInputEditText txtFullname, txtUsername,txtPassword,txtEmail;
    Button buttonSignUp;
    TextView textViewLoginHere;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtFullname = findViewById(R.id.fullname);
        txtUsername = findViewById(R.id.username);
        txtPassword = findViewById(R.id.password);
        txtEmail = findViewById(R.id.email);

        buttonSignUp = findViewById(R.id.btn_SignUp);

        textViewLoginHere = findViewById(R.id.textView_LoginHere);

        progressBar = findViewById(R.id.progress);





        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullname, username, password, email;
                fullname = String.valueOf(txtFullname.getText());
                username = String.valueOf(txtUsername.getText());
                password = String.valueOf(txtPassword.getText());
                email = String.valueOf(txtEmail.getText());

                if (!username.equals("") && !password.equals("") && !fullname.equals("") && !email.equals("")){
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = fullname;
                            data[1] = username;
                            data[2] = password;
                            data[3] = email;
                            PutData putData = new PutData("http://8.tcp.ngrok.io:16840/chinawok/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){

//                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });

                    //End Write and Read data with URL

                }



            }
        });

        textViewLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}