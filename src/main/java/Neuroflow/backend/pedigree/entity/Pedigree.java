package Neuroflow.backend.pedigree.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name = "pedigree")
public class Pedigree {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_id", nullable=false)
    private Long patientId;

    @Lob @Column(nullable=false)
    private String data; // JSON

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    @PreUpdate void onUpdate(){ updatedAt = Instant.now(); }

    // getters/setters
}
