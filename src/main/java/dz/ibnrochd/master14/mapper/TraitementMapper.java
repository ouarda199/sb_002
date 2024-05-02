package dz.ibnrochd.master14.mapper;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Traitement;

@Mapper
public interface TraitementMapper {
	void creertraitement(Traitement traitement);
	Traitement lireTraitement( int id);
	void miseajourtraitemnt(Traitement traitement);
	void supprimertraitement(int id);

}
