package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.TreatmentPath;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TreatmentPathService {

    @PersistenceContext
    private EntityManager entityManager;

    public TreatmentPath create(TreatmentPath treatmentPath) {
        entityManager.persist(treatmentPath);
        return treatmentPath;
    }
    public TreatmentPath find(Long treatmentPathId) {
        return entityManager.find(TreatmentPath.class, treatmentPathId);
    }

    public TreatmentPath update(TreatmentPath treatmentPath) {
        return entityManager.merge(treatmentPath);
    }

    public List<TreatmentPath> findAll() {
        return entityManager.createQuery("SELECT t FROM TreatmentPath t", TreatmentPath.class).getResultList();
    }

    public void delete(Long treatmentPathId) {
        TreatmentPath treatmentPath = find(treatmentPathId);
        if (treatmentPath != null)
            entityManager.remove(treatmentPath);
    }

}
