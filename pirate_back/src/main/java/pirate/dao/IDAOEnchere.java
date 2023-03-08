package pirate.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pirate.model.Enchere;

public interface IDAOEnchere extends JpaRepository<Enchere, Integer> {

	List<Enchere> findAllEnchereByCapitaine();

}
