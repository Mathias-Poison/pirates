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
import pirate.dao.IDAOCompte;
import pirate.exception.CompteBadRequestException;
import pirate.exception.CompteNotFoundException;
import pirate.model.Admin;
import pirate.model.Capitaine;
import pirate.model.Client;
import pirate.model.Compte;
import pirate.request.CompteRequest;
import pirate.response.CompteResponse;

@RestController // Combinaison @Controller + @ResponseBody !
@RequestMapping("/api/compte")
@CrossOrigin("*") // J'autorise tout le monde
public class CompteApiController {
	@Autowired
	private IDAOCompte daoCompte;
	
	
	//Liste des comptes
	@GetMapping
	@JsonView(Views.Compte.class)
	public List<Compte> findAll() {
		return this.daoCompte.findAll();
	}
	
	//liste des capitaines 
	@GetMapping("/capitaine")
	@JsonView(Views.Compte.class)
	public List<Capitaine> findAllCapitaine() {
		return this.daoCompte.findAllCapitaine();
	}
	
	
	//liste des clients
	@GetMapping("/client")
	@JsonView(Views.Compte.class)
	public List<Client> findAllClient() {
		return this.daoCompte.findAllClient();
	}
	
	
	
	//Find by Id
	@GetMapping("/{id}")
	public CompteResponse findById(@PathVariable int id) {
		
		Compte compte = this.daoCompte.findById(id).orElseThrow(CompteNotFoundException::new);
		CompteResponse resp = new CompteResponse();
		
		BeanUtils.copyProperties(compte, resp);
		
		return resp;
	}
	
	//find by login et password(pour se connecter)
	@GetMapping("/connexion")
	public Compte findByLoginAndPassword (@Valid @RequestParam String login, @Valid @RequestParam String password, BindingResult result)
	{ 
		if (result.hasErrors()) 
		{throw new CompteNotFoundException();}
		Compte compte = this.daoCompte.findByLoginAndPassword(login, password);		
		return compte;
	}
	
	
	
	//Ajouter 
	@PostMapping
	@JsonView(Views.Compte.class)
	public Compte add(@RequestBody @Valid CompteRequest compteRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CompteBadRequestException();
		}
		
		if(compteRequest.getType_compte().equals("capitaine"))
		{
			Capitaine compte = new Capitaine();
			BeanUtils.copyProperties(compteRequest, compte);
			return this.daoCompte.save(compte);
			
		}
		else if(compteRequest.getType_compte().equals("client")) {
			Client compte = new Client();
			BeanUtils.copyProperties(compteRequest, compte);
			return this.daoCompte.save(compte);
		}
		else if (compteRequest.getType_compte().equals("admin")) {
			Admin compte = new Admin();
			BeanUtils.copyProperties(compteRequest, compte);
			return this.daoCompte.save(compte);
		}
		else {
			new CompteBadRequestException();
		}
		
		return null;
			
	}
	
	
	//Modifier
	@PutMapping("/{id}")
	@JsonView(Views.Compte.class)
	public Compte edit(@PathVariable int id, @RequestBody @Valid CompteRequest compteRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CompteBadRequestException();
		}
		
		Compte compte = this.daoCompte.findById(id).orElseThrow(CompteNotFoundException::new);
		
		BeanUtils.copyProperties(compteRequest, compte);
		
		return this.daoCompte.save(compte);
	}
	
	
	//Suprrimer
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoCompte.existsById(id)) {
				throw new CompteNotFoundException();
			}
			
			this.daoCompte.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}

}
