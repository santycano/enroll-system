package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Trainer extends DBHelper {
    private String nombre;
    private String apellido;
    private String id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trainer( Context context,String nombre, String apellido, String id) {
        super(context);

        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    @Override
    public boolean insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put(Column_Nombre, nombre);
        contentValues.put(Column_Id, id);
        contentValues.put(Column_Apellido, apellido);

        db.insert(TABLE_NAME_trainer, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_Nombre, nombre);
        contentValues.put(Column_Id, id);
        contentValues.put(Column_Apellido, apellido);
        db.update(TABLE_NAME_trainer, contentValues, "Id = ? ", new String[] { id } );
        return true;
    }
    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "Id" + " = ?";
        String[] whereArgs = {id};
        Trainer trainer = null;
        Cursor cursor = db.query(TABLE_NAME_trainer,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                trainer= new Trainer( context,cursor.getString(cursor.getColumnIndex(Column_Nombre)),cursor.getString(cursor.getColumnIndex(Column_Apellido)),cursor.getString(cursor.getColumnIndex(Column_Id)));
            }
        } finally {
            cursor.close();
        }
        return trainer;
    }
}
