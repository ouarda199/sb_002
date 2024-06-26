package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Patient;

@Mapper
public interface PatientMapper {
    List<Patient> afficherAllPatient();
    List<Patient> findByNom(String nom);
    void insertPatient(Patient patient);
 
}
