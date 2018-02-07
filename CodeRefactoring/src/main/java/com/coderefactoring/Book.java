/**
 * 
 */
package com.coderefactoring;

import java.util.Date;

/**
 * Movie : Simple data class representing movie data.
 * 
 * @author hemanth
 *
 */
public class Book {

	private String bookCategory;
	private Date releaseDate;
	private BookRentalPriceCalculator priceCalculator;

	private long id;
	private String title;

	public Book(final String title, final String bookCategory, BookRentalPriceCalculator priceCalculator, final Date releaseDate) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
		this.priceCalculator = priceCalculator;
		this.releaseDate = releaseDate;
	}

	public Book(final String title, final String bookCategory) {
		this(title,bookCategory, PriceCalculatorFactory.getInstance(bookCategory), null);
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	public double getRentalPrice(int daysRented) {
		return this.priceCalculator.getPrice(daysRented);
	}
	
	public int getPoints(int daysRented) {
		return this.priceCalculator.getPointsAcquired(daysRented);
	}

}
