package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.LigneConsultation;


@Mapper
public interface LigneConsultationMapper {
	List<LigneConsultation> AfficherTousLigneConsultation();
	
	void creerLigneConsultation(LigneConsultation ligneConsultation);
	LigneConsultation lireLigneConsultation( int id);
	void miseajourligneconsultation(LigneConsultation ligneConsultation);
	void supprimerligneconsultation(int id);
	
	
	List<LigneConsultation>consultationbyid(int cons_id);
	List<LigneConsultation>traitementbyid(int traitm_id);
	
	
}
