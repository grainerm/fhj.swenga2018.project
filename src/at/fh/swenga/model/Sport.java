package at.fh.swenga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sport")

public class Sport implements java.io.Serializable {
	
	@Id
	@Column(name = "SportID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sportID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ItemID")
	private Item item;
	
	@Column(nullable = false, length = 3)
	private int dauer; //Minuten

	public Sport() {
		super();
	}

	public Sport(int dauer) {
		super();
		this.dauer = dauer;
	}
	public Sport(int dauer, Item item) {
		super();
		this.dauer = dauer;
		this.item = item;
	}
	public int getSportID() {
		return sportID;
	}

	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sportID;
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
		Sport other = (Sport) obj;
		if (sportID != other.sportID)
			return false;
		return true;
	}
	
	
	
	
	
	
}
