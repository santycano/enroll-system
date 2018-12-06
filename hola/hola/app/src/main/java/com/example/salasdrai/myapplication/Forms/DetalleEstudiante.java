package com.example.salasdrai.myapplication.Forms;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DBClass.Acudiente;
import com.example.salasdrai.myapplication.DBClass.Categoria;
import com.example.salasdrai.myapplication.DBClass.Date_id;
import com.example.salasdrai.myapplication.DBClass.Estudiante;
import com.example.salasdrai.myapplication.DBClass.Locate;
import com.example.salasdrai.myapplication.DBClass.PagoMensual;
import com.example.salasdrai.myapplication.DBClass.Schedule;
import com.example.salasdrai.myapplication.DBClass.Student_Asignament;
import com.example.salasdrai.myapplication.DBClass.Time_Id;
import com.example.salasdrai.myapplication.FabricacionPura.DataBuscada;
import com.example.salasdrai.myapplication.FabricacionPura.Varios;
import com.example.salasdrai.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DetalleEstudiante extends AppCompatActivity {


    private TextView categoria,sede,horario,genero,nacimiento,cel,tel,email,acudiente,eps,nombre,locacion,matriculado,pago,fechaPago,fechaInsc;
    private Button volver,eliminar;
    private BottomNavigationView navigation;
    private Estudiante estudiante;
    private Locate locate;
    private Acudiente acudiente1;
    private Time_Id time_id;
    private Date_id date_id;
    private DataBuscada data;
    private Categoria categoria1;
    private PagoMensual pagoMensual;
    private Schedule schedule;
    private Context context;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estudiante);
        context=getApplicationContext();
        navigation =  findViewById(R.id.navigation);
        iniN(navigation);
        categoria  =  findViewById(R.id.data_categoria);
        matriculado  =  findViewById(R.id.matriculado);
        fechaInsc  =  findViewById(R.id.fechadeInscripcion);
        fechaPago  =  findViewById(R.id.fechaPago);
        pago  =  findViewById(R.id.pago);
        locacion  =  findViewById(R.id.fecha_inscripcion);
        horario =  findViewById(R.id.data_horario);
        nombre =  findViewById(R.id.nombre_estudiante);
        genero =  findViewById(R.id.data_genero);
        nacimiento =  findViewById(R.id.data_edad);
        cel =  findViewById(R.id.data_celular);
        tel =  findViewById(R.id.data_tel_fijo);
        email =  findViewById(R.id.data_email);
        acudiente =  findViewById(R.id.data_acudiente);
        eps =  findViewById(R.id.data_faltas);
        volver =  findViewById(R.id.btnVolver);
        eliminar =  findViewById(R.id.buttonEliminar);
        locate=new Locate(context,null);
        estudiante=new Estudiante(context,null,null,null,null,null,null,null);
        acudiente1=new Acudiente(context,null,null,null,null,null);
        categoria1=new Categoria(context,null,null,null);
        pagoMensual=new PagoMensual(context,null,null,null,null);
        schedule=new Schedule(context,null,null,null,null);
        date_id=new Date_id(context,null);
        time_id=new Time_Id(context,null);
        data=DataBuscada.getInstance();

        estudiante= (Estudiante) estudiante.getRow(data.getStudent_asignament().getSt_id());
        pagoMensual= (PagoMensual) pagoMensual.getRow(data.getStudent_asignament().getSt_id());
        acudiente1= (Acudiente) acudiente1.getRow(data.getStudent_asignament().getAcd_id());
        schedule= (Schedule) schedule.getRow(data.getStudent_asignament().getSch_id());
        locate= (Locate) locate.getRow(data.getStudent_asignament().getLocate_id());
        categoria1= (Categoria) categoria1.getRow(schedule.getCat());
        time_id= (Time_Id) time_id.getRow(schedule.getTime_id());
        date_id= (Date_id) date_id.getRow(schedule.getTime_id());

        nombre.setText(estudiante.getNombre()+" "+estudiante.getApellido());
        categoria.setText(categoria1.getAgeRange()+" "+categoria1.getSex()+" "+categoria1.getType());
        horario.setText(time_id.getTime()+" "+date_id.getDate());
        genero.setText(estudiante.getGenero());
        nacimiento.setText(estudiante.getFechaNacimiento());
        cel.setText(estudiante.getCel());
        tel.setText(acudiente1.getCel());
        email.setText(acudiente1.getEmail());
        acudiente.setText(acudiente1.getNombre()+" "+acudiente1.getApellido());
        eps.setText(estudiante.getEPS());
        locacion.setText(locate.getLocation());
        pago.setText(pagoMensual.getPagoM());
        matriculado.setText(pagoMensual.getPagoR());
        fechaInsc.setText((CharSequence) pagoMensual.getDate());
        //LocalDate ldt=LocalDate.now();
        /*Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(ldt).toString().substring(0,2)+
                                                                        Integer.toString(Integer.parseInt(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(ldt).toString().substring(3,4))+1)+DateTimeFormatter.ofPattern("dd/MM/yyyy").format(ldt).toString().substring(5,9));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //fechaPago.setText((CharSequence) date);
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
