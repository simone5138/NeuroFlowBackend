package Neuroflow.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="neurological_examination")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NeurologicalExamination {

    //maybe standard for all examinations??
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Report.class, fetch = FetchType.LAZY) //maybe?? should see based on specifications
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @Column(name = "performed")
    private boolean performed;

    @Column(name = "date")
    private Date date;

    @Column(name = "reason_not_performed")
    private String reasonNotPerformed;

    //maybe specific for neurologicalExamination

    @Column(name = "orientation")
    private Boolean orientation = false;

    @Column(name = "apraxia")
    private Boolean apraxia = false;

    @Column(name = "psychosis")
    private Boolean psychosis = false;

    @Column(name = "attention")
    private Boolean attention = false;

    @Column(name = "behavieur")
    private Boolean behavior = false;

    @Column(name = "memory")
    private Boolean memory = false;

    @Column(name = "mood")
    private Boolean mood = false;

    @Column(name = "language")
    private Boolean language = false;

    @Column(name = "agnosia")
    private Boolean agnosia = false;

    @Column(name = "anosognosia")
    private Boolean anosognosia = false;

    //add private class for CranialNerve?
    @ElementCollection
    @CollectionTable(name = "cranial_nerve", joinColumns = @JoinColumn(name = "neurological_examination_id"))
    private List<CranialNerve> cranialNerves = initializeCranialNerves();

    @Column(name = "palmomental")
    private Boolean palmomental = false;

    @Column(name = "pseudodulbar_effect")
    private Boolean pseudodulbarEffect = false;

    @Column(name = "trornmer")
    private Boolean trornmer = false;

    @Column(name = "myerson")
    private Boolean myerson = false;

    @Column(name = "palmar_grasp")
    private Boolean palmarGrasp = false;

    @Column(name = "snout")
    private Boolean snout = false;

    @Column(name = "hoffman")
    private Boolean hoffman = false;

    @Column(name = "yawning")
    private Boolean yawning = false;

    @Column(name = "plantar")
    private Boolean plantar = false;

    @Column(name = "not_standing")
    private Boolean notStanding = false;

    @Column(name = "gait_normal") //only normal on frontend, gait is the subcategory
    private Boolean gaitNormal = false;

    @Column(name = "myopathic")
    private Boolean myopathic = false;

    @Column(name = "choreiform")
    private Boolean choreiform = false;

    @Column(name = "antalgic")
    private Boolean antalgic = false;

    @Column(name = "hemiplegic")
    private Boolean hemiplegic = false;

    @Column(name = "Spastic_displegic")
    private Boolean spasticDisplegic = false;

    @Column(name = "bizarre") //should be gait_bizarre??
    private Boolean bizarre = false;

    @Column(name = "parkinsonian")
    private Boolean parkinsonian = false;

    @Column (name = "ataxic")
    private Boolean ataxic = false;

    @Column(name = "neuropathic")
    private Boolean neuropathic = false;

    @Column(name = "sensory")
    private Boolean sensory = false;

    @Column (name = "romberg_positive") //only positive on frontend romberg is the subcategory
    private Boolean rombergPositive = false;

    public static List<NeurologicalExamination.CranialNerve> initializeCranialNerves() {
        List<CranialNerve> cranialNerves = new ArrayList<>();
        String[] nerves = { "I", "II", "III-IV-XI", "V", "VII", "VIII", "IX-X", "XI", "XII" };
        String[] sides = { "destro", "sinistro" };

        for (String nerve : nerves) {
            for (String side : sides) {
                cranialNerves.add(new CranialNerve(nerve, side, false));
            }
        }

        return cranialNerves;
    }


    @Embeddable
    @Getter
    public static class CranialNerve {

        @Column (name = "nerve")
        private String nerve;

        @Column (name = "side")
        private String side;

        @Column (name = "present")
        private Boolean present;

        CranialNerve(String nerve, String side, Boolean present) {
            this.nerve = nerve;
            this.side = side;
            this.present = present;
        }

    }

}
