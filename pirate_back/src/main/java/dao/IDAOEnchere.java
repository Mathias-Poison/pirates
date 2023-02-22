package dao;


import java.util.List;

import model.Enchere;

public interface IDAOEnchere extends IDAO<Enchere,Integer> {

	List<Enchere> findAllEnchereByCapitaine();

}
