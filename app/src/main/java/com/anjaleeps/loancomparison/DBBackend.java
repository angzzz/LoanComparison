package com.anjaleeps.loancomparison;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DBBackend extends Database {

    public DBBackend(Context context){
        super(context);
    }

    public List<Entry> searchDatabase(String searchWord) {
        List<Entry> mItems = new ArrayList<Entry>();
        String query = "Select * from data where string like " + "'%" + searchWord + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<Entry> wordTerms = new ArrayList<Entry>();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String string = cursor.getString(cursor.getColumnIndexOrThrow("string"));
                mItems.add(new Entry(id, string));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }

}
