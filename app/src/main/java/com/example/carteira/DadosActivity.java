package com.example.carteira;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DadosActivity extends AppCompatActivity {
    TextView txtnome, txtturma, txtcurso, txtmatricula;
    ImageView codBarra;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = getIntent();
        users usuario = (users) intent.getSerializableExtra("usuario");
        //
        txtnome = findViewById(R.id.txtNome);
        txtturma = findViewById(R.id.txtTurma);
        txtcurso = findViewById(R.id.txtCurso);
        txtmatricula = findViewById(R.id.txtMatricula);
        codBarra = findViewById(R.id.codBarra);

        //
        txtnome.setText(usuario.nome);
        txtturma.setText(String.valueOf(usuario.turma));
        txtcurso.setText(usuario.curso);
        txtmatricula.setText(usuario.matricula);
        String caminho = usuario.caminho_img;
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/"+caminho, null, c.getPackageName());
        codBarra.setImageResource(id);


    }
}
