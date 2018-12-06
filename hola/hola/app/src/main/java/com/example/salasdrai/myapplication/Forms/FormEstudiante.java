package com.example.salasdrai.myapplication.Forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DBClass.Estudiante;
import com.example.salasdrai.myapplication.DBClass.PagoMensual;
import com.example.salasdrai.myapplication.Controlador.InsertarDatos;
import com.example.salasdrai.myapplication.FabricacionPura.Varios;
import com.example.salasdrai.myapplication.R;


public class FormEstudiante extends AppCompatActivity{

    private DatePicker datePicker;
    private Button bSiguiente,bok;
    private RadioButton rMas,rFem;
    private EditText editTextFecha;
    private LinearLayout principal,date;
    private int dia, mes, ano;
    private LinearLayout principal1;
    private static Context context;
    private BottomNavigationView navigation;
    private EditText nombre,apellido,id,cel,EPS,nacimiento;
    private InsertarDatos insertarDatos;
    private PagoMensual pagoMensual;
    private Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inicialize();

        bSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent (v.getContext(), FormEstudiante.class);
                startActivityForResult(intent, 0);
            }
        });

        editTextFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @SuppressLint("WrongConstant")
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editTextFecha.setText("");
                    principal.setVisibility(view.INVISIBLE);
                    principal1.setVisibility(view.INVISIBLE);
                    date.setVisibility(1);
                    datePicker.setVisibility(1);
                }
            }
        });

        bok.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dia=datePicker.getDayOfMonth();
                mes=datePicker.getMonth()+1;
                ano=datePicker.getYear();
                editTextFecha.setText(dia +" / "+mes+" / "+ano);
                principal.setVisibility(1);
                principal1.setVisibility(1);
                date.setVisibility(v.INVISIBLE);
                datePicker.setVisibility(v.INVISIBLE);
            }
        });

        bSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String sex=null;
                if (rFem.isSelected()){
                    sex=rFem.getText().toString();
                }
                else {
                    sex=rMas.getText().toString();
                }
                estudiante=new Estudiante(FormEstudiante.context,nombre.getText().toString(),apellido.getText().toString(),id.getText().toString(),cel.getText().toString(),EPS.getText().toString(),nacimiento.getText().toString(),sex);
                estudiante.insert();
                pagoMensual=new PagoMensual(context,"No","No",null,estudiante.getId());
                pagoMensual.insert();
                insertarDatos.setEstudiante(estudiante);
                insertarDatos.setPagoMensual(pagoMensual);
                Intent intent = new Intent (v.getContext(), FormPadre.class);
                startActivityForResult(intent, 0);
            }
        });

    }


    private void inicialize(){
        setContentView(R.layout.activity_form_estudiante);
        FormEstudiante.context = getApplicationContext();
        datePicker=(DatePicker) findViewById(R.id.datePicker);
        bok=(Button)findViewById(R.id.buttonOk);
        rMas=findViewById(R.id.rMas);
        rFem=findViewById(R.id.rFem);
        bSiguiente=(Button)findViewById(R.id.buttonSiguente);
        editTextFecha=(EditText) findViewById(R.id.editTextFecha);
        principal=(LinearLayout) findViewById(R.id.principal);
        principal1=(LinearLayout) findViewById(R.id.principal1);
        date=(LinearLayout) findViewById(R.id.date);
        nombre=(EditText) findViewById(R.id.editTextNombre);
        apellido=(EditText) findViewById(R.id.editTextApellido);
        id=(EditText) findViewById(R.id.editTextId);
        nacimiento=(EditText) findViewById(R.id.editTextFecha);
        cel=(EditText) findViewById(R.id.editTextCelular);
        EPS=(EditText) findViewById(R.id.editTextEPS);
        navigation = (BottomNavigationView) findViewById(R.id.navigation3);
        insertarDatos=InsertarDatos.getInstance();
        iniN(navigation);
    }
    private void iniN(BottomNavigationView navigation){
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
    private void verify(){
        View focusView = null;
        if (nombre.getText().toString().isEmpty()){
            nombre.setError(getString(R.string.error_field_required));
            focusView = nombre;
        }
        if (apellido.getText().toString().isEmpty()){
            apellido.setError(getString(R.string.error_field_required));
            focusView = apellido;
        }
        if (id.getText().toString().isEmpty()){
            id.setError(getString(R.string.error_field_required));
            focusView = id;
        }
        if (cel.getText().toString().isEmpty()){
            cel.setError(getString(R.string.error_field_required));
            focusView = cel;
        }
        if (EPS.getText().toString().isEmpty()) {
            EPS.setError(getString(R.string.error_field_required));
            focusView = EPS;
        }
        if (nacimiento.getText().toString().isEmpty()) {
            nacimiento.setError(getString(R.string.error_field_required));
            focusView = nacimiento;
        }
    }
}









