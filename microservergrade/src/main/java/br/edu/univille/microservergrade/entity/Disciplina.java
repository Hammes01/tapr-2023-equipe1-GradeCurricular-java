package br.edu.univille.microservergrade.entity;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String cargaHoraria;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCargaHoraria() {
        return this.cargaHoraria;
    }

    public static List<Disciplina> createDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNome("Nome da disciplina 1");
        disciplina1.setCargaHoraria("Carga horária da disciplina 1");
        disciplinas.add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Nome da disciplina 2");
        disciplina2.setCargaHoraria("Carga horária da disciplina 2");
        disciplinas.add(disciplina2);

        // Adicione mais disciplinas conforme necessário

        return disciplinas;
    }
}