package br.edu.univille.microservergrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservergrade.entity.GradeCurricular;



@Repository
public interface GradeCurricularRepository
    extends CrudRepository<GradeCurricular, Integer>{

    }