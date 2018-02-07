package com.coderefactoring;

public class NonFictionBookPriceCalculator implements BookRentalPriceCalculator {

	private double basePrice = 0.0;
	
	@Override
	public double getPrice(int daysRented) {
		
		if(daysRented > 3) {
			return daysRented * 3;
		}
		else {
			return basePrice;
		}
	}
	
	@Override
	public int getPointsAcquired(int daysRented) {
		return 1;
	}

}
