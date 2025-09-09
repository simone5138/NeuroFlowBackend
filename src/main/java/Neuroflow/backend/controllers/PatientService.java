package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PatientService {

    @PersistenceContext
    private EntityManager entityManager;

    public Patient create(Patient patient) {
        entityManager.persist(patient);
        return patient;
    }

    public Patient find(Long patientId) {
        return entityManager.find(Patient.class, patientId);
    }

    public Patient update(Patient patient) {
        return entityManager.merge(patient); //???
    }

    public List<Patient> findAll() {
        return entityManager.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }

    public void delete(Long patientId) {
        Patient patient = find(patientId);
        if (patient != null)
            entityManager.remove(patient);
    }
}
