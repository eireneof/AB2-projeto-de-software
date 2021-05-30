package employee;

import java.util.ArrayList;

import java.util.Scanner;

import itens.TimeCard;

public class Hourly extends Employee implements ChoiceEmployee{
	
	private double hourSalary;

    private ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();

    public Hourly(String name, String adress, int id, String paymentMethod, double hourSalary, int sindicate) {
        super(name, adress,id, paymentMethod, sindicate);
        this.setHourSalary(hourSalary);   
    }
    
    public int coutingHours() {
    	int count = 0;
    	for(TimeCard j : timeCards ) {
    		System.out.println("Data:" + j.getDate() + "\n Horas trabalhadas:" + j.getWorkedHours() + "\n \n");
    		count += j.getWorkedHours();
    	}    	
    	return count;
    }
      
    public void postTimeCard() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Obs: siga o seguinte formato para datas dia/ mês/ ano");
    	System.out.println("Obs2: utilize o formato de 24 horas");
    	
    	System.out.println("Informe a data de entrada:");
    	String date = in.nextLine();
    	
    	System.out.println("Informe o horário de chegada");
    	double inner = in.nextDouble();
    	
    	System.out.println("Informe o horário de saída");
    	double out = in.nextDouble();
    	
    	TimeCard timeCard = new TimeCard(inner, out, date);
    	timeCards.add(timeCard); 
    	
    }
    
	public double getHourSalary() {
		return hourSalary;
	}

	public void setHourSalary(double hourSalary) {
		this.hourSalary = hourSalary;
	}

	@Override
	public Employee choiceEmployee() {
		// TODO Auto-generated method stub
		return this;
	}
}
