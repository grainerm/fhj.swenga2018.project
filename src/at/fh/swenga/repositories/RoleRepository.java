package at.fh.swenga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByBezeichnung(String bezeichnung);

}
