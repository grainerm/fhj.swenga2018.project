package at.fh.swenga.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.User;

@Repository
@Transactional
public class UserDAO 
{
	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<User> getUsers() {
		TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u",
				User.class);
		List<User> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
 
	public User getUser(String nickname) throws DataAccessException {
		return entityManager.find(User.class, nickname);
	}
 
	public void persist(User user) {
		entityManager.persist(user);
	}
 
	public User merge(User user) {
		return entityManager.merge(user);
	}
 
	public void delete(User user) {
		entityManager.remove(user);
	}
 
	public int deleteAllusers() {
		int count = entityManager.createQuery("DELETE FROM User").executeUpdate();
		return count;
	}
 
	public void delete(String nickname) {
		User user = getUser(nickname);
		if (user != null)
			delete(user);
	}

}
