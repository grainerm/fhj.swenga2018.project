package at.fh.swenga.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")

public class Item implements java.io.Serializable {

	@OneToMany(mappedBy="item", fetch=FetchType.EAGER)
	private Set<Activity> activities;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Art art;
	
	@OneToOne(mappedBy = "item")
	private Sport sport;
	
	@OneToOne(mappedBy = "item")
	private Food food;
	
	@OneToOne(mappedBy = "item")
	private Drink drink;
	
	@Id
	@Column(name = "ItemID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemID;
	
	@Column(nullable = false, length = 30)
	private String bezeichnung;
	
	@Column(nullable = false, length = 6)
	private int kalorien;
	
	

	public Item(int itemID, String bezeichnung, int kalorien) {
		super();
		this.itemID = itemID;
		this.bezeichnung = bezeichnung;
		this.kalorien = kalorien;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getKalorien() {
		return kalorien;
	}

	public void setKalorien(int kalorien) {
		this.kalorien = kalorien;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
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
		Item other = (Item) obj;
		if (itemID != other.itemID)
			return false;
		return true;
	}
	

}
