package refactoring.statement;

import java.util.List;

import refactoring.dto.Customer;
import refactoring.dto.Rental;

public abstract class Statement {
	public String value(Customer customer) {

		// 대여료와 적립포인트 출력
		StringBuilder sb = new StringBuilder();
		//header 출력
		sb.append(headerString(customer.getName()));
		//본문출력
		List<Rental> rentals = customer.getRentals();
		for (Rental each : rentals) {

			sb.append(eachRentalString(each));
		}// for loop
		
		//부터 출력
			sb.append(footerString(customer));
		return sb.toString();

	}
	
	
	protected abstract Object footerString(Customer customer);

	protected abstract Object eachRentalString(Rental each);

	protected abstract String headerString(String customerName);

}
