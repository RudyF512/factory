package factory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import factory.dao.RMaterielleRepository;
import factory.model.RMaterielle;
import factory.model.Views;

@RestController
@RequestMapping("/rest/rmaterielle")
@CrossOrigin(origins="*")
public class RMaterielleRestController {
	
	@Autowired
	private RMaterielleRepository rMaterielleDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewRMaterielle.class)
	public List<RMaterielle> list() {
		return rMaterielleDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewRMaterielle.class)
	public RMaterielle find(@PathVariable Long id) {
		Optional<RMaterielle> ressource = rMaterielleDao.findById(id);
		if(ressource.isPresent()) {
			return rMaterielleDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewRMaterielle.class)
	public void create(@RequestBody RMaterielle ressource) {
		rMaterielleDao.save(ressource);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewRMaterielle.class)
	public void update(@RequestBody RMaterielle ressource, @PathVariable Long id) {
		rMaterielleDao.save(ressource);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewRMaterielle.class)
	public void delete(@PathVariable Long id) {
		rMaterielleDao.deleteById(id);
	}
	
	
	
	

}
