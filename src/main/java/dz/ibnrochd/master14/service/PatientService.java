package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.Patient;

@Service
public class PatientService {
	private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public void Patients() {
        List<Patient> patients = patientMapper.afficherAllPatient();
        for (Patient patient : patients) {
            System.out.println("Nom du patient : " + patient.getNom()); 
        }
    }
    
    public void PatientParNom(String nom) {
        List<Patient> Nom = patientMapper.findByNom(nom);

        if (Nom.isEmpty()) {
            System.out.println("Aucun malade avec le nom '" + nom + "'.");
        } else {
            System.out.println("Patients du nom : '" + nom + "':");
            for (Patient patient : Nom) {
                System.out.println("Prénom: " + patient.getPrenom());
                
            }
        }
    }
    
   
    public void NouveauPatient(Patient patient) {
        patientMapper.insertPatient(patient);
        System.out.println("Un nouveau patient a été ajouté !");
    }
    
}
