package br.edu.univille.microservergrade.entity;


public class Disciplina {
    private String nome;
    private String cursoId;
    private String cargaHoraria;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria + " hrs";
    }

       
}