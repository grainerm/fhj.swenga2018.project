package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
}
