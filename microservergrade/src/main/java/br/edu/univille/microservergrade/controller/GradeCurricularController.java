package br.edu.univille.microservergrade.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.annotation.PathParam;

import br.edu.univille.microservergrade.entity.GradeCurricular;
import br.edu.univille.microservergrade.service.GradeCurricularService;


@RestController
@RequestMapping("/api/v1/grades")
public class GradeCurricularController {

    @Autowired
    private GradeCurricularService service;
   
    @GetMapping
    public ResponseEntity<List<GradeCurricular>> listaGradeCurriculares(){

        var listaGradeCurriculares = service.getAll();
        
        return new ResponseEntity<List<GradeCurricular>>(listaGradeCurriculares, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeCurricular> buscarCarro(@PathParam("id") String id){
        var gradecurricular = service.getById(id);
        if(gradecurricular == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return
            new ResponseEntity<GradeCurricular>
            (gradecurricular, HttpStatus.OK);
    }
}
