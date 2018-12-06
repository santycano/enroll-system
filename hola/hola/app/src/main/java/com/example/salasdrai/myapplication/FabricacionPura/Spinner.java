package com.example.salasdrai.myapplication.FabricacionPura;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DB.DBHelper;
import com.example.salasdrai.myapplication.DBClass.Age_Range;
import com.example.salasdrai.myapplication.DBClass.Date_id;
import com.example.salasdrai.myapplication.DBClass.Time_Id;
import com.example.salasdrai.myapplication.DBClass.Type_Id;
import com.example.salasdrai.myapplication.Forms.FormMain;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {

    public Spinner() {
    }

    public static ArrayAdapter<String> spinnerHorario(android.widget.Spinner spinnerSedes, android.widget.Spinner spinnerHorario, Time_Id time_id, Date_id date_id, View view) {
        ArrayList a = new ArrayList();
        ArrayAdapter<String> adapter2 = null;

        if (spinnerSedes.getSelectedItem().equals("Unidad Deportiva Tulio Ospina de Bello")) {
            for (int i = 0; i < time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).size(); i++) {
                a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(0) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(i));
            }
            adapter2 = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item, a);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
            time_id.setTime(time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(spinnerHorario.getSelectedItemPosition()));
            date_id.setDate(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(0));
        }
        if (spinnerSedes.getSelectedItem().equals("Barrio Rosalpi")) {

            a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(1) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(2));
            a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(2) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(2));
            adapter2 = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item, a);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
            time_id.setTime(time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(2));
            date_id.setDate(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(spinnerHorario.getSelectedItemPosition() + 1));

        }
        if (spinnerSedes.getSelectedItem().equals("Parque Goretti")) {

            a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(2) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(0));
            a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(2) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(1));
            adapter2 = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item, a);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
            time_id.setTime(time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(spinnerHorario.getSelectedItemPosition() + 1));
            date_id.setDate(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(2));
        }
        if (spinnerSedes.getSelectedItem().equals("Cabañitas IV Etapa")) {

            a.add(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(3) + " " + time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(1));
            adapter2 = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item, a);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
            time_id.setTime(time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id, DBHelper.Column_time).get(1));
            date_id.setDate(date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id, DBHelper.Column_date).get(3));
        }
        ((TextView) view).setTextColor(Color.BLACK);
        return  adapter2;
    }

    public static void spinnerPrecio( android.widget.Spinner spinnerCategoria, ArrayList type,TextView valorM) {

        type.get(spinnerCategoria.getSelectedItemPosition());
        if (type.get(spinnerCategoria.getSelectedItemPosition()).toString().equals("Iniciación"))
        {
            valorM.setText("$ 80.000");
        }
        if (type.get(spinnerCategoria.getSelectedItemPosition()).toString().equals("Desarrollo"))
        {
            valorM.setText("$ 65.000");
        }
        if (type.get(spinnerCategoria.getSelectedItemPosition()).toString().equals("Competitivo"))
        {
            valorM.setText("$ 60.000");
        }
    }

    public static void spinnercat(android.widget.Spinner spinnerSedes, Age_Range age_range,Type_Id type_id, ArrayList type,ArrayList age,ArrayList cat) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item,age_range.getAllCotacts(DBHelper.TABLE_NAME_locate,DBHelper.Column_locate));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSedes.setAdapter(adapter);

        for (Object i:age_range.getAllCotacts(DBHelper.TABLE_NAME_category_num,DBHelper.Column_age_range_id)) {

            age_range.getRow(i.toString());
            age.add(age_range.getRange());
        }
        for (Object i:type_id.getAllCotacts(DBHelper.TABLE_NAME_category_num,DBHelper.Column_type_id)) {

            type_id.getRow(i.toString());
            type.add(type_id.getType());
        }

        for (int i=0;i<age.size();i++){
            cat.add(age.get(i)+" "+type.get(i)+" "+age_range.getAllCotacts(DBHelper.TABLE_NAME_category_num,DBHelper.Column_sex).get(i));
        }

    }

    public static void categ(android.widget.Spinner spinnerSedes, android.widget.Spinner spinnerCategoria,View view,ArrayList cat) {
        ((TextView)view).setTextColor(Color.BLACK);
        ArrayList a = new ArrayList();

        if (spinnerSedes.getSelectedItem().equals("Unidad Deportiva Tulio Ospina de Bello") ) {
                a.add((String) cat.get(0));a.add((String) cat.get(1));a.add((String) cat.get(2));
        }
        else if (spinnerSedes.getSelectedItem().equals("Barrio Rosalpi")) {
                a.add((String) cat.get(4));a.add((String) cat.get(5));
        }
        else{
            a.add((String) cat.get(6));}

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(FormMain.context, android.R.layout.simple_spinner_item,a);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCategoria.setAdapter(adapter1);
    }

}