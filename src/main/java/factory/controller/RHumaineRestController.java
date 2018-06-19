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

import factory.dao.RHumaineRepository;
import factory.model.RHumaine;
import factory.model.Views;

@RestController
@RequestMapping("/rest/rhumaine")
@CrossOrigin(origins="*")
public class RHumaineRestController {
	
	@Autowired
	private RHumaineRepository rHumaineDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewRHumaine.class)
	public List<RHumaine> list() {
		return rHumaineDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewRHumaine.class)
	public RHumaine find(@PathVariable Long id) {
		Optional<RHumaine> ressource = rHumaineDao.findById(id);
		if(ressource.isPresent()) {
			return rHumaineDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewRHumaine.class)
	public void create(@RequestBody RHumaine ressource) {
		rHumaineDao.save(ressource);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewRHumaine.class)
	public void update(@RequestBody RHumaine ressource, @PathVariable Long id) {
		rHumaineDao.save(ressource);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewRHumaine.class)
	public void delete(@PathVariable Long id) {
		rHumaineDao.deleteById(id);
	}
	
	
	
	

}
