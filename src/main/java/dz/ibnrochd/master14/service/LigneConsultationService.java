package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.LigneConsultationMapper;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;

@Service
public class LigneConsultationService {
	private final LigneConsultationMapper ligneConsultationMapper;

    @Autowired
    public LigneConsultationService(LigneConsultationMapper ligneConsultationMapper) {
        this.ligneConsultationMapper = ligneConsultationMapper;
    }

    public List<LigneConsultation> recupLigneConsultations() {
    	List<LigneConsultation> ligneConsultations = ligneConsultationMapper.AfficherTousLigneConsultation();

        for (LigneConsultation ligneConsultation : ligneConsultations) {
            System.out.println("Ligne consultation N°: " + ligneConsultation.getId()+ 
            		", " + ligneConsultation.getPosologie()+
            		", " + ligneConsultation.getUnite_temps() +
            		", " + ligneConsultation.getQuantite());
            if (ligneConsultation.getTraitement() != null) {
                System.out.println("	Nom du traitement: " + ligneConsultation.getTraitement().getNom());
            } else {
                System.out.println("Aucun médicament associé");
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return ligneConsultations;
    }
    
    
    
    public void insererLigneConsultation(LigneConsultation ligneConsultation) {
    	ligneConsultationMapper.creerLigneConsultation(ligneConsultation);
    	 System.out.println("L'ajout avec sucess pour la consultation");
    	
    }
    
    public LigneConsultation lirelesLigneConsultation(int id ) {
    	 return ligneConsultationMapper.lireLigneConsultation(id);
    }
    
    
    public void miseajourdeslignesConsultations(LigneConsultation ligneConsultation) {
    	ligneConsultationMapper.miseajourligneconsultation(ligneConsultation);
		  System.out.println("La mise a jour des  lignes consultations");
	    	 
	    	
	    }
    
    public void supprimerlesconsultations(int id ) {
    	ligneConsultationMapper.supprimerligneconsultation(id);
	    	
	    	 System.out.println("Supprimer des  lignes de consultations");
	    
	    
	    }
    public List<LigneConsultation> getLigneConsultationsbyid(int cons_id) {
    	 return ligneConsultationMapper.consultationbyid(cons_id);
    }
    
    
    public List<LigneConsultation> getTraitementbyid(int patient_id) {
   	 return ligneConsultationMapper.consultationbyid(patient_id);
   }
    
    
}
