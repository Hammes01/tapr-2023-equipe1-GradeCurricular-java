package br.edu.univille.microservergrade.entity;




import java.util.List;

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
    public String cursoId;
    public String curso;
    private List<Semestre> semestres;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.cursoId = id;
    }


     public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Semestre> getSemestres() {
        return this.semestres;
    }

    public void setDisciplinas(List<Semestre> semestres) {
        this.semestres = semestres;
    }

}


