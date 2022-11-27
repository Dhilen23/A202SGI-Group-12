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

    public static final String DBNAME = "login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table users(username TEXT primary key, password TEXT, email TEXT, fullName TEXT, contact TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL("drop table if exists users");


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

    public Boolean checkusername(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
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
