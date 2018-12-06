package com.example.salasdrai.myapplication.Controlador;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.salasdrai.myapplication.DBClass.Estudiante;
import com.example.salasdrai.myapplication.DBClass.PagoMensual;
import com.example.salasdrai.myapplication.DBClass.Student_Asignament;
import com.example.salasdrai.myapplication.FabricacionPura.DataBuscada;
import com.example.salasdrai.myapplication.Forms.DetalleEstudiante;
import com.example.salasdrai.myapplication.Forms.FormMain;
import com.example.salasdrai.myapplication.Login.Permisos;
import com.example.salasdrai.myapplication.R;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class AdaptadorEstudiante extends BaseAdapter {
    private ArrayList<Estudiante> lstEstudiante;
    private Estudiante est;
    private DataBuscada data;
    private short me=0,re=0;
    private PagoMensual pagoMensual;
    private Context context;
    private AppCompatActivity activity;
    private ArrayList<PagoMensual> lstPago;
    private Student_Asignament student_asignament;
    int id= 0; //referencia a cada fila
    private static final int selected_picture=1;
    public AdaptadorEstudiante(AppCompatActivity activity, ArrayList<Estudiante> lstEstudiantes, ArrayList<PagoMensual> pagoMensual, Student_Asignament student_asignament,Context context) {
        this.lstEstudiante = lstEstudiantes;
        this.activity = activity;
        this.lstPago = pagoMensual;
        this.context = context;
        this.student_asignament = student_asignament;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lstEstudiante.size();
    }

    @Override
    public Estudiante getItem(int position) {  //Corregir
        est = lstEstudiante.get(position);
        pagoMensual = lstPago.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        est = lstEstudiante.get(position);
        pagoMensual = lstPago.get(position);
        return Long.parseLong(est.getId());
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.listview_row, null);
        }
        est = lstEstudiante.get(position);
        pagoMensual = lstPago.get(position);
        Button btnEditar = (Button) v.findViewById(R.id.editar1);
        Button btnEliminar = (Button) v.findViewById(R.id.elim1);
        TextView columna1 = (TextView) v.findViewById(R.id.nombre);
        //TextView columna2 = (TextView) v.findViewById(R.id.faltas);
        TextView columna3 = (TextView) v.findViewById(R.id.pago);


        //Referencia a la numero de el boton en la lista.
        btnEditar.setTag(position);
        btnEliminar.setTag(position);

        //Rellenamos los valores de cada columna de la fila
        columna1.setText(est.getNombre() + " " + est.getApellido());
        //columna2.setText(est.getApellido());
        columna3.setText((pagoMensual.getPagoM()));

        //Boton editar

        btnEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                student_asignament= (Student_Asignament) student_asignament.getRow(lstEstudiante.get(position).getId());
                data=DataBuscada.getInstance();
                data.setStudent_asignament(student_asignament);
                Intent intent = new Intent (v.getContext(), DetalleEstudiante.class);
                startActivityForResult(activity,intent,0,null);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                final Permisos permisos=Permisos.getInstance();
                final String[] select={"Matricula" ,"Mensualidad"};
                final String[] select1={"Efectivo" ,"Consignacion"};
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Seleccione que desea pagar");

                final AlertDialog.Builder builder1=new AlertDialog.Builder(v.getContext());
                builder1.setTitle("Seleccione como desea pagar");
                builder1.setItems(select1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (select1[0].equals(select1[which]) && (permisos.isAdmin() || permisos.isTrainer())){
                            if (me==1){
                                lstPago.get(0).setPagoR("Si");
                                lstPago.get(0).updateContact(lstPago.get(0).getId());
                            }
                            else{
                                lstPago.get(0).setPagoM("Si");
                            }
                        }
                        if (select1[1].equals(select1[which])){
                            Intent intent = new Intent (Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(activity,intent,selected_picture,null);
                        }
                    }
                });
                builder.setItems(select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (select[0].equals(select[which])){
                            me=1;
                        }
                        if (select[1].equals(select[which])){
                            re=1;
                        }
                        builder1.show();
                    }
                });
                builder.show();
            }
        });
        return v;
    }
}
