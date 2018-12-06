package com.example.salasdrai.myapplication.Controlador;

import android.content.Context;
import android.widget.EditText;

import com.example.salasdrai.myapplication.DBClass.Acudiente;
import com.example.salasdrai.myapplication.DBClass.Categoria;
import com.example.salasdrai.myapplication.DBClass.Date_id;
import com.example.salasdrai.myapplication.DBClass.Estudiante;
import com.example.salasdrai.myapplication.DBClass.Locate;
import com.example.salasdrai.myapplication.DBClass.PagoMensual;
import com.example.salasdrai.myapplication.DBClass.Schedule;
import com.example.salasdrai.myapplication.DBClass.Student_Asignament;
import com.example.salasdrai.myapplication.DBClass.Time_Id;
import com.example.salasdrai.myapplication.DBClass.Trainer;
import com.example.salasdrai.myapplication.FabricacionPura.Correo;

public class InsertarDatos {
    private Estudiante estudiante;
    private PagoMensual pagoMensual;
    private Trainer trainer;
    private Time_Id time_id;
    private Categoria categoria;
    private Acudiente acudiente;
    private Correo correo;
    private EditText email;
    public static Context context;
    private Schedule schedule;
    private Locate locate;
    private Date_id date_id;
    private static final InsertarDatos ourInstance = new InsertarDatos(context);

    public InsertarDatos(Time_Id time_id, Categoria categoria, Date_id date_id,Locate locate) {
        this.time_id = time_id;
        this.categoria = categoria;
        this.acudiente = acudiente;
        this.date_id = date_id;
        this.locate=locate;
    }



    public void insertStd(){
        Student_Asignament student_asignament=new Student_Asignament(context,locate.getI(),estudiante.getId(),acudiente.getId(),schedule.getI(),pagoMensual.getId());
        student_asignament.insert();
        correo=new Correo("santycano4@gmail.com","mariaelenap");
        //correo.send(email);
    }






    public static InsertarDatos getInstance() {
        return ourInstance;
    }

    private InsertarDatos(Context context) {
        this.context=context;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Time_Id getTime_id() {
        return time_id;
    }

    public void setTime_id(Time_Id time_id) {
        this.time_id = time_id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Locate getLocate() {
        return locate;
    }

    public void setLocate(Locate locate) {
        this.locate = locate;
    }

    public Date_id getDate_id() {
        return date_id;
    }

    public void setDate_id(Date_id date_id) {
        this.date_id = date_id;
    }

    public PagoMensual getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(PagoMensual pagoMensual) {
        this.pagoMensual = pagoMensual;
    }



}
