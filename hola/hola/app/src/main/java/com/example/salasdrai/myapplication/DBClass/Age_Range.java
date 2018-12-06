package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Age_Range extends DBHelper {
    private String range;

    public Age_Range(Context context, String range) {
        super(context);
        this.range = range;
    }

    @Override
    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_age_range,range);

        db.insert(TABLE_NAME_age_range, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_age_range,range);

        db.update(TABLE_NAME_age_range, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Cursor cursor = db.query(TABLE_NAME_age_range,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                range=cursor.getString(cursor.getColumnIndex(Column_age_range));
            }
        } finally {
            cursor.close();
        }
        return range;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
