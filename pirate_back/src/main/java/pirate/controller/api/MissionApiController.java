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
import pirate.dao.IDAOMission;
import pirate.exception.MissionBadRequestException;
import pirate.exception.MissionNotFoundException;
import pirate.model.Mission;
import pirate.request.MissionRequest;
import pirate.response.MissionResponse;

@RestController // Combinaison @Controller + @ResponseBody !
@RequestMapping("/api/mission")
@CrossOrigin("*") // J'autorise tout le monde
public class MissionApiController {
	@Autowired
	private IDAOMission daoMission;
	
	
	//Liste des missions
	@GetMapping
	@JsonView(Views.Mission.class)
	public List<Mission> findAll() {
		return this.daoMission.findAll();
	}
	
	
	//Find by Id
	@GetMapping("/{id}")
	public MissionResponse findById(@PathVariable int id) {
		
		Mission mission = this.daoMission.findById(id).orElseThrow(MissionNotFoundException::new);
		MissionResponse resp = new MissionResponse();
		
		BeanUtils.copyProperties(mission, resp);
		
		return resp;
	}
	
	
	
	//Ajouter mission
	@PostMapping
	@JsonView(Views.Mission.class)
	public Mission add(@RequestBody @Valid MissionRequest missionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MissionBadRequestException();
		}
		
		Mission mission = new Mission();
		
		BeanUtils.copyProperties(missionRequest, mission);
		
		return this.daoMission.save(mission);
	}
	
	
	//Modifier
	@PutMapping("/{id}")
	@JsonView(Views.Mission.class)
	public Mission edit(@PathVariable int id, @RequestBody @Valid MissionRequest missionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new MissionBadRequestException();
		}
		
		Mission mission = this.daoMission.findById(id).orElseThrow(MissionNotFoundException::new);
		
		BeanUtils.copyProperties(missionRequest, mission);
		
		return this.daoMission.save(mission);
	}
	
	
	//Suprrimer
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			
			if (!this.daoMission.existsById(id)) {
				throw new MissionNotFoundException();
			}
			
			this.daoMission.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}

}
