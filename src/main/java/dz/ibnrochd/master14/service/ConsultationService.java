package dz.ibnrochd.master14.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.ConsultationMapper;
import dz.ibnrochd.master14.model.Consultation;

@Service
public class ConsultationService {

	private final ConsultationMapper consultationMapper;

    @Autowired
    public ConsultationService(ConsultationMapper consultationMapper) {
        this.consultationMapper = consultationMapper;
    }
    
	public void ConsultationParId(int id) {
        List<Consultation> Id = consultationMapper.TrouverConsultationsParId(id);

        if (Id.isEmpty()) {
            System.out.println("Aucun résultat avec l'id '" + id + "'.");
        } else {
            System.out.println("La consultation dont l'id '" + id + "':");
           

            for (Consultation consultation : Id) {
            	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                 String Date_Consult = consultation.getDateConsult() != null ? dateFormat.format(consultation.getDateConsult()) : "";
                 System.out.println("Consultation{" +
                         consultation.getId() +
                        ", '" + consultation.getMotif() + 
                        ", " + Date_Consult+
                        '}');
            }
        }
    }
}
