package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Type_Id extends DBHelper {
    private String type;

    public Type_Id(Context context,String type) {
        super(context);
        this.type = type;
    }

    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
            contentValues.put(Column_type,type);
        db.insert(TABLE_NAME_type_id, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_type,type);
        db.update(TABLE_NAME_type_id, contentValues, "i = ? ", new String[] { id } );
        return true;
    }
    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Cursor cursor = db.query(TABLE_NAME_type_id,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                type=cursor.getString(cursor.getColumnIndex(Column_type));
            }
        } finally {
            cursor.close();
        }
        return type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
