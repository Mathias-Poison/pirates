package pirate.controller.api;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;
import pirate.dao.IDAOBateau;
import pirate.exception.BateauBadRequestException;
import pirate.exception.BateauNotFoundException;
import pirate.model.Bateau;
import pirate.request.BateauRequest;
import pirate.response.BateauResponse;

@RestController // Combinaison @Controller + @ResponseBody !
@RequestMapping("/api/bateau")
@CrossOrigin("*") // J'autorise tout le monde
public class BateauApiController {
	@Autowired
	private IDAOBateau daoBateau;
	
	
	//Liste des bateaus
	@GetMapping
	@JsonView(Views.Bateau.class)
	public List<Bateau> findAll() {
		return this.daoBateau.findAll();
	}
	
	
	//Find by Id
	@GetMapping("/{id}")
	public BateauResponse findById(@PathVariable int id) {
		
		Bateau bateau = this.daoBateau.findById(id).orElseThrow(BateauNotFoundException::new);
		BateauResponse resp = new BateauResponse();
		
		BeanUtils.copyProperties(bateau, resp);
		
		return resp;
	}
		
	//Ajouter bateau
	@PostMapping
	@JsonView(Views.Bateau.class)
	public Bateau add(@RequestBody @Valid BateauRequest bateauRequest, BindingResult result) throws BateauBadRequestException {
		if (result.hasErrors()) {
			throw new BateauBadRequestException();
		}
		
		Bateau bateau = new Bateau();
		
		BeanUtils.copyProperties(bateauRequest, bateau);
		
		return this.daoBateau.save(bateau);
	}
	
	
	//Modifier
	@PutMapping("/{id}")
	@JsonView(Views.Bateau.class)
	public Bateau edit(@PathVariable int id, @RequestBody @Valid BateauRequest bateauRequest, BindingResult result) throws BateauBadRequestException {
		if (result.hasErrors()) {
			throw new BateauBadRequestException();
		}
		
		Bateau bateau = this.daoBateau.findById(id).orElseThrow(BateauNotFoundException::new);
		
		BeanUtils.copyProperties(bateauRequest, bateau);
		
		return this.daoBateau.save(bateau);
	}
	
	
	//Supprimer
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoBateau.existsById(id)) {
				throw new BateauNotFoundException();
			}
			
			this.daoBateau.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}

}
