package com.example.salasdrai.myapplication.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBInizialice extends DBHelper {
    public DBInizialice(Context context) {
        super(context);
    }

    public void iniEstudiante(){
        String begin="BEGIN TRANSACTION";
        String [] sql=new String[80];
        sql[0] ="INSERT INTO Estudiante VALUES (1,'DUVÁN','AGUDELO GIRALDO ','1033486245','2/22/2004','3174641342','SISBEN')" ;
        sql[1] = "INSERT INTO Estudiante VALUES (2,'DAVID','MUÑOZ VALLEJO','1133089736','9/13/2001','3208000778','SURA')";
        sql[2] = "INSERT INTO Estudiante VALUES (3,'JUAN ESTEBAN','HOLGUIN GALEANO','1000646393','8/8/2000','3135897410','SURA')";
        sql[3] = "INSERT INTO Estudiante VALUES (4,'CRISTIAN SANTIAGO','ARANGO OSORIO','1001250382','8/3/2001','3127788677','COOMEVA')";
        sql[4] = "INSERT INTO Estudiante VALUES (5,'CARLOS ANDRES','GARAY PADILLA','1001533068','8/14/2002','3146952258','SISBÉN')";
        sql[5] = "INSERT INTO Estudiante VALUES (6,'EVONHYYERIS ','CUESTA LOPEZ','1033182737','8/21/2007','3234592783','SISBÉN')";
        sql[6] = "INSERT INTO Estudiante VALUES (7,'ANA ISABEL','ALZATE ','1020424208','8/2/2007','3147739842',NULL)";
        sql[7] = "INSERT INTO Estudiante VALUES (8,'MARIA SALOME','HENAO SANCHEZ','1038868015','4/26/2006','3008786245','SURA')";
        sql[8] = "INSERT INTO Estudiante VALUES (9,'EMANUEL','TABARES ARISTIZABAL ','1018240841','4/1/2008','3113710403','COOMEVA')";
        sql[9] = "INSERT INTO Estudiante VALUES (10,'ANA SOFIA','CORREA SALAZAR ','1033489226','9/27/2006','3146830994','SURA')";
        sql[10] = "INSERT INTO Estudiante VALUES (11,'SOFIA','MONTOYA MEJIA ','1017929704','4/29/2007','3135311112','COOMEVA')";
        sql[11] = "INSERT INTO Estudiante VALUES (12,'SEBASTIAN','PARRA OSSA','1021805200','2/4/2006','3146665473','SALUD TOTAL')";
        sql[12] = "INSERT INTO Estudiante VALUES (13,'MARIANA','ESPINAL MARIN ','1000756961','10/10/2003','3108338413','NUEVA')";
        sql[13] = "INSERT INTO Estudiante VALUES (14,'MARLON ANDRES','RODRIGUEZ VELASQUEZ','1001478866','2/28/2002','3155834260','SURA')";
        sql[14] = "INSERT INTO Estudiante VALUES (15,'OMAR','ACEVEDO LONDOÑO ','1001421031','11/21/2002','3206351061','RED VITAL')";
        sql[15] = "INSERT INTO Estudiante VALUES (16,'MIGUEL ANGEL','LONDOÑO GRISALES ','1023677602','10/22/2005','3117021192','MEDIMAS')";
        sql[16] = "INSERT INTO Estudiante VALUES (17,'SAMUEL','VANEGAS HERRERA ','1001250731','10/19/2004','3017158585','SURA')";
        sql[17] = "INSERT INTO Estudiante VALUES (18,'DANIEL','CARDENAS MACHADO ','1000410161','8/17/2003','3113103982','SURA')";
        sql[18] = "INSERT INTO Estudiante VALUES (19,'IBONNY','GALEANO BARRERA','1000135461','9/2/2000','3107952164','SISBÉN')";
        sql[19] = "INSERT INTO Estudiante VALUES (20,'JOHAN','SEPULVEDA ARISTIZABAL ','1125638127','6/8/2004','3116357923','SALUD TOTAL')";
        sql[20] = "INSERT INTO Estudiante VALUES (21,'JOSE DAVID','ZAPATA ','1000192763','3/12/2003','3024224047','SISBÉN')";
        sql[21] = "INSERT INTO Estudiante VALUES (22,'BRANDON','PARRA MARIN','1020405192','4/8/2005','3233688237','MEDIMAS')";
        sql[22] = "INSERT INTO Estudiante VALUES (23,'JUAN JOSE','GARCIA ZULUAGA ','1000873230','10/2/2002','3135168745','MEDIMAS')";
        sql[23] = "INSERT INTO Estudiante VALUES (24,'MIGUEL ','ACEVEDO LONDOÑO ','1018257202','5/25/2007','3007511226','RED VITAL')";
        sql[24] = "INSERT INTO Estudiante VALUES (25,'SIMON','MARTINEZ','1022148596','7/2/2008','3007511226','SURA')";
        sql[25] = "INSERT INTO Estudiante VALUES (26,'EMANUEL','GIRALDO OSPINA','1001250527','5/7/2003','3147220122','SURA')";
        sql[26] = "INSERT INTO Estudiante VALUES (27,'SIMONE','PEREZ CASAS','1022142022','2/5/2004','3227593084',NULL)";
        sql[27] = "INSERT INTO Estudiante VALUES (28,'DANIELA','ORTIZ LLAMAS','1022143554','1/6/2005','3113055233','SURA')";
        sql[28] = "INSERT INTO Estudiante VALUES (29,'TOMAS','ALZATE ','1001456832','11/12/2002',NULL,'POL')";
        sql[29] = "INSERT INTO Estudiante VALUES (30,'VALENTINA','OSORIO','1020109322','1/17/2006','3156601460','SISBÉN')";
        sql[30] = "INSERT INTO Estudiante VALUES (31,'SEBASTIAN','RESTREPO BUILES','1000417399','6/29/2002','3058100115','MEDIMAS')";
        sql[31] = "INSERT INTO Estudiante VALUES (32,'ANGELLY','ARIAS CORREA','1017928042','8/25/2006','3117212042','SURA')";
        sql[32] = "INSERT INTO Estudiante VALUES (33,'SERGIO','PEREZ JARAMILLO ','1000188232','1/13/2000','3004288146','SALUD TOTAL')";
        sql[33] = "INSERT INTO Estudiante VALUES (34,'STIVEN','ARAQUE COLORADO','1000654809','4/7/2003','3014190454','SISBÉN')";
        sql[34] = "INSERT INTO Estudiante VALUES (35,'SEBASTIAN','ZULUAGA GOMEZ','1001139658','7/6/2001','3182921712','SURA')";
        sql[35] = "INSERT INTO Estudiante VALUES (36,'SOFIA','NIETO PAMPLONA','1033490147','6/11/2007','3104879970','MEDIMAS')";
        sql[36] = "INSERT INTO Estudiante VALUES (37,'JUAN PABLO','ARIAS ','1000089592','8/3/2001','3218419683','SURA')";
        sql[37] = "INSERT INTO Estudiante VALUES (38,'CAMILA ANDREA','TORRES','1025645069','7/11/2005','3053756129','SURA')";
        sql[38] = "INSERT INTO Estudiante VALUES (39,'FELIPE','TOBON AMAYA','1000295282','1/20/2001','3126482364','SURA')";
        sql[39] = "INSERT INTO Estudiante VALUES (40,'SOFIA','POSADA BUITRAGO','1017932854','9/13/2008','3185107400','SURA')";
        sql[40] = "INSERT INTO Estudiante VALUES (41,'ISABELLA','ALZATE RESTREPO','1018226848','11/22/2004','3022071998','SURA')";
        sql[41] = "INSERT INTO Estudiante VALUES (42,'JUAN DAVID','GARZON ARISTIZABAL','1020444363',NULL,'3158107413','SURA')";
        sql[42] = "INSERT INTO Estudiante VALUES (43,'KEVIN','IZQUIERDO URREGO','1033428347','1/5/2003','3014707641','SURA')";
        sql[43] = "INSERT INTO Estudiante VALUES (44,'JUAN JOSE','GALLEGO ','1017928346','10/6/2006','3007941998','SURA')";
        sql[44] = "INSERT INTO Estudiante VALUES (45,'LORENZO','PERDOMO RIOS','1025887694','4/20/2006','3007761766','CRUZ BLANCA')";
        sql[45] = "INSERT INTO Estudiante VALUES (46,'SAMUEL','CORREA ','1018238939','9/24/2007','3217820354','MEDIMAS')";
        sql[46] = "INSERT INTO Estudiante VALUES (47,'MARIA JOSE','MOLINA LOPEZ','1025888623','6/30/2006','3148468477','SURA')";
        sql[47] = "INSERT INTO Estudiante VALUES (48,'CAROLINA',' ARANGO TOBON','1017923759',NULL,'3117167257','SURA')";
        sql[48] = "INSERT INTO Estudiante VALUES (49,'JUAN JOSE','ARANGO TOBON','1000413030',NULL,'3117167257','SURA')";
        sql[49] = "INSERT INTO Estudiante VALUES (50,'ASHLEY','SALAZAR ECHAVARRIA','1033488473','2/26/2006','3218648890','COOMEVA')";
        sql[50] = "INSERT INTO Estudiante VALUES (51,'STEFANIA','MEDINA BARRIENTOS','1020107345','6/19/2005','3136787867','SURA')";
        sql[51] = "INSERT INTO Estudiante VALUES (52,'VICTOR JULIO','MEDINA BARRIENTOS','1020110345',NULL,'3136787867','SURA')";
        sql[52] = "INSERT INTO Estudiante VALUES (53,'CAROLINA','VELASQUEZ URREGO','1000662247','4/11/2003','3206653615','SURA')";
        sql[53] = "INSERT INTO Estudiante VALUES (54,'JUAN FELIPE','MORENO PEREZ','1038336537','8/6/2012','3183472649','NUEVA')";
        sql[54] = "INSERT INTO Estudiante VALUES (55,'ANNY','ECHAVARRIA HIDALGO','1000662036','8/2/2002','3136764208','SURA')";
        sql[55] = "INSERT INTO Estudiante VALUES (56,'CESAR DAVID','ALVAREZ JARAMILLO','1028141572','9/13/2010','3147011533','COOMEVA')";
        sql[56] = "INSERT INTO Estudiante VALUES (57,'THOMAS','GOMEZ GOMEZ','10236334874','6/2/2008','3117589320','COOMEVA')";
        sql[57] = "INSERT INTO Estudiante VALUES (58,'ASHLEY MANUELA','POSADA LOPERA','1001389780','10/31/2001','3216122701','SANIDAD MILITAR')";
        sql[58] = "INSERT INTO Estudiante VALUES (59,'SARA VALENTINA','ISAZA CATAÑO','1000661402','2/14/2001','3027319319','SANITAS')";
        sql[59] = "INSERT INTO Estudiante VALUES (60,'SEBASTIAN','CADAVID TABORDA','1022146997','5/13/2007','3017415699','COOMEVA')";
        sql[60] = "INSERT INTO Estudiante VALUES (61,'THOMAS','MEJIA LOPERA','1018243748','12/10/2008','3008865043','SURA')";
        sql[61] = "INSERT INTO Estudiante VALUES (62,'DAVID STEVEN','TORRES JARAMILLO','1022149097','10/11/2008','3147850425','SURA')";
        sql[62] = "INSERT INTO Estudiante VALUES (63,'MARIANA','GOMEZ ISAZA','1022147006','5/13/2007','3044744423','MEDIMAS')";
        sql[63] = "INSERT INTO Estudiante VALUES (64,'MIGUEL ANGEL','RIOS TORO','1017933760','2/4/2009','3004882814','SURA')";
        sql[64] = "INSERT INTO Estudiante VALUES (65,'ALEJANDRO','CALDERON CARRASQUILLA','1022148914',NULL,'3006466384','SURA')";
        sql[65] = "INSERT INTO Estudiante VALUES (66,'YINETH VALENTINA','IBAÑEZ SEPULVEDA','1000728121','11/8/2002','3146014976','SALUD TOTAL')";
        sql[66] = "INSERT INTO Estudiante VALUES (67,'MANUELA','GOMEZ GALLEGO','1000413880','6/26/2003','3146116919','SURA')";
        sql[67] = "INSERT INTO Estudiante VALUES (68,'MARIA ALEJANDRA','GARCIA ZULUAGA','1007243163','6/8/2002','3122707021','SALUD TOTAL')";
        sql[68] = "INSERT INTO Estudiante VALUES (69,'MARIANTONIA','DIAZ ROJAS','1015074471','5/24/2009','3046573320','SUMIMEDICA')";
        sql[69] = "INSERT INTO Estudiante VALUES (70,'JUANITA','MESA MONSALVE','1022146329','11/4/2006','3206203049','SURA')";
        sql[70] = "INSERT INTO Estudiante VALUES (71,'JUAN PABLO','RENDON C','1011405569','6/8/2012','3106440777','SURA')";
        sql[71] = "INSERT INTO Estudiante VALUES (72,'ANA ISABEL','ALZATE M','1020424208',NULL,'3147739842',NULL)";
        sql[72] = "INSERT INTO Estudiante VALUES (73,'ANA SOFIA','HENAO RICO','1018239414','11/14/2007','3113331611','RED VITAL')";
        sql[73] = "INSERT INTO Estudiante VALUES (74,'KARINA','AGUDELO ARENAS','1035972346','12/7/2004','3216360827','SURA')";
        sql[74] = "INSERT INTO Estudiante VALUES (75,'JUAN DAVID','HENAO RICO','1018233115','4/28/2006','3113331611','RED VITAL')";
        String finish="COMMIT";
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public void inistd(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO Estudiante VALUES (75,'JUAN DAVID','HENAO RICO','1018233115','4/28/2006','3113331611','RED VITAL')");
        sql.add("INSERT INTO Estudiante VALUES (4,'JUAN DAVID','HENAO RICO','1018233115','4/28/2006','3113331611','RED VITAL')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }

    public void iniLocate(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_locate +" VALUES (0,'Unidad Deportiva Tulio Ospina de Bello')");
        sql.add("INSERT INTO "+TABLE_NAME_locate +" VALUES (1,'Barrio Rosalpi')");
        sql.add("INSERT INTO "+TABLE_NAME_locate +" VALUES (2,'Parque Goretti')");
        sql.add("INSERT INTO "+TABLE_NAME_locate +" VALUES (3,'Cabañitas IV Etapa')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }

    public void iniTime(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_time_id +" VALUES (0,'3-5')");
        sql.add("INSERT INTO "+TABLE_NAME_time_id +" VALUES (1,'5-7')");
        sql.add("INSERT INTO "+TABLE_NAME_time_id +" VALUES (2,'7-9')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }

    public void iniDate(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_date_id +" VALUES (0,'L-W-V')");
        sql.add("INSERT INTO "+TABLE_NAME_date_id +" VALUES (1,'L-M-J')");
        sql.add("INSERT INTO "+TABLE_NAME_date_id +" VALUES (2,'W-V')");
        sql.add("INSERT INTO "+TABLE_NAME_date_id +" VALUES (3,'M-J')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }

    public void iniTrainer(){
        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_trainer +" VALUES (0,'Camilo','Tabares',0)");
        sql.add("INSERT INTO "+TABLE_NAME_trainer +" VALUES (1,'David','Galindo',1)");
        sql.add("INSERT INTO "+TABLE_NAME_trainer +" VALUES (2,'Victor','Duque Ramos',2)");
        sql.add("INSERT INTO "+TABLE_NAME_trainer +" VALUES (3,'Maicol', 'Jaramillo',3)");
        sql.add("INSERT INTO "+TABLE_NAME_trainer +" VALUES (4,'Camilo', 'Toro',4)");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }

    }

    public void iniCat(){
        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (0,'0','1','mixto')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (1,'1','2','M')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (2,'2','3','mixto')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (3,'2','3','mixto')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (4,'0','2','F')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (5,'3','0','mixto')");
        sql.add("INSERT INTO "+TABLE_NAME_category_num +" VALUES (6,'4','1','mixto')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }

    }

    public void iniPay(){
        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (3,'True',0)");
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (4,'True',1)");
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (5,'True',2)");
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (6,'True',2)");
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (7,'True',2)");
        sql.add("INSERT INTO "+TABLE_NAME_pay_month +" VALUES (8,'True',2)");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }

    }

    public void iniType(){
        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_type_id +" VALUES (0,'Iniciación')");
        sql.add("INSERT INTO "+TABLE_NAME_type_id +" VALUES (1,'Desarrollo')");
        sql.add("INSERT INTO "+TABLE_NAME_type_id +" VALUES (2,'Competitivo')");
        sql.add("INSERT INTO "+TABLE_NAME_type_id +" VALUES (3,'Pasarela')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }

    }

    public void iniSch(){
        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (0,'0','0',0,0)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (1,'1','1',0,0)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (2,'2','2',0,4)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (3,'3','2',0,1)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (4,'4','2',1,2)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (5,'5','2',2,3)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (6,'6','0',2,3)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (7,'6','1',2,3)");
        sql.add("INSERT INTO "+TABLE_NAME_schedule_id +" VALUES (8,'6','1',3,0)");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }

    }

    public void iniRange(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_age_range+" VALUES (0,'98-04')");
        sql.add("INSERT INTO "+TABLE_NAME_age_range+" VALUES (1,'97-04')");
        sql.add("INSERT INTO "+TABLE_NAME_age_range+" VALUES (2,'05-07')");
        sql.add("INSERT INTO "+TABLE_NAME_age_range+" VALUES (3,'08-11')");
        sql.add("INSERT INTO "+TABLE_NAME_age_range+" VALUES (4,'03-11')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }
    public void iniSub(){

        ArrayList<String> sql=new ArrayList<>();
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (0,'5')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (1,'6')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (2,'7')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (3,'8')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (4,'9')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (5,'10')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (6,'11')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (7,'12')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (8,'13')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (9,'14')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (10,'15')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (11,'16')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (12,'17')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (13,'18')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (14,'19')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (15,'20')");
        sql.add("INSERT INTO "+TABLE_NAME_catU +" VALUES (16,'21')");

        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<sql.size();i++){
            db.execSQL(sql.get(i));
        }
    }


    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public Object getRow(String id) {
        return null;
    }

    @Override
    public boolean updateContact(String id) {
        return false;
    }
}
