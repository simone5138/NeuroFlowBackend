package Neuroflow.backend.report.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "report")
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_id", nullable=false)
    private Long patientId;

    @Column(name="author_user_id")
    private Long authorUserId;

    @Column(nullable=false, length=200)
    private String title;

    @Lob
    private String content; // testo lungo (markdown/HTML/plain)

    @Column(nullable=false)
    private Instant createdAt = Instant.now();

    @Column(nullable=false)
    private Instant updatedAt = Instant.now();

    @PreUpdate void onUpdate(){ this.updatedAt = Instant.now(); }

    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getPatientId(){return patientId;} public void setPatientId(Long p){this.patientId=p;}
    public Long getAuthorUserId(){return authorUserId;} public void setAuthorUserId(Long a){this.authorUserId=a;}
    public String getTitle(){return title;} public void setTitle(String t){this.title=t;}
    public String getContent(){return content;} public void setContent(String c){this.content=c;}
    public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant c){this.createdAt=c;}
    public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant u){this.updatedAt=u;}
}

