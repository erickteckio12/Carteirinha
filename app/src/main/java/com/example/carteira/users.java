package com.example.carteira;


import java.io.Serializable;

public class users implements Serializable{
    public long id;
    public String nome;
    public String usuario;
    public String matricula;
    public String curso;
    public int turma;
    public String caminho_img;

    public users(long id, String nome, String usuario, String matricula, String curso , int turma, String caminho_img){
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.matricula = matricula;
        this.curso = curso;
        this.turma = turma;
        this.caminho_img = caminho_img;
    }

    public users(String nome, String usuario, String matricula,  String curso, int turma, String caminho_img){
        this.nome = nome;
        this.usuario = usuario;
        this.matricula = matricula;
        this.curso = curso;
        this.turma = turma;
        this.caminho_img = caminho_img;
    }

    @Override
    public String toString(){
        return nome;
    }

}