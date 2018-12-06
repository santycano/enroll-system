package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Locate extends DBHelper {
    private String location;
    private String i;

    public Locate(Context context, String location) {
        super(context);
        this.location = location;
        this.i = null;
    }

    @Override
    public boolean insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_locate,location);

        db.insert(TABLE_NAME_locate, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Locate locate = null;
        Cursor cursor = db.query(TABLE_NAME_locate,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                Context context = null;
                locate=new Locate(context,cursor.getString(cursor.getColumnIndex(Column_locate)));
                locate.setI(cursor.getString(cursor.getColumnIndex(Column_Interator)));
            }
        } finally {
            cursor.close();
        }
        db.close();
        return locate;

    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_locate,location);
        db.update(TABLE_NAME_locate, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }


}
