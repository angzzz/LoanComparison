package com.anjaleeps.loancomparison;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Database {

    private static DBHelper dbHelper;
    private SQLiteDatabase db;

    public Database(Context context){
        dbHelper = new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }
    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }

    public void insertData(int id, String string){
        this.db=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("string",string);
        db.insert("data",null,values);
    }

    public void setDbConnection(){
        this.db=dbHelper.getReadableDatabase();
    }
}