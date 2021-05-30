package employee;

import java.util.Scanner;

public enum StrategyEmployees {
	HOURLY{
		public ChoiceEmployee getChoiceEmployee(String name, String adress, int id, int sindicate, String paymentMethod) {
			Scanner in = new Scanner(System.in);
			System.out.println("Informe o sal�rio hor�rio:");
        	double salary = in.nextDouble();
        	return new Hourly(name, adress, id, paymentMethod, salary, sindicate);
		}
	}, 
	SALARIED{ 
		public ChoiceEmployee getChoiceEmployee(String name, String adress, int id, int sindicate, String paymentMethod) {
			Scanner in = new Scanner(System.in);
			System.out.println("Informe o sal�rio:");
        	double salary = in.nextDouble();
        	return new Salaried(name, adress, id, paymentMethod, salary, sindicate);
		}
	},
	COMISSIONED{
		public ChoiceEmployee getChoiceEmployee(String name, String adress, int id, int sindicate, String paymentMethod) {
			Scanner in = new Scanner(System.in);
			System.out.println("Informe a porcentagem de comiss�o:");
        	double percent = in.nextDouble();
        	System.out.println("Informe o sal�rio:");
        	double salary = in.nextDouble();
        	return new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);
		}
	};

	public abstract ChoiceEmployee getChoiceEmployee(String name, String adress, int id, int sindicate, String paymentMethod);
}
