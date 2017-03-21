package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

import refactoring.statement.HtmlStatement;
import refactoring.statement.Statement;
import refactoring.statement.TextStatement;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String statement() {
		Statement stmt = new TextStatement();
		return stmt.value(this);
	}

	public String htmlStatement() {
		Statement stmt = new HtmlStatement();
		return stmt.value(this);
	}

	public Object getTotalFrequentRanterPoints() {
		int result = 0;
		for (Rental each : rentals) {
			result += each.getfrequentRanterPoints();
		}
		return result;
	}

	public Object getTotalCharge() {
		double result = 0.0;
		for (Rental each : rentals) {
			result += each.getcharge();
		}
		return result;
	}

	public int getfrequentRanterPoints(Rental each) {
		return each.getfrequentRanterPoints();
	}

}
