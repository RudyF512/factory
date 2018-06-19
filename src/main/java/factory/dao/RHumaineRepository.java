package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import factory.model.Formateur;
import factory.model.Gestionnaire;
import factory.model.RHumaine;
import factory.model.Stagiaire;
import factory.model.Technicien;


public interface RHumaineRepository extends JpaRepository<RHumaine, Long> {

	@Query("select f from Formateur f")
	List<Formateur> findAllFormateur();
	
	@Query("select s from Stagiaire s")
	List<Stagiaire> findAllStagiaire();
	
	@Query ("select t from Technicien t")
	List<Technicien> findAllTechnicien();
	
	@Query("select g from Gestionnaire g")
	List<Gestionnaire> findAllGestionnaire();
	
	
}
