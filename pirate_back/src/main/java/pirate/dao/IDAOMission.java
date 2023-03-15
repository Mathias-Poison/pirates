package pirate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pirate.model.Mission;

public interface IDAOMission extends JpaRepository<Mission, Integer> {
	
	@Query("select m from Mission m LEFT JOIN fetch m.encheres where m.capitaine.id =?1")
	public List<Mission> findAllMissionByCapitaineId(int capitaine_id);
	
	@Query("select m from Mission m LEFT JOIN fetch m.encheres where m.client.id =?1")
	public List<Mission> findAllMissionByClientId(int client_id);
	
	@Query("select m from Mission m LEFT JOIN fetch m.encheres where m.bateau.id =?1")
	public List<Mission> findAllMissionByBateauId(int client_id);
	
}
