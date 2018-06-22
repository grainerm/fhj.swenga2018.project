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
@Table(name = "Food")

public class Food implements java.io.Serializable {
	@Id
	@Column(name = "FoodID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ItemID")
	private Item item;
	
	@Column(nullable = false, length = 3)
	private int menge; //Gramm

	public Food(int menge) {
		super();
		this.menge = menge;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
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
		result = prime * result + foodID;
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
		Food other = (Food) obj;
		if (foodID != other.foodID)
			return false;
		return true;
	}

	public Food(Item item, int menge) {
		super();
		this.item = item;
		this.menge = menge;
	}

	public Food() {
		// TODO Auto-generated constructor stub
	}
	
}