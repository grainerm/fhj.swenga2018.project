package at.fh.swenga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.StandardKalorienVerbrauch;


public interface StandardKalorienVerbrauchRepository extends JpaRepository<StandardKalorienVerbrauch, Integer> {

	@Transactional
	
	StandardKalorienVerbrauch findByBisAlterGreaterThan(int alter);

	List<StandardKalorienVerbrauch> findByGeschlecht(char geschlecht);
	
	StandardKalorienVerbrauch findBySkvID(int skvID);
}
