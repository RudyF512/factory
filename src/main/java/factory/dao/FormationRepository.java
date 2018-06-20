package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Formation;
import factory.model.Stagiaire;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    @Query("select distinct formation from Formation formation left join fetch formation.modules")
    List<Formation> findAllWithEagerRelationships();

    @Query("select formation from Formation formation left join fetch formation.modules where formation.id =:id")
    Formation findOneWithEagerRelationships(@Param("id") Long id);
    
//    @Query("select distinct e from Formation e left join fetch e.stagiaire s")
//    List<Stagiaire> findAllStagiairesByFormation();

}
