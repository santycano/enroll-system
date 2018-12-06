package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Date_id extends DBHelper {
    private String date;
    private String i;

    public Date_id(Context context, String date) {
        super(context);
        this.date = date;
        this.i=null;
    }
@Override
    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_date,date);

        db.insert(TABLE_NAME_date_id, null, contentValues);
        db.close();
    return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_date,date);
        db.update(TABLE_NAME_date_id, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Date_id date_id = null;
        Cursor cursor = db.query(TABLE_NAME_date_id,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                date_id= new Date_id( context,cursor.getString(cursor.getColumnIndex(Column_date)));
                date_id.setI(cursor.getString(cursor.getColumnIndex(Column_Interator)));
            }
        } finally {
            cursor.close();
        }
        return date_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }
}
