package entities;

public class Company extends TaxPayer{

	private int numberOfEmployees;

	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if(numberOfEmployees > 10) {
			return (0.14 * getAnualIncome());
		}
		else {
			return (0.16 * getAnualIncome());
		}

	}

	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", tax());
	}
	
}
