package br.edu.univille.microservergrade.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


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
    public ResponseEntity<GradeCurricular> buscarGradeCurricular(@PathVariable("id") String id){
        var gradecurricular = service.getById(id);
        
        if(gradecurricular == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return
            new ResponseEntity<GradeCurricular>(gradecurricular, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GradeCurricular> inserirGradeCurricular(@RequestBody GradeCurricular gradecurricular) {
        if(gradecurricular == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        gradecurricular = service.saveNew(gradecurricular);
        return new ResponseEntity<GradeCurricular> (gradecurricular, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeCurricular> atualizarGradeCurricular(@PathVariable("id") String id, @RequestBody GradeCurricular gradecurricular){
        if(gradecurricular == null || id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        gradecurricular = service.update(id, gradecurricular);
        if(gradecurricular == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GradeCurricular>(gradecurricular, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GradeCurricular> removerGradeCurricular(@PathVariable("id") String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var gradecurricular  = service.delete(id);
        if(gradecurricular == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GradeCurricular>(gradecurricular, HttpStatus.OK);
    }
}
