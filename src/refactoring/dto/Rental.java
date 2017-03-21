package refactoring.dto;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getcharge() {
		// 비디오물당 대여료
		// 1.일반물(2일)2000원,일일초과당1500원,적립1
		// 2.아동물(3일)1500원,일일초과당1500,적립1
		// 3.최신물(1일)3000원, 일일초과 3000,적립1+1
		double result = 0;
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			result = 2000;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1500;
			}
			break;
		case Movie.NEW_RELEASE:
			result = daysRented * 3000;
			break;
		case Movie.CHILDREN:
			result = 1500;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1500;
			}
			break;
		}
		return result;
	}

	public int getfrequentRanterPoints() {

		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}












