package at.fh.swenga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Guestbook")

public class GuestbookModel implements java.io.Serializable  {
	
	@Id
	@Column(name = "entryID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entryID;
	

	/**@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;**/
	
	@Column(nullable = false, length = 20)
	private String headline;
	
	@Column(nullable = false, length = 300)
	private String text;
	
	
	
	public GuestbookModel() {
		
	}
	
	
	
	
	
	public GuestbookModel(int entryID, User user, String headline, String text) {
		super();
		this.entryID = entryID;
		//this.user = user;
		this.headline = headline;
		this.text = text;
	}





	public int getEntryID() {
		return entryID;
	}





	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}





	/*public User getUser() {
		return user;
	}*/





	/*public void setUser(User user) {
		this.user = user;
	}*/





	public String getHeadline() {
		return headline;
	}





	public void setHeadline(String headline) {
		this.headline = headline;
	}





	public String getText() {
		return text;
	}





	public void setText(String text) {
		this.text = text;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		//result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		GuestbookModel other = (GuestbookModel) obj;
		if (headline == null) {
			if (other.headline != null)
				return false;
		} else if (!headline.equals(other.headline))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		/*if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;*/
		return true;
	}

	
	// 5. generate to string object
	
	@Override
	public String toString() {
		return "GuestBookModel [ headline=" + headline + ", text=" + text + "]";
	}
	
}
