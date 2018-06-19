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
import factory.model.Stagiaire;
import factory.model.Technicien;

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
		
		Ordinateur ordi = new Ordinateur(1L,"152",155L,true,"HP","i5",8,200,"2008");
		rMaterielleDao.save(ordi);
		
		Matiere matiere = new Matiere(2L,"Math2",5,"Objectif 1","bac +5","Thales2, Pythagore2");
		matiereDao.save(matiere);
		
		Set<Matiere> matieres = new HashSet<Matiere>();
		matieres.add(matiere);
		
		Adresse adresse = new Adresse("2 rue des prairies", "75002", "Paris");
		
		Technicien t = new Technicien(1L,"Hoyaux","Vivien","0145789625","test@gmail.com",adresse);
		rHumaineDao.save(t);
		
		Adresse adresse1 = new Adresse("5 rue des roses", "75012", "Paris");
		
		Gestionnaire g = new Gestionnaire(2L, "KUMAR", "Vikas", "01843505656", "Test1@gmail.com", adresse1);
		rHumaineDao.save(g);
		
		Adresse adresse2 = new Adresse("55 rue des boulets", "75012", "Paris");
		
		Stagiaire stagiaire = new Stagiaire(3L,"Jean","Patrick","0245978510","vikvik@gmail.Com",adresse2,ordi,null);
		rHumaineDao.save(stagiaire);
		
		Adresse adresse3 = new Adresse("85 rue gonet", "75020", "Paris");
		
		Formateur formateur = new Formateur(4L, "Gozlan", "Olivier", "0514594155", "Olivier@gmail.Com", adresse3, 5, LvlStagiaire.Avance, null, matieres);
		rHumaineDao.save(formateur);
		
		Date date = new Date();
		
		Module module = new Module(1L, date, date, null, matiere, formateur, null);
		moduleDao.save(module);
		
		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		stagiaires.add(stagiaire);
		
		Set<Module> modules= new HashSet<Module>();
		modules.add(module);
		
		Formation formation = new Formation(1L, "Energie", date, date, stagiaires, modules, formateur);
		formationDao.save(formation);
		
		
	}

}

