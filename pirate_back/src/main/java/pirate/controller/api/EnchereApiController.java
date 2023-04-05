package pirate.controller.api;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;
import pirate.dao.IDAOEnchere;
import pirate.exception.EnchereBadRequestException;
import pirate.exception.EnchereNotFoundException;
import pirate.model.Enchere;
import pirate.model.Mission;
import pirate.model.Enchere;
import pirate.request.EnchereRequest;
import pirate.response.EnchereResponse;

@RestController
@RequestMapping("/api/enchere")
@CrossOrigin("*")
public class EnchereApiController {
	@Autowired
	private IDAOEnchere daoEnchere;
	
	//Liste des encheres et en os
	@GetMapping
	@JsonView(Views.Enchere.class)
	public List<Enchere> findAll() {
		List <Enchere> encheres= daoEnchere.findAll();
		
		for(Enchere e : encheres)
		{
			Hibernate.initialize(e.getMission());
		}		
		return encheres;
	}
	
	//Find by Id
	@GetMapping("/{id}")
	public EnchereResponse findById(@PathVariable int id) {
		
		Enchere enchere = this.daoEnchere.findById(id).orElseThrow(EnchereNotFoundException::new);
		EnchereResponse resp = new EnchereResponse();
		
		BeanUtils.copyProperties(enchere, resp);
		
		return resp;
	}
	
	//Ajouter enchere
	@PostMapping
	@JsonView(Views.Enchere.class)
	public Enchere add(@RequestBody @Valid EnchereRequest enchereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EnchereBadRequestException();
		}
		
		Enchere enchere = new Enchere();
		
		BeanUtils.copyProperties(enchereRequest, enchere);
		
		return this.daoEnchere.save(enchere);
	}
	
	//Modifier
	@PutMapping("/{id}")
	@JsonView(Views.Enchere.class)
	public Enchere edit(@PathVariable int id, @RequestBody @Valid EnchereRequest enchereRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EnchereBadRequestException();
		}
		
		Enchere enchere = this.daoEnchere.findById(id).orElseThrow(EnchereNotFoundException::new);
		
		BeanUtils.copyProperties(enchereRequest, enchere);
		
		return this.daoEnchere.save(enchere);
	}
	
	//Suprrimer
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoEnchere.existsById(id)) {
				throw new EnchereNotFoundException();
			}
			
			this.daoEnchere.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
}
