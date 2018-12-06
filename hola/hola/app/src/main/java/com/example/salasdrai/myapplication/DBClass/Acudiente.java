package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;

public class Acudiente extends DBHelper {
    private String nombre;
    private String apellido;
    private String id;
    private String cel;
    private String email;


    public Acudiente(Context context, String nombre, String apellido, String id, String cel, String email) {
        super(context);
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.cel = cel;
        this.email = email;
    }
    @Override
    public boolean insert () {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_Nombre, nombre);
        contentValues.put(Column_Id, id);
        contentValues.put(Column_Apellido, apellido);
        contentValues.put("Celular", cel);
        contentValues.put("Email", email);
        db.insert(TABLE_NAME_Acudiente, null, contentValues);
        db.close();
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "Id" + " = ?";
        String[] whereArgs = {id};
        Acudiente acudiente = null;
        Cursor cursor = db.query(TABLE_NAME_Acudiente,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                acudiente= new Acudiente( context,cursor.getString(cursor.getColumnIndex(Column_Nombre)),cursor.getString(cursor.getColumnIndex(Column_Apellido)),cursor.getString(cursor.getColumnIndex(Column_Id)),
                                        cursor.getString(cursor.getColumnIndex("Celular")),cursor.getString(cursor.getColumnIndex("Email")));
            }
        } finally {
            cursor.close();
        }
        return acudiente;
    }

    @Override
    public boolean updateContact(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_Nombre, nombre);
        contentValues.put(Column_Id, id);
        contentValues.put(Column_Apellido, apellido);
        contentValues.put("Celular", cel);
        contentValues.put("Email", email);
        db.update(TABLE_NAME_Acudiente, contentValues, "id = ? ", new String[] { id } );
        return true;
    }


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

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
