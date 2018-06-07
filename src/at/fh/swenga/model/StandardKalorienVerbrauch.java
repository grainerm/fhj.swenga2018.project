package at.fh.swenga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SKV")

public class StandardKalorienVerbrauch implements java.io.Serializable {
	
	@Id
	@Column(name = "SkvID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skvID;
	
	@Column(nullable = false, length = 1)
	private char geschlecht;
	
	@Column(nullable = false, length = 6)
	private int kalorien;
	
	@Column(nullable = false, length = 2)
	private int vonAlter;
	
	@Column(nullable = false, length = 2)
	private int bisAlter;
	
	@Column(nullable = false, length = 2)
	private int vonGroesse;
	
	@Column(nullable = false, length = 2)
	private int bisGroesse;

	public StandardKalorienVerbrauch(int skvID, char geschlecht, int kalorien, int vonAlter, int bisAlter,
			int vonGroesse, int bisGroesse) {
		super();
		this.skvID = skvID;
		this.geschlecht = geschlecht;
		this.kalorien = kalorien;
		this.vonAlter = vonAlter;
		this.bisAlter = bisAlter;
		this.vonGroesse = vonGroesse;
		this.bisGroesse = bisGroesse;
	}

	public int getSkvID() {
		return skvID;
	}

	public void setSkvID(int skvID) {
		this.skvID = skvID;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public int getKalorien() {
		return kalorien;
	}

	public void setKalorien(int kalorien) {
		this.kalorien = kalorien;
	}

	public int getVonAlter() {
		return vonAlter;
	}

	public void setVonAlter(int vonAlter) {
		this.vonAlter = vonAlter;
	}

	public int getBisAlter() {
		return bisAlter;
	}

	public void setBisAlter(int bisAlter) {
		this.bisAlter = bisAlter;
	}

	public int getVonGroesse() {
		return vonGroesse;
	}

	public void setVonGroesse(int vonGroesse) {
		this.vonGroesse = vonGroesse;
	}

	public int getBisGroesse() {
		return bisGroesse;
	}

	public void setBisGroesse(int bisGroesse) {
		this.bisGroesse = bisGroesse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skvID;
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
		StandardKalorienVerbrauch other = (StandardKalorienVerbrauch) obj;
		if (skvID != other.skvID)
			return false;
		return true;
	}
	
	
	
	
}
