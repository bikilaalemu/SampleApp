package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(@Nullable Context context) {
        super(context, "mad", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
       sq.execSQL("CREATE TABLE users ( id INTEGER PRIMARY KEY, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq, int i, int i1) {
      sq.execSQL("drop table if exists users");
    }

    public boolean insert(String un,String pass){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",un);
        cv.put("password",pass);
        long r=db.insert("users",null,cv);

        return (r!=-1)? true : false;
    }

    public Cursor getData(){
        Cursor c=null;
        SQLiteDatabase db=getReadableDatabase();
        c=db.rawQuery("select username,password from users",null);
        if(c.getCount()>0){

            return c;
        }
        return null;
    }
}
