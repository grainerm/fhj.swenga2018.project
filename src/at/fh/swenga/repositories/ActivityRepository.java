package at.fh.swenga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.model.Activity;
import at.fh.swenga.model.User;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	
	List<Activity> findByUser(User user);

	List<Activity> findByItemBezeichnung(String bezeichnung);

	List<Activity> findByUserName(String nickname);
}
