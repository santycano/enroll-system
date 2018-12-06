package com.example.salasdrai.myapplication.Forms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DBClass.Acudiente;
import com.example.salasdrai.myapplication.Controlador.InsertarDatos;
import com.example.salasdrai.myapplication.FabricacionPura.Varios;
import com.example.salasdrai.myapplication.R;


public class FormPadre extends AppCompatActivity {

    private static Context context;
    private EditText nombre,apellido,id,tel,EPS,email;
    private Button bSiguiente;
    private BottomNavigationView navigation;
    private InsertarDatos insertarDatos;
    private Acudiente acudiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicialize();

        bSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                acudiente=new Acudiente(FormPadre.context,nombre.getText().toString(),apellido.getText().toString(),id.getText().toString(),tel.getText().toString(),email.getText().toString());
                acudiente.insert();
                insertarDatos.setAcudiente(acudiente);
                insertarDatos.insertStd();
                Intent intent = new Intent (v.getContext(), FormMain.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    private void inicialize(){
        setContentView(R.layout.activity_form_padre);
        FormPadre.context = getApplicationContext();
        nombre=(EditText) findViewById(R.id.editTextNombre1);
        apellido=(EditText) findViewById(R.id.editTextApellido1);
        id=(EditText) findViewById(R.id.editTextId1);
        tel=(EditText) findViewById(R.id.editTextTel);
        email=(EditText) findViewById(R.id.editTextEmail);
        bSiguiente=(Button) findViewById(R.id.buttonSiguienteP);
        navigation = (BottomNavigationView) findViewById(R.id.navigation4);
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
        if (tel.getText().toString().isEmpty()){
            tel.setError(getString(R.string.error_field_required));
            focusView = tel;
        }
        if (TextUtils.isEmpty(email.getText())) {
            email.setError(getString(R.string.error_field_required));
            focusView = email;
        }
    }
}
