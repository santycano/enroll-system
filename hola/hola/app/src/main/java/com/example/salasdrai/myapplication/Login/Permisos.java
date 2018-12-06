package com.example.salasdrai.myapplication.Login;

public class Permisos {
    private boolean admin;
    private boolean trainer;

    private static final Permisos ourInstance = new Permisos();

    public static Permisos getInstance() {
        return ourInstance;
    }

    private Permisos() {
        admin=false;
        trainer=false;
    }

    public boolean isAdmin() {
        return admin;
    }

    protected void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isTrainer() {
        return trainer;
    }

    protected void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }
}
