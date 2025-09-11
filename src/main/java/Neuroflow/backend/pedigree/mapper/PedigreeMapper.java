package Neuroflow.backend.pedigree.mapper;

import Neuroflow.backend.pedigree.dto.PedigreeDto;
import Neuroflow.backend.pedigree.entity.Pedigree;
import org.springframework.stereotype.Component;

@Component
public class PedigreeMapper {
    public PedigreeDto toDto(Pedigree e){
        PedigreeDto d = new PedigreeDto();
        d.setId(e.getId());
        d.setPatientId(e.getPatientId());
        d.setData(e.getData());
        d.setCreatedBy(e.getCreatedBy());
        d.setCreatedAt(e.getCreatedAt());
        d.setLastModifiedBy(e.getLastModifiedBy());
        d.setLastModified(e.getLastModified());
        return d;
    }
}
