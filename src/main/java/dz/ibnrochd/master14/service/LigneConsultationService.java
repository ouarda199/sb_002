package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.LigneConsultationMapper;
import dz.ibnrochd.master14.model.LigneConsultation;

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
}
