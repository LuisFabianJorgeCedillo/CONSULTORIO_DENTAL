package com.example.consultoriodental;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    // Constructor por donde entra nombre de la base de datos
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Aquí es donde debes escribir el código para crear las tablas y definir la estructura inicial de la base de datos utilizando sentencias SQL.
    // structura que va tener las tablas si hay relacion entre ellas
    //db permite ejecutar la sentencia
    @Override
    public void onCreate(SQLiteDatabase db) {
         String query= "create table usuario(_ID integer primary key autoincrement, Nombre text, Apellido text, " +
                 "correo text,  ci text, password text );";
        // crea la primera ves no la crea cada rato
         db.execSQL(query);
    }

    //Aquí es donde debes escribir el código para actualizar la estructura de la base de datos según las necesidades de tu aplicación cuando se produzcan cambios de versión
    // modificar las structuras
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // METODO QUE PERMITE ABRIR LA BD
    public void abrir(){
        //permitir abrir para escribir
        this.getWritableDatabase();
    }

    //METODO QUE PERMITA CERRAR LA BD
    public  void  cerrar(){
        //cerrar la bd
        this.close();
    }
   // de aqui insertar valor
    // METODO  PERMITE INSERTAR REGISTROS EN LA TABLA USUARIO
   public void insertarRegistro(String nomb, String apell, String corr, String ci, String passw){
        //Esta vacio el contenValues hay que enviar valores
       ContentValues valores = new ContentValues();
       // Se envia por aca
         //poner el NOMBRE de cada uno de los campos que tiene la tabla, y con los parametros insertados
       valores.put("Nombre", nomb);
       valores.put("Apellido", apell);
       valores.put("Correo", corr);
       valores.put("CI", ci);
       valores.put("Password", passw);
       //Grabar ahora los datos en la tabla

       this.getWritableDatabase().insert("usuarios",null,valores);
   }

}
