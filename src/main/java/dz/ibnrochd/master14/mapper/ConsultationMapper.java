package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Consultation;

@Mapper
public interface ConsultationMapper {
	
	List<Consultation> TrouverConsultationsParId(int id);
	
	void creerConsultation(Consultation consultation);
	Consultation lireConsultation(int id);
	void miseajourconsultation(Consultation consultation);
	void supprimerconsultation(int id);
	
	
List<Consultation> findConsultationsById(int id);
	
List<Consultation> PatientId(int patient_id);
	
}
