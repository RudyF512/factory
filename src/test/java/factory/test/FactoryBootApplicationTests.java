package factory.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import factory.dao.FormationRepository;
import factory.dao.MatiereRepository;
import factory.dao.ModuleRepository;
import factory.dao.RHumaineRepository;
import factory.dao.RMaterielleRepository;
import factory.model.Adresse;
import factory.model.Formateur;
import factory.model.Formation;
import factory.model.Gestionnaire;
import factory.model.LvlStagiaire;
import factory.model.Matiere;
import factory.model.Module;
import factory.model.Ordinateur;
import factory.model.Salle;
import factory.model.Stagiaire;
import factory.model.Technicien;
import factory.model.VideoProj;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {

	@Autowired
	private RHumaineRepository rHumaineDao;

	@Autowired
	private RMaterielleRepository rMaterielleDao;

	@Autowired
	private MatiereRepository matiereDao;

	@Autowired
	private ModuleRepository moduleDao;

	@Autowired
	private FormationRepository formationDao;

	@Test
	public void contextLoads() {

		Set<Matiere> matieres = new HashSet<Matiere>();
		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		Set<Module> modules = new HashSet<Module>();
		Set<Formation> formations = new HashSet<Formation>();

		Ordinateur ordi = new Ordinateur("152", 155L, true, "HP", "i5", 8, 200, "2008");
		rMaterielleDao.save(ordi);
		Ordinateur ordi1 = new Ordinateur("243", 999L, true, "ASUS", "i7", 16, 1000, "2018");
		rMaterielleDao.save(ordi1);
		Salle salle = new Salle("Salle12",120L,true,"Saphir",15);
		rMaterielleDao.save(salle);
		VideoProj videoProj = new VideoProj("VideoProj17",70L,true,"Model X15", 1080,true,false);
		rMaterielleDao.save(videoProj);

		Matiere matiere = new Matiere("Math2", 5, "Objectif 1", "bac +5", "Thales2, Pythagore2");
		matiereDao.save(matiere);
		matieres.add(matiere);

		Adresse adresse = new Adresse("2 rue des prairies", "75002", "Paris");
		Adresse adresse1 = new Adresse("5 rue des roses", "75012", "Paris");
		Adresse adresse2 = new Adresse("55 rue des boulets", "75012", "Paris");
		Adresse adresse3 = new Adresse("85 rue gonet", "75020", "Paris");

		Technicien technicien = new Technicien("Hoyaux", "Vivien", "0145789625", "test@gmail.com", adresse);
		rHumaineDao.save(technicien);

		Gestionnaire gestionnaire = new Gestionnaire("KUMAR", "Vikas", "01843505656", "Test1@gmail.com", adresse1);
		rHumaineDao.save(gestionnaire);

		Stagiaire stagiaire = new Stagiaire("Jean", "Patrick", "0245978510", "vikvik@gmail.Com", adresse2, ordi, null);
		rHumaineDao.save(stagiaire);
		stagiaires.add(stagiaire);
		
		Stagiaire stagiaire1 = new Stagiaire("Thiago", "Lucas", "056464661", "testStagiaire@gmail.Com", adresse2, ordi1, null);
		rHumaineDao.save(stagiaire1);
		stagiaires.add(stagiaire1);

		System.out.println(stagiaires);
		
		Formateur formateur = new Formateur("Gozlan", "Olivier", "0514594155", "Olivier@gmail.Com", adresse3, 5,
				LvlStagiaire.Avance, null, matieres);
		rHumaineDao.save(formateur);

		Date date = new Date();

		Module module = new Module(date, date, null, matiere, formateur, null);
		moduleDao.save(module);
		modules.add(module);

		Formation formation = new Formation("Energie", date, date, modules, formateur);
		formationDao.save(formation);
		
		formation.getStagiaires().add(stagiaire);
		formation.getStagiaires().add(stagiaire1);
		formationDao.save(formation);
		stagiaire.setFormation(formation);
		stagiaire1.setFormation(formation);
		

		formateur.setFormations(formations);
		module.setFormateur(formateur);
		module.setFormations(formations);
		module.setSalle(salle);
		module.setMatiere(matiere);

		rHumaineDao.save(stagiaire);
		rHumaineDao.save(stagiaire1);
		rHumaineDao.save(formateur);
		matiereDao.save(matiere);
		formationDao.save(formation);
		moduleDao.save(module);
	}

}
