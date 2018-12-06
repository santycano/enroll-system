package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Time_Id extends DBHelper {
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public Time_Id(Context context, String time) {
        super(context);
        this.time = time;
        this.i=null;
    }
    @Override
    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_time,time);
        db.insert(TABLE_NAME_time_id, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_time,time);
        db.update(TABLE_NAME_time_id, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Time_Id time_id = null;
        Cursor cursor = db.query(TABLE_NAME_time_id,null,where,whereArgs,null,null,null);
        try {
        if (cursor.moveToFirst()) {
            // read column data
            View.OnClickListener onClickListener = null;
            Context context = null;
            time_id= new Time_Id( context,cursor.getString(cursor.getColumnIndex(Column_time)));
            time_id.setI(cursor.getString(cursor.getColumnIndex(Column_Interator)));
        }
    } finally {
        cursor.close();
    }
        return time_id;
}
    private String i;
    private String time;
}
