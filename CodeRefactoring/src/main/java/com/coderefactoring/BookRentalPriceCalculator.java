package com.coderefactoring;

/*
 * This represents PriceCalculator for a book type
 */
public interface BookRentalPriceCalculator {
	double getPrice(int daysRented);
	int getPointsAcquired(int daysRented);
}
