package com.example.salasdrai.myapplication.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DragonesDB.db";
    public static final String TABLE_NAME_Estudiante = "Estudiante";
    public static final String TABLE_NAME_Acudiente = "Acudiente";
    public static final String TABLE_NAME_category_num = "category_num";
    public static final String TABLE_NAME_age_range = "age_range";
    public static final String TABLE_NAME_type_id = "type_id";
    public static final String TABLE_NAME_time_id = "time_id";
    public static final String TABLE_NAME_date_id= "date_id";
    public static final String TABLE_NAME_trainer = "Trainer";
    public static final String TABLE_NAME_schedule_id = "schedule_id";
    public static final String TABLE_NAME_catU = "catU";
    public static final String TABLE_NAME_locate = "locate";
    public static final String TABLE_NAME_student_assignament = "student_assignament";
    public static final String TABLE_NAME_pay_month = "pay_month";
    public static final String Column_Nombre = "Nombre";
    public static final String Column_Apellido = "Apellido";
    public static final String Column_Id = "Id";
    public static final String Column_age_range = "range";
    public static final String Column_age_range_id = "age_range_id";
    public static final String Column_type_id = "type_id";
    public static final String Column_sex = "sex";
    public static final String Column_type = "type";
    public static final String Column_time = "time";
    public static final String Column_date = "date";
    public static final String Column_trainer_id = "trainer_id";
    public static final String Column_range_id = "age_range_id";
    public static final String Column_time_id = "time_id";
    public static final String Column_date_id = "date_id";
    public static final String Column_subU = "subU";
    public static final String Column_locate_id = "locate_id";
    public static final String Column_subU_id = "subU_id";
    public static final String Column_st_id = "st_id";
    public static final String Column_cat_id = "cat_id";
    public static final String Column_acd_id = "acd_id";
    public static final String Column_sch_id = "sch_id";
    public static final String Column_locate = "locate";
    public static final String Column_pay = "payM";
    public static final String Column_payR = "payR";
    public static final String Column_payF = "fechaP";
    public static final String Column_Interator = "i";
    public static final String Column_pay_id="pay_id";
    public static final String Column_gender="gender";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table "+ TABLE_NAME_Estudiante  + "(i integer not null primary key AUTOINCREMENT UNIQUE, Nombre text,Apellido text,Id text not null UNIQUE, Nacimiento text,Celular text,EPS text)");
        db.execSQL("create table "+ TABLE_NAME_Acudiente  + "(i integer not null primary key AUTOINCREMENT UNIQUE, Nombre text,Apellido text,Id text not null UNIQUE,Celular text,Email text)");
        db.execSQL("create table "+ TABLE_NAME_category_num + "(i integer not null primary key AUTOINCREMENT UNIQUE, age_range_id text,type_id text,sex text)");
        db.execSQL("create table "+ TABLE_NAME_type_id + "(i integer not null primary key AUTOINCREMENT UNIQUE, type text)");
        db.execSQL("create table "+ TABLE_NAME_time_id + "(i integer not null primary key AUTOINCREMENT UNIQUE, time text)");
        db.execSQL("create table "+ TABLE_NAME_date_id + "(i integer not null primary key AUTOINCREMENT UNIQUE, date text)");
        db.execSQL("create table "+ TABLE_NAME_trainer + "(i integer not null primary key AUTOINCREMENT UNIQUE, Nombre text,Apellido text,Id text not null UNIQUE)");
        db.execSQL("create table "+ TABLE_NAME_schedule_id + "(i integer not null primary key AUTOINCREMENT UNIQUE ,cat_id text,time_id text,date_id text,trainer_id text)");
        db.execSQL("create table "+ TABLE_NAME_catU + "(i integer not null primary key AUTOINCREMENT UNIQUE, subU text)");
        db.execSQL("create table "+ TABLE_NAME_student_assignament + "(i integer not null primary key AUTOINCREMENT UNIQUE, locate_id text,st_id text,acd_id text,sch_id text)");
        db.execSQL("create table "+ TABLE_NAME_locate + "(i integer not null primary key AUTOINCREMENT UNIQUE, locate text)");
        db.execSQL("create table "+ TABLE_NAME_age_range + "(i integer not null primary key AUTOINCREMENT UNIQUE, range text)");
    }
    public void onCreate1(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table "+ TABLE_NAME_pay_month + "(i integer not null primary key AUTOINCREMENT UNIQUE, st_id text,payM text,payR text,fechaP text)");
    }
    public void onUp(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("alter table "+ TABLE_NAME_Estudiante+" add column " +Column_gender +" text");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("alter table "+ TABLE_NAME_student_assignament+" add column " +Column_pay_id +" text");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_pay_month);
        onCreate1(db);
    }

    public SQLiteDatabase actualizar(Context context){
        SQLiteDatabase db = this.getReadableDatabase();
        return db;
    }
    public abstract boolean insert();

    public abstract Object getRow(String id);


    public int numberOfRows(String table_name){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, table_name);
        return numRows;
    }

    public abstract boolean updateContact(String id);

    public Boolean deleteContact (String id,String table_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "Id" + " = ?";
        String[] whereArgs = {id};
        db.delete(table_name,where,whereArgs);
        return true;
    }
    public Boolean deleteContact1 (String id,String table_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        db.delete(table_name,where,whereArgs);
        return true;
    }



    public ArrayList<String> getAllCotacts(String table_name, String column_name) {
        ArrayList<String> array_list = new ArrayList<String>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ table_name +"", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(column_name)));
            res.moveToNext();
        }
        db.close();
        return array_list;
    }
}