package pirate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pirate.model.Bateau;

public interface IDAOBateau extends JpaRepository<Bateau, Integer> {

	}