package dz.ibnrochd.master14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import dz.ibnrochd.master14.model.Traitement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.RendezVous;
import dz.ibnrochd.master14.model.Traitement;
import dz.ibnrochd.master14.service.PatientService;
import dz.ibnrochd.master14.service.ConsultationService;
import dz.ibnrochd.master14.service.LigneConsultationService;
import dz.ibnrochd.master14.service.RendezVousService;
import dz.ibnrochd.master14.service.TraitementService;

@SpringBootApplication
public class Sb002Application implements CommandLineRunner {
	
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	// TODO : déclarer les autres repository de la même façon que PatientRepository
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private LigneConsultationService ligneConsultationService;
	
	@Autowired
	private  ConsultationService ConsultationService;
	
	@Autowired
	private RendezVousService rendezVousService;
	
	@Autowired
    private TraitementService traitementService;

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO : récupérer la liste de tous les patients puis afficher leurs noms
		//patientService.Patients();
		
		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		//patientService.PatientParNom("Yahi");
		
		
		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
		/*
		Patient patient = new Patient();
		patient.setNom("Kedim");
		patient.setPrenom("sarah");
		patient.setSexe ("F");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
         Date dateNaiss = dateFormat.parse("1998-04-15");
         patient.setDateNaissance(dateNaiss);
        } catch (ParseException e) {
         e.printStackTrace();
        }
        patient.setNumeroTelephone ("0555658795");
        patient.setAdresse ("CNTSID");

        patientService.insererPatient(patient);
        
        */

				
		// TODO : rechercher la consultation ayant id=3 
       // consultationService.ConsultationParId(3);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
        //ligneConsultationService.recupLigneConsultations();

        
		
		//--------------Patient------------------
		
	
		//L'affichage
		
	   patientService.lirelesPatient(4);
		 System.out.println("lire le patient");
		
		// La création
		
		Patient patient = new Patient();
		patient.setNom("kedim");
		patient.setPrenom("sarah");
		patient.setSexe ("F");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
         Date dateNaiss = dateFormat.parse("1995-03-11");
         patient.setDateNaissance(dateNaiss);
        } catch (ParseException e) {
         e.printStackTrace();
        }
        patient.setNumeroTelephone ("0652148795");
        patient.setAdresse ("CNTSID");

        patientService.insererPatient(patient);
        
        
        
        //La mise a jour 

  Patient patieUpdate = patientService.lirelesPatient(2);

     //Vérifiez si le patient existe
     if (patieUpdate != null) {
         // Modifiez les attributs du patient
    	 patieUpdate.setNom("sarah");
    	 patieUpdate.setPrenom("mohammed");
    	 patieUpdate.setSexe("f");
    	 patieUpdate.setNumeroTelephone("45782145236");
    	 patieUpdate.setAdresse("alger");
    	 
    	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    	    try {
    	        Date nouvelleDate1 = dateFormat1.parse("2024-05-01"); // Remplacez cette date par la nouvelle date que vous souhaitez utiliser
    	        patieUpdate.setDateNaissance(nouvelleDate1);
    	    } catch (ParseException e) {
    	        e.printStackTrace();
    	    }

         // Appelez le service pour mettre à jour le patient
         patientService.miseajourlesPatient(patieUpdate);
     } else {
         System.out.println("Patient n'est pas trouvé avec l'identifiant donné");
     }
     
     
     //la suppression 
      // patientService. supprimerlesPatient(2);
     
     
   
     
 		
		// TODO : rechercher la consultation ayant id=3 
        //consultationService.ConsultationParId(3);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
        //ligneConsultationService.recupLigneConsultations();
		
		
	
	
      /* //--------------------Consultation----------------------------
       
       //L'affichage
	//	consultationService.lirelesConsultations(1);
		//System.out.println("lire la consultation");
        
		//La création

		Consultation consultation1 = new Consultation();
		consultation1.setMotif("Visite chez le cardiologue");
        long timestampInMillis = System.currentTimeMillis();
        Date date = new Date(timestampInMillis);
        Timestamp dateconsult = new Timestamp(date.getTime());
        consultation1.setDateConsult(dateconsult);
        Patient patient = new Patient();
        patient.setId(1);
        consultation1.setPatient(patient);
        consultationService.insererConsultation(consultation1);
	
	
	 //La mise a jour 

	Consultation consultUpdate = consultationService.lirelesConsultations(2);

	// Vérifiez si la consultation existe
	if (consultUpdate != null) {
	    // Modifiez les attributs de la consultation
	    consultUpdate.setMotif("tres tres  tres malade");
	    
	    // Créez un objet Patient pour mettre à jour la référence du patient dans la consultation
	    Patient patient1 = new Patient();
	    patient1.setId(2);
	    consultUpdate.setPatient(patient1);
	    
	    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        // Parsez la date
	        Date dateConsult = dateFormat1.parse("1998-04-15");
	        
	        // Convertissez la date en Timestamp
	        Timestamp timestamp = new Timestamp(dateConsult.getTime());

	        // Affectez la date consultée à l'objet Consultation
	        consultUpdate.setDateConsult(timestamp);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    // Appelez le service pour mettre à jour la consultation
	    consultationService.miseajourdesConsultations(consultUpdate);
	} else {
	    System.out.println("Mise a jour avec succes ");
	}


		
		 Consultation consultSupp = consultationService.lirelesConsultations(3);
	        if(consultSupp != null) {
		          List<LigneConsultation> ls = ligneConsultationService.getLigneConsultationsbyid(3);
		      	  if (!ls.isEmpty()) {
		      	    System.out.println("Suppression impossible pour cette consultation !!!");
		  	      } 
		  	      else {
		  	    	consultationService.supprimerlesconsultations(3);
		  	      }
	        	
	        }
	        else {
	        	System.out.println("Cette consultation n'existe pas");
	        }
		
		
		*/
	
	// --------------------Ligne Consultation------------------------------ 
   /*// La création
     LigneConsultation ligneconsultation = new LigneConsultation();
     ligneconsultation.setPosologie("9x /jour");
	 Consultation consult_Ligne = new Consultation();
	 consult_Ligne.setId(1);
	 ligneconsultation.setConsultation(consult_Ligne);
	 Traitement traitement_Ligne = new Traitement();
	 traitement_Ligne.setId(1);
	 ligneconsultation.setTraitement(traitement_Ligne);
     ligneconsultation.setUnite_temps("5 jours");
	 ligneconsultation.setQuantite("3");
     ligneConsultationService.insererLigneConsultation(ligneconsultation);
    
    // L'affichage
     LigneConsultation ligneconsultR = ligneConsultationService.lirelesLigneConsultation(5);
     if(ligneconsultR != null) {
    	 System.out.println("Ligne Consultation { "+ ligneconsultR.getId()+ ", "+ligneconsultR.getPosologie()+ ", "+ligneconsultR.getUnite_temps()+ ", "+ligneconsultR.getQuantite()+ "} ");
     }
     else {
    	 System.out.println("y'avais pas une consultation trouvé");
     }
    */
     /*//La mise a jour 
     LigneConsultation ligne = ligneConsultationService.lirelesLigneConsultation(7);
     if(ligne != null) {
    	 ligne.setPosologie("3x /jour");
    	 ligne.setId(1);
    	 ligne.setTraitement(ligne);
    	 traitement_Ligne.setId(1);
    	 ligne.setTraitement(1);
    	 ligne.setUnite_temps("10 jours");;
    	 ligne.setQuantite("5");
    	 ligneConsultationService.miseajourdeslignesConsultations(ligne);
      }
      else {
      System.out.println("y'a pas de consultation trouvé");
    }
     
     */
     /*
     //La supression 
     
     LigneConsultation ligneSupp = ligneConsultationService.lirelesLigneConsultation(8);
     if(ligneSupp != null) {
         ligneConsultationService.supprimerlesconsultations(8);
     } 
     else {
         System.out.println("Cette ligne consultation n'existe pas  pour l'a supprimer !!!");
     }

*/
//------------------------------Rendez_Vous---------------------------

	/*
	 //La création
	   RendezVous rendezVousc = new RendezVous();
	   long MillisR = System.currentTimeMillis();
	   Date dateR = new Date(MillisR);
	   Timestamp dateRV = new Timestamp(dateR.getTime());
	   rendezVousc.setDateRdv(dateRV);
	   Patient patientRV = new Patient();
	   patientRV.setId(1);
	   rendezVousc.setPatient(patientRV);
	   rendezVousService.insererRendezVous(rendezVousc);
	     
	   
	   // L'affichage
	   RendezVous rendezVousR = rendezVousService.lirelesRendezVous(3);
	   if(rendezVousR != null) {
		   System.out.println("Rendez-Vous { "+ rendezVousR.getId()+ ", "+rendezVousR.getDateRdv()+ "} ");
	   }
	   else {
	  	 System.out.println("y'a pas de Rendez-Vous trouvé");
	   }


	   //La mise a jour 
	   RendezVous rendezVousm = rendezVousService.lirelesRendezVous(6);
	   if(rendezVousm != null) {
		   long MillisRU = System.currentTimeMillis();
		   Date dateRU = new Date(MillisRU);
		   Timestamp dateRVU = new Timestamp(dateRU.getTime());
		   rendezVousm.setDateRdv(dateRVU);
		   Patient patientRVU = new Patient();
		   patientRVU.setId(2);
		   rendezVousm.setPatient(patientRVU);
	  	   rendezVousService.miseajourdesRendezVous(rendezVousm);
	   }
	   else {
		   System.out.println("y'avais pas de rendez-vous  trouvé");
	   }

	   
	   //La suupression
	   RendezVous rendezVouss = rendezVousService.lirelesRendezVous(5);
	   if(rendezVouss != null) {
		   rendezVousService.supprimerlesrendezvous(5);
	   } 
	   else {
	       System.out.println("Ce rendez vous est introuvable !!!");
	   } 

	   
	    */
//--------------------------Traitement--------------------------------------------
  // La création
	 Traitement traitementt = new Traitement();
	 traitementt.setNom("xydole");  
	 traitementService.insererTraitement(traitementt);  
	   
	   
	  // L'affichage
	   Traitement traitementR = traitementService.lirelesTraitements(3);
	   if(traitementR != null) {
		   System.out.println("Traitement { "+ traitementR.getId()+ ", "+traitementR.getNom()+ "} ");
	   }
	   else {
	 	 System.out.println("Y'a pas de traitement trouvé a affiché");
	   } 
	   
	 
	// Update
	   Traitement traitementUp = traitementService.lirelesTraitements(10);
	   if(traitementUp != null) { 
		   traitementUp.setNom("Xydole1");  
		   traitementService.miseajourdestraitements(traitementUp); 
	   }
	   else {
	 	 System.out.println("y'a pas de traitemnt trouvé a supprimer ");
	   }  
	   
	}
	  


}


