package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.Report;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ReportService {

    @PersistenceContext
    private EntityManager entityManager;

    public Report create(Report report) {
        entityManager.persist(report);
        return report;
    }

    public Report find(Long reportId) {
        return entityManager.find(Report.class, reportId);
    }

    public List<Report> findWithId(Long reportId) {
        return entityManager.createQuery("SELECT r FROM Report r WHERE r.id = :reportId", Report.class)
                .setParameter("reportId", reportId)
                .getResultList();
    }

    public Report update(Report report) {
        return entityManager.merge(report); //???
    }

    public List<Report> findAll() {
        return entityManager.createQuery("SELECT r FROM Report r", Report.class).getResultList();
    }

    public void delete(Long reportId) {
        Report report = find(reportId);
        if (report != null)
            entityManager.remove(report);
    }
}
