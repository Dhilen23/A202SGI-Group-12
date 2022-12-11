package com.example.pdzcarrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class CarsActivity extends AppCompatActivity {
    TextView carbrand1, carmodel1, cartrans1, carprice1, carbrand2, carmodel2, cartrans2, carprice2, carbrand3, carmodel3, cartrans3, carprice3;
    DBHelper cartb;
    Button addcar1, addcar2, addcar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

     /*   cartb.insertDataCarOne();
        cartb.insertDataCarTwo();
        cartb.insertDataCarThree(); */

        carbrand1 = findViewById(R.id.textViewCar1);
        carmodel1 = findViewById(R.id.textViewCar11);
        cartrans1 = findViewById(R.id.textViewCar111);
        carprice1 = findViewById(R.id.textViewCar1111);

        carbrand2 = findViewById(R.id.textView66667);
        carmodel2 = findViewById(R.id.textView66668);
        cartrans2 = findViewById(R.id.textView66669);
        carprice2 = findViewById(R.id.textView66660);

        carbrand3 = findViewById(R.id.textVie7);
        carmodel3 = findViewById(R.id.textView771);
        cartrans3 = findViewById(R.id.textView772);
        carprice3 = findViewById(R.id.textView773);

        addcar1 = findViewById(R.id.button222);
        addcar2 = findViewById(R.id.button2222);
        addcar3 = findViewById(R.id.button22222);


        cartb = new DBHelper(this);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("thisUser");


        Cursor resc1 = cartb.getdataCar("Nissan");
        Cursor resc2 = cartb.getdataCar("Perodua");
        Cursor resc3 = cartb.getdataCar("Toyota");

        if (resc1.moveToFirst()) {
            carbrand1.setText(resc1.getString(1));
            carmodel1.setText(resc1.getString(2));
            cartrans1.setText(resc1.getString(3));
            carprice1.setText(resc1.getString(4));
        }


        if (resc2.moveToFirst()) {
            carbrand2.setText(resc2.getString(1));
            carmodel2.setText(resc2.getString(2));
            cartrans2.setText(resc2.getString(3));
            carprice2.setText(resc2.getString(4));
        }
        if (resc3.moveToFirst()) {
            carbrand3.setText(resc3.getString(1));
            carmodel3.setText(resc3.getString(2));
            cartrans3.setText(resc3.getString(3));
            carprice3.setText(resc3.getString(4));
        }


        addcar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkbook = cartb.checkbooking(str1, "Nissan");
                if (checkbook == false) {
                    Boolean insert = cartb.insertDataBooking(str1, currentDate, "Nissan", "GTR-35");
                    if (insert == true) {
                        Toast.makeText(CarsActivity.this, "Booking Successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CarsActivity.this, "Booking Failed!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CarsActivity.this, "Car Has Already Been Booked!", Toast.LENGTH_SHORT).show();
                }
            }



        });




        addcar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkbook = cartb.checkbooking(str1, "Perodua");
                if (checkbook == false) {
                    Boolean insert = cartb.insertDataBooking(str1, currentDate, "Perodua", "Myvi");
                    if (insert == true) {
                        Toast.makeText(CarsActivity.this, "Booking Successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CarsActivity.this, "Booking Failed!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CarsActivity.this, "Car Has Already Been Booked!", Toast.LENGTH_SHORT).show();
                }
            }



        });







        addcar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkbook = cartb.checkbooking(str1, "Toyota");
                if (checkbook == false) {
                    Boolean insert = cartb.insertDataBooking(str1, currentDate, "Toyota", "Vios");
                    if (insert == true) {
                        Toast.makeText(CarsActivity.this, "Booking Successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CarsActivity.this, "Booking Failed!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CarsActivity.this, "Car Has Already Been Booked!", Toast.LENGTH_SHORT).show();
                }
            }



        });








    }
}