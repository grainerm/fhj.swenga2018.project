package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Item;


public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	
	@Transactional
	Drink findByItemBezeichnung(String bezeichnung);
}