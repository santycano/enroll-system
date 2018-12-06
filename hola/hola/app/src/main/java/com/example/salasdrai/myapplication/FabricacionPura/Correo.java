package com.example.salasdrai.myapplication.FabricacionPura;

import android.os.StrictMode;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {
    private Session session;
    private String correo;
    private String contraseña;

    public Correo(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void send(String aEmail){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties=new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try{
            session=javax.mail.Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(correo,contraseña);
                }
            });

            if(session!=null){
                Message message= new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("Confirmacion de registro");
                Address b = new InternetAddress(aEmail);
                message.setRecipient(Message.RecipientType.TO, b);
                message.setContent("Usted ha sido registrado satisfactoriamente","text/html; charset=utf-8");
                Transport.send(message);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void send1(String aEmail,Object o,String type){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties=new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try{
            session=javax.mail.Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(correo,contraseña);
                }
            });

            if(session!=null){
                Message message= new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("Confirmacion de registro");
                Address b = new InternetAddress(aEmail);
                message.setRecipient(Message.RecipientType.TO, b);
                message.setContent(o,type);
                //message.setContent("Usted ha sido registrado satisfactoriamente","text/html; charset=utf-8");
                Transport.send(message);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
