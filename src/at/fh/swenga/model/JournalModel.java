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
@Table(name = "Journal")

public class JournalModel {
	
	@Id
	@Column(name = "textID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int textID;
	
	
	@Column(nullable = false, length = 100)
	private String headline;
	
	@Column(nullable = false, length = 300)
	private String text;

	public JournalModel() {
			
		};
	
	public JournalModel(int textID, User user, String headline, String text) {
		super();
		this.textID = textID;
		this.headline = headline;
		this.text = text;
	}

	public int getTextID() {
		return textID;
	}

	public void setTextID(int textID) {
		this.textID = textID;
	}

	

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
		JournalModel other = (JournalModel) obj;
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
		
		return true;
	}

	
	// 5. generate to string object
	
	@Override
	public String toString() {
		return "JournalModel [headline=" + headline + ", text=" + text + "]";
	}

}
