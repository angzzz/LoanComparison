package com.anjaleeps.loancomparison;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "details.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "data";
    private List<String> data;

    public DBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data(id integer , string text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists data");
        onCreate(db);
    }
}