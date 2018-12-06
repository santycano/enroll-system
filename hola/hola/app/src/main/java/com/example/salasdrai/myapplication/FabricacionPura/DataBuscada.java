package com.example.salasdrai.myapplication.FabricacionPura;

import com.example.salasdrai.myapplication.DBClass.Locate;
import com.example.salasdrai.myapplication.DBClass.Student_Asignament;

public class DataBuscada {
    private Student_Asignament student_asignament;
    private static final DataBuscada ourInstance = new DataBuscada();
    public static DataBuscada getInstance() {
        return ourInstance;
    }
    private DataBuscada() {
        this.student_asignament = null;
    }

    public Student_Asignament getStudent_asignament() {
        return student_asignament;
    }

    public void setStudent_asignament(Student_Asignament student_asignament) {
        this.student_asignament = student_asignament;
    }
}
