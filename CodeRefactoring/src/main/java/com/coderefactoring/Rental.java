/**
 * 
 */
package com.coderefactoring;

/**
 * Represent a customer renting a book.
 * 
 * @author hemanth
 *
 */
public class Rental  {

	private Book book;

	private int daysRented;

	public Rental(Book book, int daysRented) {
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	
	public double getRentalPrice() {
		return book.getRentalPrice(daysRented);
	}
	
	public int getPoints() {
		return book.getPoints(daysRented);
	}

}
