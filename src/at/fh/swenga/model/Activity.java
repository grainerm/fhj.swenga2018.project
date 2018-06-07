package at.fh.swenga.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Activity")

public class Activity implements java.io.Serializable {

	@Id
	@Column(name = "AID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aID;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date datum;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Item item;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
}
