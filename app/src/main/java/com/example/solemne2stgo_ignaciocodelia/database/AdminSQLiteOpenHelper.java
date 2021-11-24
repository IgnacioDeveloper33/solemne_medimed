package com.example.solemne2stgo_ignaciocodelia.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //Constructor para poder instanciar y usar mi database ...

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    //ME permite generar mi modelo a trabajar (crear tablas y sus campos)

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creo mi tabla y sus campos
        db.execSQL("CREATE TABLE citas(codigo int primary key, especialidad text, dia text)");

    }

    // Me permite realizar cambios esquematicos en mi modelo.

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
