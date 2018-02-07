/**
 * 
 */
package com.coderefactoring;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class that denotes customer details as well as customer related
 * operations.
 * 
 * @author hemanth
 *
 */
public class Customer {

	private long id;
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(final Rental rental) {
		getRentals().add(rental);
	}

}
