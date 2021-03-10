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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname ,textInputEditTextPhoneNumber,textInputEditTextAdress,textInputEditTextPassword,textInputEditTextPassword2,textInputEditTextEmail;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textInputEditTextFullname =findViewById(R.id.fullname);
        textInputEditTextPhoneNumber =findViewById(R.id.phone);
        textInputEditTextAdress =findViewById(R.id.adress);
        textInputEditTextPassword =findViewById(R.id.password);
        textInputEditTextPassword2 =findViewById(R.id.password2);
        textInputEditTextEmail =findViewById(R.id.email);
        buttonSignUp =findViewById(R.id.buttonSignUp);
        textViewLogin=findViewById(R.id.loginText);
        progressBar=findViewById(R.id.progress);
        textInputEditTextFullname.setText("");
        textInputEditTextPhoneNumber.setText("");
        textInputEditTextAdress.setText("");
        textInputEditTextPassword.setText("");
        textInputEditTextPassword2.setText("");
        textInputEditTextEmail.setText("");
        textInputEditTextFullname.setTextColor(R.color.darkGrey);
        textInputEditTextPhoneNumber.setTextColor(R.color.darkGrey);
        textInputEditTextPassword.setTextColor(R.color.darkGrey);
        textInputEditTextPassword2.setTextColor(R.color.darkGrey);
        textInputEditTextAdress.setTextColor(R.color.darkGrey);
        textInputEditTextEmail.setTextColor(R.color.darkGrey);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Name, PhoneNo, Address,Password,password2, Email;
                Name = String.valueOf(textInputEditTextFullname.getText());
                PhoneNo = String.valueOf(textInputEditTextPhoneNumber.getText());
                Password = String.valueOf(textInputEditTextPassword.getText());
                Address = String.valueOf(textInputEditTextAdress.getText());
                Email = String.valueOf(textInputEditTextEmail.getText());
                password2 = String.valueOf(textInputEditTextPassword2.getText());
                if(!Name.equals("")&&!PhoneNo.equals("")&&!Password.equals("")&&!Email.equals("")&&!Address.equals("")&&!password2.equals("")) {
                    if(validName(Name)) {
                        if (validEmail(Email)) {
                            if (validPhoneNumber(PhoneNo) || validPhoneNumber2(PhoneNo) || validPhoneNumber3(PhoneNo)  || validPhoneNumber4(PhoneNo)) {
                                if (Password.length() == 6) {
                                    if (Password.equals(password2)) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                String[] field = new String[5];
                                                field[0] = "Name";
                                                field[1] = "Email";
                                                field[2] = "PhoneNo";
                                                field[3] = "Address";
                                                field[4] = "Password";
                                                String[] data = new String[5];
                                                data[0] = Name;
                                                data[1] = Email;
                                                data[2] = PhoneNo;
                                                data[3] = Address;
                                                data[4] = Password;
                                                PutData putData = new PutData("http://192.168.0.137/Android/foodtiger/signup.php", "POST", field, data);
                                                if (putData.startPut()) {
                                                    if (putData.onComplete()) {
                                                        String result = putData.getResult();
                                                        if (result.equals("Sign Up Success")) {
                                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                            Intent intent = new Intent(getApplicationContext(), login.class);
                                                            startActivity(intent);
                                                            finish();
                                                        } else {
                                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                            }
                                        });
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Password not match", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Password length must be 6 or more", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid Phone Number format", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Email format", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid using Number in Fullname textfield", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public static boolean validPhoneNumber(String input) {
        Pattern p = Pattern.compile("([0-9]{3}[- .]?[0-9]{7})");
        Matcher m = p.matcher(input);
        return (m.find() && m.group().equals(input));
    }

    public static boolean validPhoneNumber2(String input) {
        Pattern p2 = Pattern.compile("([0-9]{3}[- .]?[0-9]{8})");
        Matcher m2 = p2.matcher(input);
        return (m2.find() && m2.group().equals(input));
    }

    public static boolean validPhoneNumber3(String input) {
        Pattern p3 = Pattern.compile("([0-9]{11})");
        Matcher m3 = p3.matcher(input);
        return (m3.find() && m3.group().equals(input));
    }

    public static boolean validPhoneNumber4(String input) {
        Pattern p4 = Pattern.compile("([0-9]{12})");
        Matcher m4 = p4.matcher(input);
        return (m4.find() && m4.group().equals(input));
    }

    public static boolean validEmail(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean validName(String input) {
        return input.matches("[a-zA-Z]+");
    }
}