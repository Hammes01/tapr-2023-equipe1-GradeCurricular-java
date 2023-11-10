package br.edu.univille.microservergrade.service;
import java.util.List;
import br.edu.univille.microservergrade.entity.GradeCurricular;

public interface GradeCurricularService {
    public List<GradeCurricular> getAll();
    public GradeCurricular getById(String id);
    public GradeCurricular saveNew( GradeCurricular gradecurricular);
    public GradeCurricular update(String id, GradeCurricular gradecurricular);
    public GradeCurricular delete(String id);
}

