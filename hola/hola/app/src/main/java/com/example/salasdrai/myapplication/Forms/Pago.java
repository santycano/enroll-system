package com.example.salasdrai.myapplication.Forms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salasdrai.myapplication.DB.DBHelper;
import com.example.salasdrai.myapplication.Controlador.AdaptadorEstudiante;
import com.example.salasdrai.myapplication.DBClass.Estudiante;
import com.example.salasdrai.myapplication.DBClass.PagoMensual;
import com.example.salasdrai.myapplication.DBClass.Student_Asignament;
import com.example.salasdrai.myapplication.FabricacionPura.Correo;
import com.example.salasdrai.myapplication.FabricacionPura.Varios;
import com.example.salasdrai.myapplication.R;

import java.net.URI;
import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


public class Pago extends AppCompatActivity {

    private Uri URI;
    public static Context context;
    //private AdaptadorEstudiante adaptadorEst;
    private ArrayList<Estudiante> lstEstudiante;
    private ArrayList<PagoMensual> lstPago;
    private ArrayList<PagoMensual> buscadoP;
    private ArrayList<Estudiante> buscado;
    private Estudiante est;
    private PagoMensual pagoMensual;
    private AdaptadorEstudiante adaptadorEst;
    private ListView listview;
    private EditText editTextBuscar;
    private Button buttonBuscar,buttonPagar;
    private  BottomNavigationView navigation;
    private Estudiante estudiante;
    private ArrayList e;
    private Correo correo;
    int l;
    private Varios varios;
    private ArrayList<String> m;
    private ArrayList<String> r;
    private Student_Asignament student_asignament;
    private static final int selected_picture=1;
    private Drawable d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ini();

        e=student_asignament.getAllCotacts(DBHelper.TABLE_NAME_student_assignament,DBHelper.Column_st_id);
        m=student_asignament.getAllCotacts(DBHelper.TABLE_NAME_pay_month,DBHelper.Column_pay);
        r=student_asignament.getAllCotacts(DBHelper.TABLE_NAME_pay_month,DBHelper.Column_payF);
        for (int i=0;i<e.size();i++){
            lstEstudiante.add((Estudiante) estudiante.getRow(String.valueOf(e.get(i))));
            lstPago.add((PagoMensual) pagoMensual.getRow(String.valueOf(e.get(i))));
        }

        buttonBuscar.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final  Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"santycano4@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Pago Factura");//poner nombre del nene
                if (URI != null){
                    emailIntent.putExtra(Intent.EXTRA_STREAM,URI);
                }
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Factura");
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(Intent.createChooser(emailIntent,"sending email"));


              /*  short j=0;
                for (Estudiante es:lstEstudiante) {
                    if (es.getId().equals(editTextBuscar.getText().toString()) && es!=null){
                        buscado.add(es);buscadoP.add(lstPago.get(j));break;
                    }
                }
               student_asignament= (Student_Asignament) student_asignament.getRow(buscado.get(0).getId());
               adaptadorEst = new AdaptadorEstudiante(Pago.this, buscado, buscadoP,student_asignament,context);
               listview.setAdapter(adaptadorEst);*/
            }
        });

        buttonPagar.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final String[] select={"Matricula" ,"Mensualidad"};
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Seleccione que desea pagar");
                builder.setItems(select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (select[0].equals(select[which])){
                            openGallery();

                        }
                    }
                });
                builder.show();
            }

        });

        adaptadorEst = new AdaptadorEstudiante(Pago.this, lstEstudiante, lstPago,student_asignament,context);
        listview.setAdapter(adaptadorEst);

    }

    private void openGallery(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data",true);
        startActivityForResult(Intent.createChooser(intent,"choose image"),101);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case selected_picture:
                if (resultCode==RESULT_OK){
                    Uri uri=data.getData();
                    String[] projection={MediaStore.Images.Media.DATA};
                    Cursor cursor=getContentResolver().query(uri,projection,null,null,null);
                    cursor.moveToFirst();

                    int colomnIndex=cursor.getColumnIndex(projection[0]);
                    String filepath=cursor.getString(colomnIndex);
                    Log.e("Attachment Path: ", filepath);
                    URI=Uri.parse("file://"+filepath);
                    cursor.close();

                    Bitmap yourSelection=BitmapFactory.decodeFile(filepath);
                    d=new BitmapDrawable((yourSelection));
                    //correo.send("josue.cano@udea.edu.co");
                    //correo.send1("josue.cano@udea.edu.co",d,"image/*");

                }
        }
    }

    private  void ini(){
        setContentView(R.layout.activity_pago);
        listview = (ListView) findViewById(R.id.listview1);
        editTextBuscar=findViewById(R.id.editTextBuscar);
        buttonBuscar=findViewById(R.id.btnAddEstudiante);
        buttonPagar=findViewById(R.id.buttonPagar);
        Pago.context=getApplicationContext();
        navigation = (BottomNavigationView) findViewById(R.id.navigation5);
        estudiante = new Estudiante(context,null,null,null,null,null,null,null);
        lstEstudiante=new ArrayList<>();
        lstPago=new ArrayList<>();
        e=new ArrayList();
        buscado=new ArrayList<>();
        pagoMensual=new PagoMensual(context,null,null,null,null);
        est = new Estudiante(context,null,null,null,null,null,null,null);
        varios =Varios.getInstance();
        buscadoP=new ArrayList();
        student_asignament=new Student_Asignament(context,null,null,null,null,null);
        iniN(navigation);
        correo=new Correo("santycano4@gmail.com","mariaelenap");
    }

    public Drawable getD() {
        return d;
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
