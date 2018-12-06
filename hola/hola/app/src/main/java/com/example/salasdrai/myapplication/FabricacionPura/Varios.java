package com.example.salasdrai.myapplication.FabricacionPura;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.salasdrai.myapplication.DBClass.Locate;
import com.example.salasdrai.myapplication.Forms.FormAcademia;
import com.example.salasdrai.myapplication.Forms.FormMain;
import com.example.salasdrai.myapplication.Forms.Pago;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class Varios extends AppCompatActivity {
    private Varios() { }
    private static final Varios ourInstance = new Varios();
    public static Varios getInstance() {
        return ourInstance;
    }

    private void showMessage(String title, String message, Context context) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
