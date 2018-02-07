package com.coderefactoring;

public class FictionBookPriceCalculator implements BookRentalPriceCalculator {

	private double basePrice = 2.0;

	@Override
	public double getPrice(int daysRented) {
		if (daysRented > 2) {
			return (daysRented-2) * 1.5;
		}
		else {
			return basePrice;
		}
	}
	
	@Override
	public int getPointsAcquired(int daysRented) {
		if(daysRented > 2) {
			return 2;
		}
		else {
			return 1;
		}
	}

}
