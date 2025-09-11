package Neuroflow.backend.patient.mapper;

import Neuroflow.backend.patient.dto.*;
import Neuroflow.backend.patient.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientDto toDto(Patient e) {
        if (e == null) return null;
        PatientDto d = new PatientDto();
        d.setId(e.getId());
        d.setFirstName(e.getFirstName());
        d.setLastName(e.getLastName());
        d.setDateBirth(e.getDateBirth().toLocalDate()); // adatta se è LocalDate già
        d.setCityBirth(e.getCityBirth());
        d.setAddress(e.getAddress());
        d.setGender(e.getGender());
        d.setOccupation(e.getOccupation());
        d.setNationality(e.getNationality());
        d.setStudyYears(e.getStudyYears());
        d.setMaritalStatus(e.getMaritalStatus());
        d.setCaregiver(e.isCaregiver());
        d.setPhoneNumber(e.getPhoneNumber());
        d.setMail(e.getMail());
        return d;
    }

    public void updateEntity(PatientUpdateRequest r, Patient e) {
        if (r == null || e == null) return;
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setDateBirth(java.sql.Date.valueOf(r.getDateBirth()));
        e.setCityBirth(r.getCityBirth());
        e.setAddress(r.getAddress());
        e.setGender(r.getGender());
        e.setOccupation(r.getOccupation());
        e.setNationality(r.getNationality());
        e.setStudyYears(r.getStudyYears());
        e.setMaritalStatus(r.getMaritalStatus());
        e.setCaregiver(r.isCaregiver());
        e.setPhoneNumber(r.getPhoneNumber());
        e.setMail(r.getMail());
    }

    public void updateEntity(PatientCreateRequest r, Patient e) {
        if (r == null || e == null) return;
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setDateBirth(java.sql.Date.valueOf(r.getDateBirth()));
        e.setCityBirth(r.getCityBirth());
        e.setAddress(r.getAddress());
        e.setGender(r.getGender());
        e.setOccupation(r.getOccupation());
        e.setNationality(r.getNationality());
        e.setStudyYears(r.getStudyYears());
        e.setMaritalStatus(r.getMaritalStatus());
        e.setCaregiver(r.isCaregiver());
        e.setPhoneNumber(r.getPhoneNumber());
        e.setMail(r.getMail());
    }

    public Patient toEntity(PatientCreateRequest r) {
        Patient e = new Patient();
        updateEntity(r, e);
        return e;
    }
}
