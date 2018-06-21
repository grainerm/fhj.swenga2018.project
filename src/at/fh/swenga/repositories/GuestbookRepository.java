package at.fh.swenga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.GuestbookModel;

public interface GuestbookRepository extends JpaRepository<GuestbookModel, Integer> {
	
	@Transactional
	GuestbookModel findByHeadline(String headline);
	
}