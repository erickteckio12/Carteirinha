package com.example.carteira;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class usersSH extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "dbUsers";
    private static final int VERSAO_BANCO = 1;

    public static final String TABELA_USERS = "users";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_USUARIO= "usuario";
    public static final String COLUNA_MATRICULA = "matricula";
    public static final String COLUNA_CURSO = "curso";
    public static final String COLUNA_TURMA = "turma";
    public static final String COLUNA_CAMINHO_IMG = "caminho_img";

    /*
            this.nome = nome;
        this.matricula = matricula;
        this.usuario = usuario;
        this.turma = turma;
        this.curso = curso;
        this.caminho_img = caminho_img;
     */

    public  usersSH(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(

        "CREATE TABLE " +TABELA_USERS+ " (" +
                COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUNA_NOME + " TEXT NOT NULL, " +
                COLUNA_USUARIO + " TEXT NOT NULL, " +
                COLUNA_MATRICULA + " TEXT NOT NULL, " +
                COLUNA_CURSO + " TEXT NOT NULL, " +
                COLUNA_TURMA + " INTEGER NOT NULL, " +
                COLUNA_CAMINHO_IMG + " TEXT NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        //próximas versões
    }

}
