package at.fh.swenga.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
	
	Optional<User> findFirstByName(String name);
}
