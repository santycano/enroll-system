package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Schedule extends DBHelper {
    private String time_id;
    private String cat;
    private String date_id;
    private String trainer_id;
    private String i;
    public Schedule(Context context, String time_id, String cat, String date_id, String trainer_id) {
        super(context);
        this.time_id = time_id;
        this.cat = cat;
        this.date_id = date_id;
        this.trainer_id = trainer_id;
        this.i=null;
    }

    public String getTime_id() {
        return time_id;
    }

    public void setTime_id(String time_id) {
        this.time_id = time_id;
    }

    public String getType_id() {
        return cat;
    }

    public void setType_id(String cat) {
        this.cat = cat;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    public String getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(String trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
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
        contentValues.put(Column_time_id, time_id);
        contentValues.put(Column_cat_id, cat);
        contentValues.put(Column_date_id, date_id);
        contentValues.put(Column_trainer_id,trainer_id);

        db.insert(TABLE_NAME_schedule_id, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_time_id, time_id);
        contentValues.put(Column_cat_id, cat);
        contentValues.put(Column_date_id, date_id);
        contentValues.put(Column_trainer_id,trainer_id);
        db.update(TABLE_NAME_schedule_id, contentValues, "i = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "i" + " = ?";
        String[] whereArgs = {id};
        Schedule schedule = null;
        Cursor cursor = db.query(TABLE_NAME_schedule_id,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                Context context = null;
                String[] a=new String[5];
                a[0]=cursor.getString(cursor.getColumnIndex(Column_time_id));
                a[1]=cursor.getString(cursor.getColumnIndex(Column_cat_id));
                a[2]=cursor.getString(cursor.getColumnIndex(Column_date_id));
                a[3]=cursor.getString(cursor.getColumnIndex(Column_trainer_id));
                schedule=new Schedule(context,a[0],a[1],a[2],a[3]);
                schedule.setI(id);
            }
        } finally {
            cursor.close();
        }
        db.close();
        return schedule;
    }
}
