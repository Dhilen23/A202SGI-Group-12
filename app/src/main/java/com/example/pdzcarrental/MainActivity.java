package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword, email, fullName, contact;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        email = findViewById(R.id.email);
        fullName = findViewById(R.id.fullName);
        contact = findViewById(R.id.contact);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        DB= new DBHelper(this);

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String user= username.getText().toString();
              String pass= password.getText().toString();
              String repass= repassword.getText().toString();
              String em= email.getText().toString();
              String fulln= fullName.getText().toString();
              String cnt= contact.getText().toString();

              if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(em)
                      || TextUtils.isEmpty(fulln) || TextUtils.isEmpty(cnt))
               {
                   Toast.makeText(MainActivity.this, "All Fields Must Be Filled!", Toast.LENGTH_SHORT).show();
               }else{
                  if(pass.equals(repass)){
                      Boolean checkuser = DB.checkusername(user);
                      if(checkuser==false){
                          Boolean insert = DB.insertData(user,pass,em,fulln,cnt);
                          if(insert==true){
                              Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                              startActivity(intent);

                          }else {
                              Toast.makeText(MainActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();


                          }

                          }else{
                          Toast.makeText(MainActivity.this, "User already Exists", Toast.LENGTH_SHORT).show();
                      }
                      }else{
                      Toast.makeText(MainActivity.this, "Password Unmatched", Toast.LENGTH_SHORT).show();
                  }
               }


           }
       });

       signin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
             startActivity(intent);
           }
       });

    }
}