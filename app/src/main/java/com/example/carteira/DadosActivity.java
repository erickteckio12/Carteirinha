package com.example.carteira;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DadosActivity extends AppCompatActivity {
    TextView txtnome;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = getIntent();
        users usuario = (users) intent.getSerializableExtra("usuario");
        txtnome = findViewById(R.id.txtNome);
        txtnome.setText(usuario.nome);

    }
}
