package com.coderefactoring;

public class ChildBookPriceCalculator implements BookRentalPriceCalculator {

	private double basePrice = 1.5;
	
	@Override
	public double getPrice(int daysRented) {
		
		if(daysRented > 3) {
			return (daysRented-3) * 1.5;
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
