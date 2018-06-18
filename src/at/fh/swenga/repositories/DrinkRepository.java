package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	
	@Transactional
	Drink findByItem(String item);
}
