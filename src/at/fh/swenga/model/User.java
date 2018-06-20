package at.fh.swenga.model;

import java.util.Date;
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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "User")


public class User implements java.io.Serializable{
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;

	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Activity> activities;
	
	@Id
	@Column(name = "nickname")
	private String name;
	
	@Column(nullable = false, length = 30)
	private String vorname;
	
	@Column(nullable = false, length = 30)
	private String nachname;
	
	@Column(nullable = false, length = 255)
	private String passwort;
	
	@Column(nullable = false, length = 1)
	private boolean aktiv;
	
	@Column(nullable = true, length = 3)
	private int groesse;
	
	@Column(nullable = true, length = 3)
	private int gewicht;
	
	@Column(nullable = true, length = 3)
	private int zielgewicht;
	
	@Column(nullable = true)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date geburtstag;
	
	@Column(nullable = true, length = 1)
	private char geschlecht;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date regDate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String vorname, String nachname, String passwort, boolean aktiv, int groesse, int gewicht,
			int zielgewicht, Date geburtstag, char geschlecht, Date regDate) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.aktiv = aktiv;
		this.groesse = groesse;
		this.gewicht = gewicht;
		this.zielgewicht = zielgewicht;
		this.geburtstag = geburtstag;
		this.geschlecht = geschlecht;
		this.regDate = regDate;
	}
	
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public User(String name, String vorname, String nachname, String passwort, boolean aktiv, Date regDate) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.aktiv = aktiv;
		this.regDate = regDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public int getZielgewicht() {
		return zielgewicht;
	}

	public void setZielgewicht(int zielgewicht) {
		this.zielgewicht = zielgewicht;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
	

}
