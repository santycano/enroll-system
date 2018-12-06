package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Sub_U extends DBHelper {
    private String sub_U;

    public Sub_U(Context context, String sub_U) {
        super(context);
        this.sub_U = sub_U;
    }

    public String getSub_U() {
        return sub_U;
    }

    public void setSub_U(String sub_U) {
        this.sub_U = sub_U;
    }
@Override
    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
            contentValues.put(Column_subU,sub_U);

        db.insert(TABLE_NAME_catU, null, contentValues);
        db.close();
    return true;
}

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_subU,sub_U);
        db.update(TABLE_NAME_catU, contentValues, "i = ? ", new String[] { id } );
        return true;
    }
    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Date_id date_id = null;
        Cursor cursor = db.query(TABLE_NAME_catU,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                date_id= new Date_id( context,cursor.getString(cursor.getColumnIndex(Column_subU)));
            }
        } finally {
            cursor.close();
        }
        return date_id;
    }
}
