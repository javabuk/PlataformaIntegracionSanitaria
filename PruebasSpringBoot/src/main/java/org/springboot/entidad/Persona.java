package org.springboot.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Persons")
public class Persona {

	  // An autogenerated id (unique for each user in the db)
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column (name = "PersonID")
	  private int personID;
	  
	  // The user's email
	  @Column (name = "City", nullable = false)
	  private String city;
	  
	  @Column (name = "Address", nullable = false)
	  private String address;
	  
	  @Column (name = "FirstName", nullable = false)
	  private String firstName;
	  
	  @Column (name = "LastName", nullable = false)
	  private String lastName;
	  
	  public Persona() { }

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
