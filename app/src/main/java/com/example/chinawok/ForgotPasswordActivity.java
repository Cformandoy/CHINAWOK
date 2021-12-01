package com.example.chinawok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputEditText txtEmail, txtUsername;
    Button buttonSendEmail;
    TextView textViewSignUpHere, textViewLoginHere;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        txtEmail = findViewById(R.id.email_forgotpassword);
        txtUsername = findViewById(R.id.username_forgotpassword);

        buttonSendEmail = findViewById(R.id.btn_sendEmail);


        textViewSignUpHere = findViewById(R.id.textView_SignUpHere);
        textViewLoginHere = findViewById(R.id.textView_LoginHere);

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email, username;

                email = String.valueOf(txtEmail.getText());
                username = String.valueOf(txtUsername.getText());

//                Intent dardato = new Intent(ForgotPasswordActivity.this, ChangePasswordActivity.class);
//                dardato.putExtra("pasardato", "nombre");


                if (!email.equals("")){

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "username";



                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = email;
                            data[1] = username;

                            PutData putData = new PutData("http://8.tcp.ngrok.io:16840/chinawok/forgotpassword.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    String result = putData.getResult();
                                    if (result.equals("Usuario verificado")){
                                        Intent intent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
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


        textViewLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        textViewSignUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });



    }


}