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

		Ordinateur ordi = new Ordinateur(1L, "152", 155L, true, "HP", "i5", 8, 200, "2008");

		Matiere matiere = new Matiere(2L, "Math2", 5, "Objectif 1", "bac +5", "Thales2, Pythagore2");

		Adresse adresse = new Adresse("2 rue des prairies", "75002", "Paris");
		Adresse adresse2 = new Adresse("55 rue des boulets", "75012", "Paris");
		Adresse adresse3 = new Adresse("85 rue gonet", "75020", "Paris");

		Technicien technicien = new Technicien(1L, "Hoyaux", "Vivien", "0145789625", "test@gmail.com", adresse);

		Adresse adresse1 = new Adresse("5 rue des roses", "75012", "Paris");

		Gestionnaire gestionnaire = new Gestionnaire(2L, "KUMAR", "Vikas", "01843505656", "Test1@gmail.com", adresse1);

		Stagiaire stagiaire = new Stagiaire(3L, "Jean", "Patrick", "0245978510", "vikvik@gmail.Com", adresse2, ordi,
				null);

		Formateur formateur = new Formateur(4L, "Gozlan", "Olivier", "0514594155", "Olivier@gmail.Com", adresse3, 5,
				LvlStagiaire.Avance, null, matieres);

		Date date = new Date();

		Module module = new Module(1L, date, date, null, matiere, formateur, null);

		Formation formation = new Formation(1L, "Energie", date, date, stagiaires, modules, formateur);

		modules.add(module);
		stagiaires.add(stagiaire);
		matieres.add(matiere);

		stagiaire.setFormation(formation);
		formateur.setFormations(formations);
		module.setFormateur(formateur);
		module.setFormations(formations);

		rMaterielleDao.save(ordi);
		rHumaineDao.save(stagiaire);
		rHumaineDao.save(technicien);
		rHumaineDao.save(gestionnaire);
		rHumaineDao.save(formateur);
		matiereDao.save(matiere);
		formationDao.save(formation);
		moduleDao.save(module);
	}

}
