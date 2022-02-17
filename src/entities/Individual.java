package entities;

public class Individual extends TaxPayer{

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		
		if(getAnualIncome() < 2000) {
			if(healthExpenditures != null) {
				return (0.15 * getAnualIncome()) - (0.5 * healthExpenditures);
			}
			else {
				return (0.15 * getAnualIncome());
			}
		}
		else {
			if(healthExpenditures != null) {
				return (0.25 * getAnualIncome()) - (0.5 * healthExpenditures);
			}
			else {
				return (0.25 * getAnualIncome());
			}
		}
	}
	
	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", tax());
	}

}
