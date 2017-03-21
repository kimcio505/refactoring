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
			frequentRanterPoints +=each.getfrequentRanterPoints();

			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getcharge()));
		} // for loop

		sb.append(String.format("누적대여료 : %s%n적립 포인트 : %s%n", getTotalCharge(), getTotalFrequentRanterPoints()));

		return sb.toString();

	}
	public String htmlStatement() {

		// 대여료와 적립포인트 출력

		StringBuilder sb = new StringBuilder();
		sb.append("<h1><em>"+getName() + "고객님의 대여기록</em></h1><p>\n");

		for (Rental each : rentals) {
			sb.append(String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>%n", each.getMovie().getTitle(), each.getcharge()));
		} // for loop

		sb.append(String.format("<p>누적대여료 : <em>%s</em>%n<p>적립 포인트 : <em>%s</em>%n", getTotalCharge(), getTotalFrequentRanterPoints()));

		return sb.toString();

	}

	private Object getTotalFrequentRanterPoints() {
		int result = 0;
		for (Rental each : rentals) {
			result += each.getfrequentRanterPoints();
		}
		return result;
	}

	private Object getTotalCharge() {
		double result = 0.0;
		for (Rental each : rentals) {
			result += each.getcharge();
		}
		return result;
	}

	private int getfrequentRanterPoints(Rental each) {
		return each.getfrequentRanterPoints();
	}

}












