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

public class ChangePasswordActivity extends AppCompatActivity {

    TextInputEditText txtNewPassword, txtConfirmNewPassword, txtEmail;
    Button buttonChangePassword;
    TextView textViewSignUpHere, textViewLoginHere;

//    Bundle dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

//        dato = getIntent().getExtras();
//        String datoobtenido = dato.getString("pasardato");
//        TextView mostrardato = (TextView) findViewById(R.id.textView_Email);
//        mostrardato.setText(datoobtenido);

        txtNewPassword = findViewById(R.id.new_password);
        txtConfirmNewPassword = findViewById(R.id.confirm_new_password);
        txtEmail = findViewById(R.id.email_changepassword);

        buttonChangePassword = findViewById(R.id.btn_changePassword);

        textViewSignUpHere = findViewById(R.id.textView_SignUpHere);
        textViewLoginHere = findViewById(R.id.textView_LoginHere);
        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newpassword, confirmnewpassword, email;
                email = String.valueOf(txtEmail.getText());
                newpassword = String.valueOf(txtNewPassword.getText());
                confirmnewpassword = String.valueOf(txtConfirmNewPassword.getText());


                if ((!newpassword.equals("") && !confirmnewpassword.equals("")&& !email.equals(""))&& (newpassword.equals(confirmnewpassword))){
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "password";
                            field[1] = "email";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = newpassword;
                            data[1] = email;
//                            PutData putData = new PutData("http://192.168.101.4/chinawok/changepassword.php", "POST", field, data);
                            PutData putData = new PutData("http://4.tcp.ngrok.io:19050/chinawok/changepassword.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Password actualizada")){

                                        Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
//                                      Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        textViewSignUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}