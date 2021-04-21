package com.example.prev_ques;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "alluser.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS(username text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public boolean insertUser(String username){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        long result = mydb.insert("users", null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getUser(){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor res = mydb.rawQuery("Select username from users", null);
        return res;
    }
}
