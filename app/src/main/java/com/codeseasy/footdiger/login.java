package com.codeseasy.footdiger;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class login extends AppCompatActivity {
    TextInputEditText textInputEditTextUsername,textInputEditTextPassword;
    Button btnLogin;
    TextView textViewSignUp;
    ProgressBar progressBar;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername =findViewById(R.id.usernameLg);
        textInputEditTextPassword =findViewById(R.id.passwordLg);
        btnLogin=findViewById(R.id.btnLogin);
        textViewSignUp=findViewById(R.id.signUpText);
        progressBar=findViewById(R.id.progressLg);
        textInputEditTextUsername.setText("");
        textInputEditTextPassword.setText("");
        textInputEditTextUsername.setTextColor(R.color.darkGrey);
        textInputEditTextPassword.setTextColor(R.color.darkGrey);
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),signup.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String Email, Password;
                Email = String.valueOf(textInputEditTextUsername.getText());
                Password = String.valueOf(textInputEditTextPassword.getText());
                if(!Email.equals("")&&!Password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "Email";
                            field[1] = "Password";
                            String[] data = new String[2];
                            data[0] = Email;
                            data[1] = Password;
                            PutData putData = new PutData("http://192.168.0.137/Android/foodtiger/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}