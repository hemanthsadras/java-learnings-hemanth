package com.coderefactoring;

/*
 * This factory is responsible for giving the 
 * right PriceCalculator object based on book 
 * type
 */
public class PriceCalculatorFactory {

	public static BookRentalPriceCalculator getInstance(String bookType) {

		switch (bookType) {
		case BookType.FICTION:
			return new FictionBookPriceCalculator();
		case BookType.NON_FICTION:
			return new NonFictionBookPriceCalculator();
		case BookType.CHILDRENS:
			return new ChildBookPriceCalculator();
		default:
			throw new RuntimeException();
		}
	}

}
