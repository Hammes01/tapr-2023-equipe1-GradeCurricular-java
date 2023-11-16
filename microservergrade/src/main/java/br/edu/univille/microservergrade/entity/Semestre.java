package br.edu.univille.microservergrade.entity;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
    private String nome;
    private List<Disciplina> disciplinas; 


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome + "º Semestre";
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public static List<Semestre> createSemestres() {
        List<Semestre> semestres = new ArrayList<>();

        Semestre semestre1 = new Semestre();
        semestre1.setNome("Semestre 1");
        semestres.add(semestre1);

        Semestre semestre2 = new Semestre();
        semestre2.setNome("Semestre 2");
        semestres.add(semestre2);

        Semestre semestre3 = new Semestre();
        semestre3.setNome("Semestre 3");
        semestres.add(semestre3);

        Semestre semestre4 = new Semestre();
        semestre4.setNome("Semestre 4");
        semestres.add(semestre4);

        Semestre semestre5 = new Semestre();
        semestre5.setNome("Semestre 5");
        semestres.add(semestre5);

        Semestre semestre6 = new Semestre();
        semestre6.setNome("Semestre 6");
        semestres.add(semestre6);

        Semestre semestre7 = new Semestre();
        semestre7.setNome("Semestre 7");
        semestres.add(semestre7);

        Semestre semestre8 = new Semestre();
        semestre8.setNome("Semestre 8");
        semestres.add(semestre8);

        Semestre semestre9 = new Semestre();
        semestre9.setNome("Semestre 9");
        semestres.add(semestre9);

        return semestres;
    }
}