package com.example.carteira;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class usersDAO {
    private Conexao cnx;
    private SQLiteDatabase banco;

    private usersDAO(Context context) {
        cnx = new Conexao(context);
        banco = cnx.getWritableDatabase();

    }

    public long inserir(users users) {
        ContentValues vl = new ContentValues();
        vl.put("nome", "erick teckio");
        vl.put("matricula", "7070217");
        vl.put("senha", "7070217");
        vl.put("usuario", "erick.teckio");
        vl.put("turma", "302");
        vl.put("curso", "Informática");
        vl.put("caminho_img", "teste");
        return banco.insert("users", null, vl);

    }


}
