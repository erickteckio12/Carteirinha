package com.example.carteira;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class usersRepositorio {
    private usersSH helper;

    public usersRepositorio(Context ctx){
        helper = new usersSH(ctx);
    }

    private long inserir(users users){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(usersSH.COLUNA_NOME, users.nome);
        cv.put(usersSH.COLUNA_USUARIO, users.usuario);
        cv.put(usersSH.COLUNA_MATRICULA, users.matricula);
        cv.put(usersSH.COLUNA_CURSO, users.curso);
        cv.put(usersSH.COLUNA_TURMA, users.turma);
        cv.put(usersSH.COLUNA_CAMINHO_IMG, users.caminho_img);

        long id = db.insert(usersSH.TABELA_USERS, null, cv);
        if(id != -1){
            users.id = id;
        }
        db.close();
        return id;
    }

    public void salvar(users users){
        if(users.id == 0){
            inserir(users);
        } else{
            //atualizar(carro);
        }
    }

    public users validarLogin(String usuario, String matricula){
        users OBJ_user = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT *  FROM users WHERE usuario = ? and matricula = ?", new String[]{usuario, matricula});
        if(c.getCount()>0){

            c.moveToFirst();
            long id = c.getLong(c.getColumnIndex(usersSH.COLUNA_ID));
            String nome = c.getString(c.getColumnIndex(usersSH.COLUNA_NOME));
            String user = c.getString(c.getColumnIndex(usersSH.COLUNA_USUARIO));
            String matr = c.getString(c.getColumnIndex(usersSH.COLUNA_MATRICULA));
            String caminho_img = c.getString(c.getColumnIndex(usersSH.COLUNA_CAMINHO_IMG));
            String curso = c.getString(c.getColumnIndex(usersSH.COLUNA_CURSO));
            int turma = c.getInt(c.getColumnIndex(usersSH.COLUNA_TURMA));

            OBJ_user = new users(id, nome, user, matr, caminho_img, turma, curso);

            return OBJ_user;


        }else{
            return null;
        }

    }


    }
