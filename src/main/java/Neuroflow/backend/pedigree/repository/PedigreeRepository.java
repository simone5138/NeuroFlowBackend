package Neuroflow.backend.pedigree.repository;

import Neuroflow.backend.pedigree.entity.Pedigree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedigreeRepository extends JpaRepository<Pedigree, Long> {
    Optional<Pedigree> findByPatientId(Long patientId);
}

