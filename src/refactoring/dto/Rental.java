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
		return movie.getcharge(daysRented);
	}

	public int getfrequentRanterPoints() {
		return movie.getfrequentRanterPoints(daysRented);
	}
}












