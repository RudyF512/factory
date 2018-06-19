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

import factory.dao.ModuleRepository;
import factory.model.Module;
import factory.model.Views;

@RestController
@RequestMapping("/rest/module")
@CrossOrigin(origins="*")
public class ModuleRestController {

	@Autowired
	private ModuleRepository moduleDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewModule.class)
	public List<Module> list() {
		return moduleDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewModule.class)
	public Module find(@PathVariable Long id) {
		Optional<Module> matiere = moduleDao.findById(id);
		if(matiere.isPresent()) {
			return moduleDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewModule.class)
	public void create(@RequestBody Module matiere) {
		moduleDao.save(matiere);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewModule.class)
	public void update(@RequestBody Module matiere, @PathVariable Long id) {
		moduleDao.save(matiere);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewModule.class)
	public void delete(@PathVariable Long id) {
		moduleDao.deleteById(id);
	}
	
}
