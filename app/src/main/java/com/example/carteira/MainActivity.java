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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rellay1;
    EditText txtUsuario, txtSenha;
    Button btnLogar;
    //usersSH db;
    usersRepositorio db;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnEntrar = (Button) findViewById(R.id.btn_Logar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        usersRepositorio carrosDB = new usersRepositorio(this);
        carrosDB.salvar(new users("Erick Teckio", "erick.teckio", "7070217", "Informática", 102, "asdasdas"));
        carrosDB.salvar(new users("Henrique Gundlach", "henrique.teckio", "7070217", "Informática", 102, "asdasdas"));
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btn_Logar);
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
    }
            public void clicar(View view){
                String usuario = txtUsuario.getText().toString();
                String matricula = txtSenha.getText().toString();
                if(usuario.equals("")){
                    Toast.makeText(MainActivity.this, "Insira o Nome de Usuario", Toast.LENGTH_SHORT).show();
                }else if(matricula.equals("")){
                    Toast.makeText(MainActivity.this, "Insira a Senha (Matricula)", Toast.LENGTH_SHORT).show();

                }else{
                    db = new usersRepositorio(this);
                    users res = db.validarLogin(usuario,matricula);

                    if(res != null){
                        Intent it = new Intent(this, DadosActivity.class);
                        it.putExtra("usuario", res);
                        startActivity (it);
                    }else{
                        Toast.makeText(MainActivity.this, "Usuario ou senha errados!", Toast.LENGTH_SHORT).show();
                    }
                }



    }

}
