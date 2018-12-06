package com.example.salasdrai.myapplication.Forms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DB.DBHelper;
import com.example.salasdrai.myapplication.DBClass.Age_Range;
import com.example.salasdrai.myapplication.DBClass.Categoria;
import com.example.salasdrai.myapplication.DBClass.Date_id;
import com.example.salasdrai.myapplication.DBClass.Locate;
import com.example.salasdrai.myapplication.DBClass.Time_Id;
import com.example.salasdrai.myapplication.DBClass.Trainer;
import com.example.salasdrai.myapplication.DBClass.Type_Id;
import com.example.salasdrai.myapplication.Controlador.InsertarDatos;
import com.example.salasdrai.myapplication.FabricacionPura.Varios;
import com.example.salasdrai.myapplication.R;

import java.util.ArrayList;

import static com.example.salasdrai.myapplication.R.layout.activity_form_academia;

public class FormAcademia extends AppCompatActivity {
    private Spinner spinnerSedes, spinnerCategoria, spinnerHorario;
    private TextView valorM;
    private Button bSiguiente;
    private BottomNavigationView navigation;
    private static Context context;
    private Categoria categoria;
    private InsertarDatos insertarDatos;
    private Locate locate;
    private Date_id date_id;
    private Time_Id time_id;
    private Type_Id type_id;
    private Age_Range age_range;
    private ArrayList type;ArrayList age;ArrayList cat;
    private Trainer trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        inicialize();

        com.example.salasdrai.myapplication.FabricacionPura.Spinner.spinnercat(spinnerSedes,age_range,type_id,type,age,cat);

        spinnerSedes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                com.example.salasdrai.myapplication.FabricacionPura.Spinner.categ(spinnerSedes,spinnerCategoria,view,cat);
            }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }});


        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(Color.BLACK);
                ArrayAdapter<String> adapter1;
                adapter1=com.example.salasdrai.myapplication.FabricacionPura.Spinner.spinnerHorario(spinnerSedes,spinnerCategoria,time_id,date_id,view);
                spinnerHorario.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }});

        spinnerHorario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)view).setTextColor(Color.BLACK);
                com.example.salasdrai.myapplication.FabricacionPura.Spinner.spinnerPrecio(spinnerCategoria,type,valorM);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }});



        bSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                locate.setLocation(spinnerSedes.getSelectedItem().toString());
                locate.setI(Integer.toString(spinnerSedes.getSelectedItemPosition()));
                categoria= (Categoria) categoria.getRow(Integer.toString(spinnerCategoria.getSelectedItemPosition()));int j=0;
                for (Object i:date_id.getAllCotacts(DBHelper.TABLE_NAME_date_id,DBHelper.Column_date)) { if (i.toString().equals(date_id.getDate())){ date_id.setI(Integer.toString(j));break; }j++; }
                for (Object i:time_id.getAllCotacts(DBHelper.TABLE_NAME_time_id,DBHelper.Column_time)) {if (i.toString().equals(time_id.getTime())){time_id.setI(Integer.toString(j)); }j++; }
                insertarDatos.setCategoria(categoria);
                insertarDatos.setDate_id(date_id);
                insertarDatos.setLocate(locate);
                insertarDatos.setTime_id(time_id);
                insertarDatos.setTrainer(trainer);
                Intent intent = new Intent (v.getContext(), FormEstudiante.class);
                startActivityForResult(intent, 0);
            }
        });

    }


    private void inicialize(){
        setContentView(activity_form_academia);
        FormAcademia.context = getApplicationContext();
        bSiguiente=(Button) findViewById(R.id.bSiguiente);
        valorM = (TextView) findViewById(R.id.textValorMatricula);
        navigation = (BottomNavigationView) findViewById(R.id.navigation2);
        spinnerSedes=(Spinner)findViewById(R.id.spinnerSede);
        spinnerCategoria=(Spinner)findViewById(R.id.spinnerCategoria);
        spinnerHorario=(Spinner)findViewById(R.id.spinnerHorario);
        date_id=new Date_id(context,null);
        time_id=new Time_Id(context,null);
        type_id=new Type_Id(context,null);
        age_range=new Age_Range(context,null);
        type=new ArrayList() ;
        age=new ArrayList();
        cat=new ArrayList();
        locate=new Locate(context,null);
        insertarDatos=InsertarDatos.getInstance();
        categoria=new Categoria(context,null,null,null);
        trainer=new Trainer(context,null,null,null);
        iniN(navigation);
    }

    public void iniN(BottomNavigationView navigation){
        navigation.getMenu().getItem(0).setTitle("Inicio");
        navigation.getMenu().getItem(1).setTitle("Matricula");
        navigation.getMenu().getItem(2).setTitle("Pago");

        navigation.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent (context, FormMain.class);
                startActivity(intent);
                return true;
            }
        });
        navigation.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent (context, FormAcademia.class);
                startActivity(intent);
                return true;
            }
        });
        navigation.getMenu().getItem(2).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent (context, Pago.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(intent);
                return true;
            }
        });
    }

}