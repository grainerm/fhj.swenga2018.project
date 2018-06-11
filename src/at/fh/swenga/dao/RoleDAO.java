package at.fh.swenga.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Role;

@Repository
@Transactional
public class RoleDAO 
{
	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<Role> getRoles() {
		TypedQuery<Role> typedQuery = entityManager.createQuery("select r from Role r",
				Role.class);
		List<Role> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
 
	public Role getRole(int id) throws DataAccessException {
		return entityManager.find(Role.class, id);
	}
 
	public void persist(Role Role) {
		entityManager.persist(Role);
	}
 
	public Role merge(Role Role) {
		return entityManager.merge(Role);
	}
 
	public void delete(Role Role) {
		entityManager.remove(Role);
	}
 
	public int deleteAllRoles() {
		int count = entityManager.createQuery("DELETE FROM Role").executeUpdate();
		return count;
	}
 
	public void delete(int id) {
		Role Role = getRole(id);
		if (Role != null)
			delete(Role);
	}
}
