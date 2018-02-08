package org.annotationtasks.models;

import java.time.LocalDate;

import com.annotationtasks.validationframwork.NotEmptyNotNull;

/**
 * Represents Aadhar card document
 * @author hemanth kumar
 *
 */
public class Aadharcard {

	@NotEmptyNotNull
	private String firstname;
	
	@NotEmptyNotNull
	private String lastname;
	
	private LocalDate dateOfBirth;
	
	@NotEmptyNotNull
	private String aadharId;
	
	@NotEmptyNotNull
	private String address;

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

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
