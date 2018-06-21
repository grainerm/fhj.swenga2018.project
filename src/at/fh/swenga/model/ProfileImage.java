package at.fh.swenga.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
 
@Entity
@Table(name = "ProfileImage")
public class ProfileImage implements java.io.Serializable {
 
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nickname", nullable = false)
	private User currentUser;
 
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "img")
	private byte[] img;

	public ProfileImage() {
		super();
	}

	public ProfileImage(int id, String name, String type, User currentUser, byte[] img) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.currentUser = currentUser;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		ProfileImage other = (ProfileImage) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}

