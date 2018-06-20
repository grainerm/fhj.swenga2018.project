package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Art;

public interface ArtRepository extends JpaRepository<Art, Integer> {
	
	@Transactional
	Art findByBezeichnung(String bezeichnung);
}
