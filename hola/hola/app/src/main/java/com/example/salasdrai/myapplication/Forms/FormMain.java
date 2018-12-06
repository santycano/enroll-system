package com.example.salasdrai.myapplication.Forms;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.salasdrai.myapplication.DBClass.Age_Range;
import com.example.salasdrai.myapplication.Login.LoginActivity;
import com.example.salasdrai.myapplication.R;


public class FormMain extends AppCompatActivity {

    private Button bLogin;
    public static Context context;
    private BottomNavigationView navigation;
    private String year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();
        navigation = (BottomNavigationView) findViewById(R.id.navigation1);
        bLogin =  findViewById(R.id.buttonLog);
        iniN(navigation);


        bLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent (v.getContext(), LoginActivity.class);
                startActivityForResult(intent,0);
            }
        });
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

    