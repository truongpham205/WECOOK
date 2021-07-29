package com.example.cookhappy.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cookhappy.models.ThucDon;

import java.util.ArrayList;

public class

DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key,password TEXT)");
        MyDB.execSQL("create Table thucdon(name TEXT primary key,detail TEXT ,description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("Drop Table if exists users");
        MyDB.execSQL("Drop Table if exists thucdon");
    }

    //    public boolean insertThucDon(String name, String chitiet){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("detail", chitiet);
//        long result = MyDB.insert("thucdon", null, contentValues);
//        return (result != -1);
//    }
    public boolean insertThucDon(ThucDon thucDon) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", thucDon.ten);
        contentValues.put("description", thucDon.mota);
        contentValues.put("detail", thucDon.noidung);
        long result = MyDB.insert("thucdon", null, contentValues);
        return (result != -1);
    }

    public ArrayList<ThucDon> getListThucDon(ThucDon thucDon) {
        ArrayList<ThucDon> arrayList = new ArrayList<ThucDon>();
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor  cursor = MyDB.rawQuery("select * from thucdon",null);
        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String descrip = cursor.getString(cursor.getColumnIndex("description"));
                String content = cursor.getString(cursor.getColumnIndex("detail"));
                ThucDon thucDon1 = new ThucDon(name,descrip,content);
                arrayList.add(thucDon1);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }


    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        return (result != -1);

    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        return (cursor.getCount() > 0);
    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select *from users where username=? and password =?", new String[]{username, password});
        return (cursor.getCount() > 0);
    }
}
