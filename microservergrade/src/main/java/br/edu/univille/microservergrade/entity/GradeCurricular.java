package br.edu.univille.microservergrade.entity;



import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName="gradecurricular")
public class GradeCurricular {
    @Id
    @GeneratedValue
    public String id;
    @PartitionKey
    public String materia;
    private String cursoId;
    

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return materia;
    }

    public void setNome(String materia) {
        this.materia = materia;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }



}