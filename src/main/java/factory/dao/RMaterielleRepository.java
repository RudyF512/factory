package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import factory.model.Ordinateur;
import factory.model.RMaterielle;
import factory.model.Salle;
import factory.model.VideoProj;


public interface RMaterielleRepository extends JpaRepository<RMaterielle, Long> {

	@Query("select o from Ordinateur o")
	List<Ordinateur> findAllOrdinateur();
	
	@Query("select s from Salle s")
	List<Salle> findAllSalle();
	
	@Query ("select v from VideoProj v")
	List<VideoProj> findAllVideoProj();
	
}
