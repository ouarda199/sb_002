package dz.ibnrochd.master14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.service.PatientService;
import dz.ibnrochd.master14.service.ConsultationService;
import dz.ibnrochd.master14.service.LigneConsultationService;

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

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO : récupérer la liste de tous les patients puis afficher leurs noms
		patientService.Patients();
		
		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		patientService.PatientParNom("Yahi");
		
		
		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
		
		Patient patient = new Patient();
		patient.setNom("MAKHLOUF");
		patient.setPrenom("Ouarda");
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

        patientService.NouveauPatient(patient);
        
        

				
		// TODO : rechercher la consultation ayant id=3 
        consultationService.ConsultationParId(3);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
        ligneConsultationService.recupLigneConsultations();

        
		
	}

}
