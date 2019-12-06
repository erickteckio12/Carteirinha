package com.example.carteira;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private usersSH helper;



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
        helper = new usersSH(this);
        SQLiteDatabase db2 = helper.getReadableDatabase();




        Button btnEntrar = (Button) findViewById(R.id.btn_Logar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        usersRepositorio carrosDB = new usersRepositorio(this);
        long numOfEntries = DatabaseUtils.queryNumEntries(db2, "users");
        if(numOfEntries  < 1){
            carrosDB.salvar(new users("Erick Pereira da Rosa Teckio", "erick.teckio", "7070217", "Informática", 302, "img7070217"));
            carrosDB.salvar(new users("Henrique Gundlach", "henrique.gundlach", "7070220", "Informática", 302, "img7070220"));
            carrosDB.salvar(new users("Julia Carnelli dos Santos Webber", "julia.webber", "7080221", "Mecânica", 103, "img7080221"));
            carrosDB.salvar(new users("Lucas Lammel", "lucas.lammel", "7070225", "Informática", 302, "img7070225"));
            carrosDB.salvar(new users("Emanuel de Lara Ruas", "emanuel.ruas", "7070213", "Informática", 302, "img7070213"));
            carrosDB.salvar(new users("Carlos Rocha", "carlos.rocha", "7070210", "Informática", 302, "img7070210"));
            carrosDB.salvar(new users("Lucas E. Benini", "lucas.benini", "7070224", "Informática", 302, "img7070224"));
            carrosDB.salvar(new users("Eduardo Severo de Campos", "eduardo.severo", "7070212", "Informática", 302, "img7070212"));
            carrosDB.salvar(new users("Emilia Sarturi", "emilia.sarturi", "7070215", "Informática", 302, "img7070215"));
            carrosDB.salvar(new users("Aline E. Iora", "aline.iora", "7070204", "Informática", 302, "img7070204"));
            carrosDB.salvar(new users("Luiz Cassol", "luiz.cassol", "7070228", "Informática", 302, "img7070228"));
            carrosDB.salvar(new users("Joao Vitor Batistella", "joao.batistella", "7070223", "Informática", 302, "img7070223"));
            carrosDB.salvar(new users("Erick Greff", "erick.greff", "7070216", "Informática", 302, "img7070216"));
            carrosDB.salvar(new users("Iago Ivanir Dalmolin", "iago.dalmolin", "7070221", "Informática", 302, "img7070221"));
            carrosDB.salvar(new users("Luiz Henrique Keller", "luiz.keller", "7070229", "Informática", 302, "img7070229"));
            carrosDB.salvar(new users("Bernardo Gatto Hansen", "bernardo.gatto", "7070209", "Informática", 302, "img7070209"));
            carrosDB.salvar(new users("Thais Cristina Budke", "thais.budke", "7070232", "Informática", 302, "img7070232"));
            carrosDB.salvar(new users("Taina Souza", "taina.souza", "7070231", "Informática", 302, "img7070231"));
            carrosDB.salvar(new users("Lucas Morisson Loreto Machado", "lucas.morisson", "7070226", "Informática", 302, "img7070226"));
            carrosDB.salvar(new users("Jean F. Maldaner Lui", "jean.lui", "7070222", "Informática", 302, "img7070222"));
            carrosDB.salvar(new users("Ana Julia dos Santos", "ana.santos", "7070207", "Informática", 302, "img7070207"));
            carrosDB.salvar(new users("Cecilia Pereira da Silveira", "cecilia.pereira", "7070211", "Informática", 302, "img7070211"));
            carrosDB.salvar(new users("Ana Caroline de Borba Schwendler", "ana.schwendler", "7070206", "Informática", 302, "img7070206"));
            carrosDB.salvar(new users("Amanda Horbach", "amanda.horbach", "7070205", "Informática", 302, "img7070205"));
            carrosDB.salvar(new users("Felipe Souza", "felipe.souza", "7070218", "Informática", 302, "img7070218"));
            carrosDB.salvar(new users("Gabriel Leite Pértile", "gabriel.pertile", "7070219", "Informática", 302, "img7070219"));
            carrosDB.salvar(new users("Emanueli Escobar", "emanueli.escobar", "7070214", "Informática", 302, "img7070214"));
        }
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
