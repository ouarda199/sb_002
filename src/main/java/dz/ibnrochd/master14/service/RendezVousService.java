package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.RendezVous;
import dz.ibnrochd.master14.mapper.RendezVousMapper;
@Service
public class RendezVousService {
	
	
	private final RendezVousMapper rendezVousMapper;
    
    @Autowired
    public RendezVousService(RendezVousMapper rendezVousMapper) {
        this.rendezVousMapper = rendezVousMapper;
    }
	
	
	
	public void insererRendezVous(RendezVous rendezvous) {
		rendezVousMapper.creerRendezVous(rendezvous);
    	 System.out.println("L'ajout avec sucess pour le rendez-vous");
    	
    }
	
	
	public RendezVous lirelesRendezVous(int id) {
		 return rendezVousMapper.lireRendezVous(id);
    }
	
	
	public void supprimerlesrendezvous(int id ) {
		rendezVousMapper.supprimerrendezvous(id);
	    	
	    	 System.out.println("Supprimer des rendez-vous");
	    
	    
	    }
	
	  public void miseajourdesRendezVous(RendezVous rendezvous) {
	        rendezVousMapper.miseajourpatientrendezvous(rendezvous);
	        System.out.println("La mise a jour des Rendez-vous");
	    }
	  
	  public List<RendezVous>getPatientId(int patient_id)  {
		  return rendezVousMapper.PatientId(patient_id);
		 }
	  
	  
	  
}
