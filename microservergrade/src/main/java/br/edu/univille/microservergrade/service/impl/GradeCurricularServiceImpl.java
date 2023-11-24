package br.edu.univille.microservergrade.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.edu.univille.microservergrade.entity.GradeCurricular;
import br.edu.univille.microservergrade.repository.GradeCurricularRepository;
import br.edu.univille.microservergrade.service.GradeCurricularService;


import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Service
public class GradeCurricularServiceImpl implements GradeCurricularService {

   @Autowired
    private GradeCurricularRepository repository;
    private DaprClient client = new DaprClientBuilder().build();
    @Value("${app.component.topic.gradecurricular}")
    private String TOPIC_NAME;
    @Value("${app.component.service}")
	private String PUBSUB_NAME;
   

  
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
            gradecurricular = repository.save(gradecurricular);
            publicarAtualizacao(gradecurricular);
            return gradecurricular;
    }

    @Override
    public GradeCurricular update(String id, GradeCurricular gradecurricular) {
        var buscaGradeCurricularAntigo = repository.findById(id);
        if (buscaGradeCurricularAntigo.isPresent()){
            var gradecurricularAntigo = buscaGradeCurricularAntigo.get();
            

            //Atualizar cada atributo do objeto antigo
            gradecurricularAntigo.setCurso(gradecurricular.getCurso());
            gradecurricularAntigo = repository.save(gradecurricularAntigo);
            publicarAtualizacao(gradecurricularAntigo);
            return gradecurricularAntigo;
        
        }
        return null;
    }

    @Override
    public GradeCurricular delete(String id) {
        var buscaGradeCurricular = repository.findById(id);
        if (buscaGradeCurricular.isPresent()){
            var gradecurricular = buscaGradeCurricular.get();

            repository.delete(gradecurricular);

            return gradecurricular;
        }
        return null;
    }
        //método privado para publicar a atualização
        private void publicarAtualizacao(GradeCurricular gradecurricular){
            client.publishEvent(
				    	PUBSUB_NAME,
				    	TOPIC_NAME,
				    	gradecurricular).block();
    }
}