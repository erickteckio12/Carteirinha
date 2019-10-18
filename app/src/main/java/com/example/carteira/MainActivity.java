package com.example.carteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rellay1;


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
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtUsuario = (TextView) findViewById(R.id.txtUsuario);
                TextView txtSenha = (TextView) findViewById(R.id.txtSenha);
                String usuario = txtUsuario.getText().toString();
                String senha = txtSenha.getText().toString();

            }
        });
    }

}
