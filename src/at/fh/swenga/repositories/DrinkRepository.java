package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Drink;

@Repository

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	
	@Transactional
	Drink findByDrinkItem(String item);
}
