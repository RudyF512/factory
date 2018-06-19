package formation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factory.dao.MatiereRepository;
import factory.dao.RHumaineRepository;
import factory.model.Matiere;
import factory.model.RHumaine;
import factory.model.Stagiaire;
import factory.model.Technicien;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {
	
	@Autowired
	private RHumaineRepository rHumaineDao; 
	
	@Autowired
	private MatiereRepository matiereDao; 
	

	@Test
	public void contextLoads() {
		
		Matiere m = new Matiere(1L,"Math",5,"Objectif 1","bac +5","Thales, Pythagore");
		matiereDao.save(m);
		
		RHumaine t = new Technicien();
		
//		Matiere jpa = new Matiere("JPA",Complexite.FACILE, new Date(), new Date());
//		
//		matiereDao.save(jpa);
		
	}

}
