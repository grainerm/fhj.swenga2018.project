package at.fh.swenga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	
	@Modifying
	@Transactional
	@Query("delete from Item i where i.bezeichnung = :bezeichnung")
	void deleteByName(@Param("bezeichnung") String bezeichnung);
	
	@Transactional
	@Query("SELECT i FROM Item i WHERE i.validiert = false")
	List<Item> findByValidiertFalse();

	@Transactional
	List<Item> findByBezeichnung(String bezeichnung);
}