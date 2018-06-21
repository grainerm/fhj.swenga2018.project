package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.JournalModel;

public interface JournalRepository extends JpaRepository<JournalModel, Integer> {
	
	@Transactional
	JournalModel findByHeadline(String headline);
	

}
