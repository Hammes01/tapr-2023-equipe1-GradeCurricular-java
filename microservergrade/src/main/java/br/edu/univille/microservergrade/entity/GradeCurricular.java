package br.edu.univille.microservergrade.entity;




import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName="gradecurricular")
public class GradeCurricular {
    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    public String nome;
    public String cursoId;
    private Disciplina disciplina;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Disciplina setDisciplina(Disciplina disciplina) {
        return this.disciplina = disciplina;
    }

}


