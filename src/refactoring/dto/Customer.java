package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

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

	public String statement() {

		// 대여료와 적립포인트 출력

		double totalAmount = 0;// 총대여료
		int frequentRanterPoints = 0;// 적립포인트

		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");

		for (Rental each : rentals) {
			frequentRanterPoints += getfrequentRanterPoints(each);

			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getcharge()));

			totalAmount += each.getcharge();
		} // for loop

		sb.append(String.format("누적대여료 : %s%n적립 포인트 : %s%n", totalAmount, frequentRanterPoints));

		return sb.toString();

	}

	private int getfrequentRanterPoints(Rental each) {
		return each.getfrequentRanterPoints();
	}

}












