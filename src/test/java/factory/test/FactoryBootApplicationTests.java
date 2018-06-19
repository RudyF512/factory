package factory.test;

import java.util.Date;
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
import factory.model.Adresse;
import factory.model.Formateur;
import factory.model.Formation;
import factory.model.Gestionnaire;
import factory.model.LvlStagiaire;
import factory.model.Matiere;
import factory.model.Module;
import factory.model.Stagiaire;
import factory.model.Technicien;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {
	
	@Autowired
	private RHumaineRepository rHumaineDao; 
	
	@Autowired
	private MatiereRepository matiereDao; 
	
	@Autowired
	private ModuleRepository moduleDao;
	
	@Autowired
	private FormationRepository formationDao;
	

	@Test
	public void contextLoads() {
		
		Matiere m = new Matiere(1L,"Math",5,"Objectif 1","bac +5","Thales, Pythagore");
		matiereDao.save(m);
		
//		Adresse a = new Adresse("2 rue des prairies", "75002", "Paris");
//		
//		Technicien t = new Technicien(1L,"Hoyaux","Vivien","0145789625","test@gmail.com",a);
//		rHumaineDao.save(t);
		
//		Adresse a1 = new Adresse("5 rue des roses", "75012", "Paris");
//		
//		Gestionnaire g = new Gestionnaire(2L, "KUMAR", "Vikas", "01843505656", "Test1@gmail.com", a1);
//		rHumaineDao.save(g);
//		
//		Adresse a2 = new Adresse("55 rue des boulets", "75012", "Paris");
//		
//		Stagiaire s = new Stagiaire(3L,"Jean","Patrick","0245978510","vikvik@gmail.Com",a2,null,null);
//		rHumaineDao.save(s);
//		
//		Adresse a3 = new Adresse("85 rue gonet", "75020", "Paris");
//		
//		Formateur formateur = new Formateur(4L, "Gozlan", "Olivier", "0514594155", "Olivier@gmail.Com", a3, 5, LvlStagiaire.Avance, null, null);
//		rHumaineDao.save(formateur);
//		
//		Date d = new Date();
//		
//		Module ma = new Module(1L, d, d, null, m, formateur, null);
//		moduleDao.save(ma);
//		
//		Set<Stagiaire> stagiaire = null;
//		stagiaire.add(s);
//		
//		Set<Module> module= null;
//		module.add(ma);
//		
//		Formation formation = new Formation(1L, "Energie", d, d, stagiaire, module, formateur);
//		formationDao.save(formation);
		
		
	}

}
