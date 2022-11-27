package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView curUser1;
    private String getUserName;
    ImageButton profilebutton, aboutbutton, carbutton, bookbutton;

  /*public int text111(){
      getUserName = "Hi, ";
      return
  }

*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        curUser1 = findViewById(R.id.textView11);
        profilebutton = findViewById(R.id.imageButton4);
        aboutbutton = findViewById(R.id.helpbutton1);
        carbutton = findViewById(R.id.imageButtoncar);
        bookbutton = findViewById(R.id.imageButtonbook);

     Intent intent = getIntent();
     String str = intent.getStringExtra("currentUser");
     curUser1.setText(str);

       /* Bundle extras = getIntent().getExtras();
        if (extras !=null){
            //text111();
            String curUser = extras.getString("currentUser");

        } */

     profilebutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String strUser = intent.getStringExtra("currentUser");

             Intent intent1= new Intent(getApplicationContext(),ProfileActivity.class);
             intent1.putExtra("thisUser", strUser);
             startActivity(intent1);
         }
     });

     aboutbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent2= new Intent(getApplicationContext(),AboutUsActivity.class);
             startActivity(intent2);
         }
     });


     carbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent3= new Intent(getApplicationContext(),CarsActivity.class);
             startActivity(intent3);
         }
     });

     bookbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent4= new Intent(getApplicationContext(),BookingActivity.class);
             startActivity(intent4);
         }
     });




    }
}