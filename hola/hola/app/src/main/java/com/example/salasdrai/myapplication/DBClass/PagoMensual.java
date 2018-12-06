package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.salasdrai.myapplication.DB.DBHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PagoMensual extends DBHelper {
    private  String pagoM;
    private  String pagoR;
    private  Date date;
    private  String id;


    public PagoMensual(Context context, String pagoM, String pagoR, Date date, String id) {
        super(context);
        this.pagoM = pagoM;
        this.pagoR = pagoR;
        this.date = date;
        this.id = id;
    }

    @Override
    public boolean insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_pay,pagoM);
        contentValues.put(Column_st_id,id);
        contentValues.put(Column_payR,pagoR);
        contentValues.put(Column_payF,date.toString());

        db.insert(TABLE_NAME_pay_month, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "st_id" + " = ?";
        String[] whereArgs = {id};
        PagoMensual pagoMensual = null;
        Date date=null;
        Cursor cursor = db.query(TABLE_NAME_pay_month,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                Context context = null;
                try {
                    date=new  SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex(Column_payF)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pagoMensual= new PagoMensual( context,cursor.getString(cursor.getColumnIndex(Column_pay)),cursor.getString(cursor.getColumnIndex(Column_payR)),date,cursor.getString(cursor.getColumnIndex(Column_st_id)));
            }
        } finally {
            cursor.close();
        }
        return pagoMensual;
    }

        public void create(){
            SQLiteDatabase db = getReadableDatabase();
            onCreate1(db);
        }
    @Override
    public boolean updateContact(String id) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_pay,pagoM);
        contentValues.put(Column_st_id,id);
        contentValues.put(Column_payR,pagoR);
        contentValues.put(Column_payF,date.toString());

        db.update(TABLE_NAME_pay_month, contentValues, "st_id = ? ", new String[] { id } );
        db.close();
        return true;
    }

    public String getPagoM() {
        return pagoM;
    }

    public void setPagoM(String pagoM) {
        this.pagoM = pagoM;
    }

    public String getPagoR() {
        return pagoR;
    }

    public void setPagoR(String pagoR) {
        this.pagoR = pagoR;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
