package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i ++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			if(c == 'i') {
				System.out.print("Health expenditures: ");
				list.add(new Individual(name, anualIncome, sc.nextDouble()));
			}else {
				System.out.print("Number of employees: ");
				list.add(new Company(name, anualIncome, sc.nextInt()));
			}
		}
			
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0.0;
		
		for(TaxPayer taxPayer : list) {
			System.out.println(taxPayer.toString());
			sum += taxPayer.tax();
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));	
		
		sc.close();
	}
}
