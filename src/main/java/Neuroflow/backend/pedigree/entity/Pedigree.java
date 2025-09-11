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
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getPatientId(){return patientId;} public void setPatientId(Long p){this.patientId=p;}
    public String getData(){return data;} public void setData(String d){this.data=d;}
    public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant c){this.createdAt=c;}
    public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant u){this.updatedAt=u;}
}
