package pirate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pirate.model.Mission;

public interface IDAOMission extends JpaRepository<Mission, Integer> {
	
	
	
}
