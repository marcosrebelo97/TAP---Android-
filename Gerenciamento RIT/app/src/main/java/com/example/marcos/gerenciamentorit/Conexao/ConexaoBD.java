package com.example.marcos.gerenciamentorit.Conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoBD extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="ri.db";
    private static final String SQL_CREATE_TABLE_USUARIO="CREATE TABLE usuario (idusuario   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
            "    nome        VARCHAR (50),\n" +
            "    usuario     VARCHAR (20),\n" +
            "    senha       VARCHAR (20)\n" +
            ");";
    private static final String SQL_DELETE_TABLE_USUARIO="DROP TABLE IF EXISTS  USUARIO";


    public ConexaoBD(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_USUARIO);
        onCreate(db);
    }
}
