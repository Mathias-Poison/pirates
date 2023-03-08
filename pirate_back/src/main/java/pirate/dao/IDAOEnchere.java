package pirate.dao;


import java.util.List;

import pirate.model.Enchere;

public interface IDAOEnchere extends IDAO<Enchere,Integer> {

	List<Enchere> findAllEnchereByCapitaine();

}
