package com.example.pdzcarrental;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView user1, email1, fullName1, contact1;
    DBHelper DB;
    Button update1, homert1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        update1= findViewById(R.id.update_button);
        user1 =findViewById(R.id.textViewUser);
        email1 = findViewById(R.id.textViewEmail);
        fullName1 = findViewById(R.id.textViewName);
        contact1 = findViewById(R.id.textViewContact);
        homert1 = findViewById(R.id.back2home);

        //call database
        DB = new DBHelper(this);




        Intent intent = getIntent();
        String str1 = intent.getStringExtra("thisUser");


        Cursor res = DB.getdata(str1);

        if(res.moveToFirst())
        {
            user1.setText(res.getString(0));
            email1.setText(res.getString(2));
            fullName1.setText(res.getString(3));
            contact1.setText(res.getString(4));
        }


      update1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent= new Intent(getApplicationContext(),UpdateActivity.class);
              intent.putExtra("thisUsern", str1);
              startActivity(intent);
          }
      });


        homert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtra("thisUsern", str1);
                startActivity(intent);
            }
        });




    }
}