package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
	
	@Modifying
	@Query("delete from User u where u.name = :nickname")
	void deleteByName(@Param("nickname") String name);
}
