package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Food;
import at.fh.swenga.model.Item;


public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	@Transactional
	Food findByItemBezeichnung(String bezeichnung);
}