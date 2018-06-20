package at.fh.swenga.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Art")

public class Art implements java.io.Serializable {

	@OneToMany(mappedBy="art", fetch=FetchType.EAGER)
	private Set<Item> items;
	
	@Id
	@Column(name = "ArtID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artID;
	
	@Column(nullable = false, length = 30)
	private String bezeichnung;
	
	public Art() {
		// TODO Auto-generated constructor stub
	}
	
	public Art(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}

	public int getArtID() {
		return artID;
	}

	public void setArtID(int artID) {
		this.artID = artID;
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
		result = prime * result + artID;
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
		Art other = (Art) obj;
		if (artID != other.artID)
			return false;
		return true;
	}
	
	
	
}
