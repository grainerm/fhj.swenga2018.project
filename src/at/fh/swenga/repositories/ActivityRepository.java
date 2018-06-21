package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.model.Activity;
import at.fh.swenga.model.User;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	
	Activity findByUser(User user);

}
