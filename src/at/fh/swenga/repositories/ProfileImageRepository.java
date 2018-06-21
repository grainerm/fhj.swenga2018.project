package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.ProfileImage;


 
@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Integer> {
	
	@Transactional
	public ProfileImage findByCurrentUserName(String name);
}
