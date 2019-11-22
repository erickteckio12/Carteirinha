package com.example.carteira;


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
    TextView txtnome, txtturma;
    ImageView codBarra;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = getIntent();
        users usuario = (users) intent.getSerializableExtra("usuario");
        //
        txtnome = findViewById(R.id.txtNome);
        txtturma = findViewById(R.id.txtTurma);
        codBarra = findViewById(R.id.codBarra);

        //
        txtnome.setText(usuario.nome);
        txtturma.setText(String.valueOf(usuario.turma));
        String caminho = usuario.caminho_img;
        Uri caminhouri = Uri.parse(caminho);
        codBarra.setImageURI(caminhouri);

    }
}
