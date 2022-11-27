package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    EditText uppassword, upemail, upfullName, upcontact, uprepass;
    Button update;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        Intent intent = getIntent();
        String str11 = intent.getStringExtra("thisUsern");


        uppassword = findViewById(R.id.password11);
        uprepass = findViewById(R.id.repass11);
        upemail = findViewById(R.id.email11);
        upfullName = findViewById(R.id.fulln11);
        upcontact = findViewById(R.id.contact11);
        update = findViewById(R.id.update11);


        DB= new DBHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass= uppassword.getText().toString();
                String repass = uprepass.getText().toString();
                String em= upemail.getText().toString();
                String fulln= upfullName.getText().toString();
                String cnt= upcontact.getText().toString();
                String currname = str11;

                if(TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(em) || TextUtils.isEmpty(fulln)
                        || TextUtils.isEmpty(cnt))
                {
                    Toast.makeText(UpdateActivity.this, "All Fields Must Be Filled!", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){


                            Boolean update = DB.updatedata(currname,pass,em,fulln,cnt);
                            if(update==true) {
                                Toast.makeText(UpdateActivity.this, "Update Successful!", Toast.LENGTH_SHORT);
                                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                                finish();
                                startActivity(intent);
                            }

                    }else{
                        Toast.makeText(UpdateActivity.this, "Password Unmatched", Toast.LENGTH_SHORT);
                    }
                }


            }
        });



    }
}