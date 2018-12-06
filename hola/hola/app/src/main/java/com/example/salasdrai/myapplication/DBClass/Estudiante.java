package com.example.salasdrai.myapplication.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.salasdrai.myapplication.DB.DBHelper;


/**
 * Created by josue.cano on 8/10/18.
 */

public class Estudiante extends DBHelper {
    private String nombre;
    private String apellido;
    private String id;
    private String cel;
    private String EPS;
    private String genero;
    private String fechaNacimiento;
    // constructors

    public Estudiante(Context context, String nombre, String apellido, String id, String cel, String EPS, String fechaNacimiento,String genero) {
        super(context);
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.cel = cel;
        this.EPS = EPS;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }



    @Override
    public boolean insert () {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        contentValues.put(Column_Nombre, nombre);
        contentValues.put(Column_Id, id);
        contentValues.put(Column_Apellido, apellido);
        contentValues.put("Nacimiento", fechaNacimiento);
        contentValues.put("Celular", cel);
        contentValues.put("EPS", EPS);
        db.insert(TABLE_NAME_Estudiante, null, contentValues);
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
        contentValues.put("Nacimiento", fechaNacimiento);
        contentValues.put("Celular", cel);
        contentValues.put("EPS", EPS);
        contentValues.put(Column_gender, genero);
        db.update(TABLE_NAME_Estudiante, contentValues, "Id = ? ", new String[] { id } );
        return true;
    }

    @Override
    public Object getRow(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String where = "Id" + " = ?";
        String[] whereArgs = {id};
        Estudiante estudiante = null;
        Cursor cursor = db.query(TABLE_NAME_Estudiante,null,where,whereArgs,null,null,null);
        try {
            if (cursor.moveToFirst()) {
                // read column data
                View.OnClickListener onClickListener = null;
                Context context = null;
                estudiante= new Estudiante( context,cursor.getString(cursor.getColumnIndex(Column_Nombre)),cursor.getString(cursor.getColumnIndex(Column_Apellido)),cursor.getString(cursor.getColumnIndex(Column_Id)),
                                            cursor.getString(cursor.getColumnIndex("Celular")),cursor.getString(cursor.getColumnIndex("EPS")),cursor.getString(cursor.getColumnIndex("Nacimiento")),cursor.getString(cursor.getColumnIndex(Column_gender)));
            }
        } finally {
            cursor.close();
        }
        return estudiante;
    }

    // properties

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

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
