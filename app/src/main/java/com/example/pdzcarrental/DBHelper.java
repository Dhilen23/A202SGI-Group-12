package com.example.pdzcarrental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "pandeezy.db";
    public DBHelper(Context context) {
        super(context, "pandeezy.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table users(username TEXT primary key, password TEXT, email TEXT, fullName TEXT, contact TEXT)");
    db.execSQL("create table cars(carid TEXT primary key, carbrand TEXT, carmodel TEXT, cartransmission TEXT, carprice TEXT)");
    db.execSQL("create table bookings(bookid INTEGER PRIMARY KEY, bookuser TEXT, bookdate TEXT, bookcar TEXT, bookmodel TEXT)");

        ContentValues values = new ContentValues();

        values.put("carid", "0001");
        values.put("carbrand", "Nissan");
        values.put("carmodel", "GTR-35");
        values.put("cartransmission", "Manual");
        values.put("carprice", "RM750/day" );

        db.insert("cars", null, values);




         ContentValues values2 = new ContentValues();

        values2.put("carid", "0002");
        values2.put("carbrand", "Perodua");
        values2.put("carmodel", "Myvi");
        values2.put("cartransmission", "Auto");
        values2.put("carprice", "RM99/day" );

        db.insert("cars", null, values2);

        ContentValues values3 = new ContentValues();

        values3.put("carid", "0003");
        values3.put("carbrand", "Toyota");
        values3.put("carmodel", "Vios");
        values3.put("cartransmission", "Auto");
        values3.put("carprice", "RM115/day" );

        db.insert("cars", null, values3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL("drop table if exists users");
   db.execSQL("drop table if exists cars");
   db.execSQL("drop table if exists bookings");
 onCreate(db);

    }

  /*  public void insertDataCarOne(){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("carid", "0001");
        values.put("carbrand", "Nissan");
        values.put("carmodel", "GTR-35");
        values.put("cartransmission", "Manual");
        values.put("carprice", "RM750/day" );

        db.insert("cars", null, values);

    }


    public void insertDataCarTwo(){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("carid", "0002");
        values.put("carbrand", "Perodua");
        values.put("carmodel", "Myvi");
        values.put("cartransmission", "Auto");
        values.put("carprice", "RM99/day" );

        db.insert("cars", null, values);

    }

    public void insertDataCar(String carid, String carbrand, String carmodel, String cartransmission, String carprice){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("carid", carid);
        values.put("carbrand", carbrand);
        values.put("carmodel", carmodel);
        values.put("cartransmission", cartransmission);
        values.put("carprice", carprice );

        db.insert("cars", null, values);

    } */


    public Cursor getdataCar(String carbrand){
        Log.d("DBHelper", "Reading cars");
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor result1 = db.rawQuery("select * from cars where carbrand=?", new String[] {carbrand});

        return result1;

    }

    public Cursor getbookingData(String bookuser, String bookcar){
        Log.d("DBHelper", "Reading bookings");
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor result2 = db.rawQuery("select * from bookings where bookuser=? and bookcar=?", new String[] {bookuser, bookcar});

        return result2;
    }



    public Boolean insertData(String username, String password, String email, String fullName, String contact){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);
        values.put("email", email);
        values.put("fullName", fullName);
        values.put("contact", contact);

        long results= db.insert("users", null, values);
        if(results==-1) return false;
        else
            return true;
    }

    public Boolean insertDataBooking(String bookuser, String bookdate, String bookcar, String bookmodel){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("bookuser", bookuser);
        values.put("bookdate", bookdate);
        values.put("bookcar", bookcar);
        values.put("bookmodel", bookmodel);

        long results= db.insert("bookings", null, values);
        if(results==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkbooking(String bookuser, String bookcar){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from bookings where bookuser=? and bookcar=?", new String[] {bookuser,bookcar});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }





    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getdata(String username){
        Log.d("DBHelper", "Reading username");
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from users where username=?", new String[] {username});

        return result;

    }

    public boolean updatedata(String currentname, String password, String email, String fullName, String contact){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues upd8 = new ContentValues();

        upd8.put("password", password);
        upd8.put("email", email);
        upd8.put("fullName", fullName);
        upd8.put("contact", contact);
        db.update("users", upd8, "username=?", new String[] {currentname});

        return true;


    }

}
