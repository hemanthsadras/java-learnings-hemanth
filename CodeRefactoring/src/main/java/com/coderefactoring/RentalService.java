package com.coderefactoring;

/**
 * This represents RentalService
 * 
 * @author hemants
 *
 */
public class RentalService {
	
	/**
	 * Fetch's bill statement for a given customer
	 * @param customer
	 * @return
	 */
	public String fetchStatement(Customer customer) {
		
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

		for (Rental rental : customer.getRentals()) {
			double thisAmount = rental.getRentalPrice();
			frequentRenterPoints += rental.getPoints();
			result.append("\t")
			      .append(rental.getBook().getTitle())
			      .append("\t").append(String.valueOf(thisAmount))
				  .append("\n");
			totalAmount += thisAmount;
		}

		result.append("Amount owed is ")
		      .append(String.valueOf(totalAmount)).append("\n");
		result.append("You earned ")
		      .append(String.valueOf(frequentRenterPoints))
		      .append(" frequent renter points");

		return result.toString();
	}

}
