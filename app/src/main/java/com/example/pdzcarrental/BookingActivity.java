package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {

    TextView bookcar1, bookdate1, bookmodel1, bookcar2, bookdate2, bookmodel2, bookcar3, bookdate3, bookmodel3;
    DBHelper booktb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);





        bookcar1 = findViewById(R.id.textView609);
        bookdate1= findViewById(R.id.textView60007);
        bookmodel1 = findViewById(R.id.model1);
        bookcar2= findViewById(R.id.textView607);
        bookdate2= findViewById(R.id.textView608);
        bookmodel2= findViewById(R.id.model2);
        bookcar3= findViewById(R.id.textView67);
        bookdate3= findViewById(R.id.textView6009);
        bookmodel3= findViewById(R.id.model3);


        booktb = new DBHelper(this);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("thisUser");

        Cursor resb1 = booktb.getbookingData(str1, "Nissan");
        Cursor resb2 = booktb.getbookingData(str1, "Perodua");
        Cursor resb3 = booktb.getbookingData(str1, "Toyota");



        if (resb1.moveToFirst()) {
            bookdate1.setText(resb1.getString(2));
            bookcar1.setText(resb1.getString(3));
            bookmodel1.setText(resb1.getString(4));

        }


        if (resb2.moveToFirst()) {
            bookdate2.setText(resb2.getString(2));
            bookcar2.setText(resb2.getString(3));
            bookmodel2.setText(resb2.getString(4));

        }

        if (resb3.moveToFirst()) {
            bookdate3.setText(resb3.getString(2));
            bookcar3.setText(resb3.getString(3));
            bookmodel3.setText(resb3.getString(4));

        }








    }
}