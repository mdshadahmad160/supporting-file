package org.jsp.One2OneBy.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
@Entity

public class PanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private LocalDate dob;
	private int pincode;
	
	@OneToOne(mappedBy = "card",cascade = CascadeType.ALL)
	private Person p;
	

	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", number=" + number + ", dob=" + dob + ", pincode=" + pincode + ", p=" + p + "]";
	}
	

}
