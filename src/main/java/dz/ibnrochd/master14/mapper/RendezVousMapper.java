package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.RendezVous;

@Mapper
public interface RendezVousMapper {
	
	//List<RendezVous> selectAllRendezVous();
	void creerRendezVous(RendezVous rendezvous);
	RendezVous lireRendezVous(int id);
	void miseajourpatientrendezvous(RendezVous rendezVous);
	void supprimerrendezvous(int id);
		
	List<RendezVous> PatientId(int patient_id);
}
