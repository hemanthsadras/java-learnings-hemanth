package org.annotationtasks.models;

import java.time.LocalDate;

import com.annotationtasks.validationframwork.NotEmptyNotNull;

/**
 * Represents Pan card document
 * @author hemant kumar
 *
 */
public class PanCard {

	@NotEmptyNotNull
	private String firstname;
	
	@NotEmptyNotNull
	private String lastname;
	
	private LocalDate dateOfBirth;
	
	@NotEmptyNotNull
	private String panNumber;
	
	@NotEmptyNotNull
	private String fatherName;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

}
