package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Sport;

@Repository

public interface SportRepository extends JpaRepository<Sport, Integer> {
	
	@Transactional
	Sport findBySportItem(String item);
}
