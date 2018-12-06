package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Categoria extends DBHelper {
    private String ageRange;
    private String type;
    private String sex;
    private String i;

    public Categoria(Context context,String ageRange, String type, String sex ) {
        super(context);
        this.ageRange = ageRange;
        this.type = type;
        this.sex = sex;
        this.i=null;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    @Override
    public boolean insert () {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put(Column_age_range_id, ageRange);
        contentValues.put(Column_type_id, type);
        contentValues.put(Column_sex, sex);

        db.insert(TABLE_NAME_category_num, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_age_range_id, ageRange);
        contentValues.put(Column_type_id, type);
        contentValues.put(Column_sex, sex);
        db.update(TABLE_NAME_category_num, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Categoria categoria = null;
        Cursor cursor = db.query(TABLE_NAME_category_num,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                categoria= new Categoria( context,cursor.getString(cursor.getColumnIndex(Column_age_range_id)),cursor.getString(cursor.getColumnIndex(Column_type_id)),cursor.getString(cursor.getColumnIndex(Column_sex)));
                categoria.i=cursor.getString(cursor.getColumnIndex(Column_Interator));
            }
        } finally {
            cursor.close();
        }
        return categoria;
    }
}
