package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Transactional
	Item findByBezeichnung(String bezeichnung);
}
