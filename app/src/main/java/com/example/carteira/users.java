package com.example.carteira;

import java.io.Serializable;

public class users implements Serializable {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCaminho_img() {
        return caminho_img;
    }

    public void setCaminho_img(String caminho_img) {
        this.caminho_img = caminho_img;
    }

    private String nome;
    private String id;
    private String matricula;
    private String senha;
    private String usuario;
    private String turma;
    private String curso;
    private String caminho_img;

}
