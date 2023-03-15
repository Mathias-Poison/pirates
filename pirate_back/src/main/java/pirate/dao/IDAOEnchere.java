package pirate.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pirate.model.Enchere;

public interface IDAOEnchere extends JpaRepository<Enchere, Integer> {

	@Query("select e from Enchere e where capitaine.id = ?1")
	List<Enchere> findAllEnchereByCapitaine(int id);
	
}
