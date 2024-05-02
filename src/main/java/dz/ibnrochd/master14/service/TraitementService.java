package dz.ibnrochd.master14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.RendezVousMapper;
import dz.ibnrochd.master14.mapper.TraitementMapper;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.RendezVous;
import dz.ibnrochd.master14.model.Traitement;

@Service
public class TraitementService {
	
	
	private final TraitementMapper traitementMapper;
 
	@Autowired
    public TraitementService(TraitementMapper traitementMapper) {
        this.traitementMapper = traitementMapper;
    }
	
	
	
	
	public void insererTraitement(Traitement traitement) {
        traitementMapper.creertraitement(traitement);
        System.out.println("Traitement inséré avec succès");
    }
	
	
	public Traitement lirelesTraitements(int id) {
		 return traitementMapper.lireTraitement(id);
    }
	
	
	
	public void miseajourdestraitements(Traitement  traitement) {
		traitementMapper.miseajourtraitemntt(traitement);
		  System.out.println("La mise a jour des traitements");
	    	 
	    	
	}
	
	public void supprimerlestraitemnts(int id ) {
		traitementMapper.supprimertraitement(id);
	    	
	    	 System.out.println("Supprimer les traitements");
	    
	    
	    }
	
	
	
	}
	
	


