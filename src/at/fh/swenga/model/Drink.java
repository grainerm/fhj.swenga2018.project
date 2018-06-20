package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Drink")

public class Drink implements java.io.Serializable {
	
	@Id
	@Column(name = "DrinkID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drinkID;
	
	@OneToOne
	@JoinColumn(name = "ItemID")
	private Item item;
	
	@Column(nullable = false, length = 3)
	private int menge; //milliLiter

	
	public Drink(Item item, int menge) {
		super();
		this.item = item;
		this.menge = menge;
	}

	public int getDrinkID() {
		return drinkID;
	}

	public void setDrinkID(int drinkID) {
		this.drinkID = drinkID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drinkID;
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
		Drink other = (Drink) obj;
		if (drinkID != other.drinkID)
			return false;
		return true;
	}

	public Drink(int drinkID, Item item, int menge) {
		super();
		this.drinkID = drinkID;
		this.item = item;
		this.menge = menge;
	}
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}
	

}
