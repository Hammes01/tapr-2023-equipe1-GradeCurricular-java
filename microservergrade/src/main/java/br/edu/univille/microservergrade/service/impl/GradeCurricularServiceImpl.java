package br.edu.univille.microservergrade.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univille.microservergrade.entity.GradeCurricular;
import br.edu.univille.microservergrade.repository.GradeCurricularRepository;
import br.edu.univille.microservergrade.service.GradeCurricularService;

@Service
public class GradeCurricularServiceImpl implements GradeCurricularService {

   @Autowired
    private GradeCurricularRepository repository;
   
   
  
    @Override
    public List<GradeCurricular> getAll() {

        var iterador = repository.findAll();
        List<GradeCurricular> listaGradeCurriculares = new ArrayList<>();

        iterador.forEach(listaGradeCurriculares::add);
        return listaGradeCurriculares;
    }

    @Override
    public GradeCurricular getById(String id) {
        var gradecurricular = repository.findById(id);
        if(gradecurricular.isPresent())
            return gradecurricular.get();
        return null;
        
    }

    @Override
    public GradeCurricular saveNew( GradeCurricular gradecurricular) {
            gradecurricular.setId(null);
            return repository.save(gradecurricular);
    }
}