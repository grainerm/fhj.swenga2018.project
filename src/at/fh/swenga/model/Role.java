package at.fh.swenga.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")


public class Role implements java.io.Serializable{ 
	
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private Set<User> users;
	
	@Id
	@Column(name = "RoleID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	
	private String bezeichnung;

	public Role(int roleID, String bezeichnung) {
		super();
		this.roleID = roleID;
		this.bezeichnung = bezeichnung;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleID != other.roleID)
			return false;
		return true;
	}
	
	

}
