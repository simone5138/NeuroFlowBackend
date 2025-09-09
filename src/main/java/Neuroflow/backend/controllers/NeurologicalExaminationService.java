package Neuroflow.backend.controllers;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import Neuroflow.backend.entities.NeurologicalExamination;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NeurologicalExaminationService {

    @PersistenceContext
    private EntityManager entityManager;

    public NeurologicalExamination create(NeurologicalExamination neurologicalExamination) {
        entityManager.persist(neurologicalExamination);
        return neurologicalExamination;
    }

    public NeurologicalExamination find(Long neurologicalExaminationId) {
        return entityManager.find(NeurologicalExamination.class, neurologicalExaminationId);
    }

    public NeurologicalExamination update(NeurologicalExamination neurologicalExamination) {
        return entityManager.merge(neurologicalExamination);
    }

    public List<NeurologicalExamination> findAll() {
        return entityManager.createQuery("SELECT n FROM NeurologicalExamination n", NeurologicalExamination.class).getResultList();
    }

    public void delete(Long neurologicalExaminationId) {
        NeurologicalExamination neurologicalExamination = find(neurologicalExaminationId);
        if (neurologicalExamination != null)
            entityManager.remove(neurologicalExamination);
    }

}
