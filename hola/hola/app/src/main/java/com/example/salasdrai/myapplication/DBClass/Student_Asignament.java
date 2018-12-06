package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Student_Asignament extends DBHelper {
    private String locate_id;
    private String st_id;
    private String acd_id;
    private String sch_id;
    private String pay_id;

    public Student_Asignament(Context context, String locate_id, String st_id, String acd_id, String sch_id, String pay_id) {
        super(context);
        this.locate_id = locate_id;
        this.st_id = st_id;
        this.acd_id = acd_id;
        this.sch_id = sch_id;
        this.pay_id = pay_id;
    }

    public String getLocate_id() {
        return locate_id;
    }

    public void setLocate_id(String locate_id) {
        this.locate_id = locate_id;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getAcd_id() {
        return acd_id;
    }

    public void setAcd_id(String acd_id) {
        this.acd_id = acd_id;
    }

    public String getSch_id() {
        return sch_id;
    }

    public void setSch_id(String sch_id) {
        this.sch_id = sch_id;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    @Override
    public boolean insert () {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_locate_id, locate_id);
        contentValues.put(Column_st_id, st_id);
        contentValues.put(Column_acd_id,acd_id);
        contentValues.put(Column_sch_id,sch_id);
        contentValues.put(Column_pay_id,pay_id);

        db.insert(TABLE_NAME_student_assignament, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_locate_id, locate_id);
        contentValues.put(Column_st_id, st_id);
        contentValues.put(Column_acd_id,acd_id);
        contentValues.put(Column_sch_id,sch_id);
        contentValues.put(Column_pay_id,pay_id);
        db.update(TABLE_NAME_student_assignament, contentValues, "i = ? ", new String[] { id } );
        return true;
    }
    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "st_id" + " = ?";
        String[] whereArgs = {id};
        Student_Asignament student_asignament = null;
        Cursor cursor = db.query(TABLE_NAME_student_assignament,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                Context context = null;
                student_asignament= new Student_Asignament( context,cursor.getString(cursor.getColumnIndex(Column_locate_id)),cursor.getString(cursor.getColumnIndex(Column_st_id)),cursor.getString(cursor.getColumnIndex(Column_acd_id)),cursor.getString(cursor.getColumnIndex(Column_sch_id)),cursor.getString(cursor.getColumnIndex(Column_pay_id)));
            }
        } finally {
            cursor.close();
        }
        db.close();
        return student_asignament;
    }
}
