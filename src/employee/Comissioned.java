package employee;

import java.util.ArrayList;

import java.util.Scanner;

import sells.Sale;

public class Comissioned extends Salaried implements ChoiceEmployee{
	
	private double comission;
	private static ArrayList<Sale> salesList = new ArrayList<Sale>();
	private double acumulatedComission;

	public Comissioned(String name, String adress, int id, String paymentMethod, double salary, double comission, int sindicate) {
		super(name, adress, id, paymentMethod, salary, sindicate);
		this.comission = comission;
		this.setAcumulatedComission(0);
	}
	   
    public double getComission() {
        return this.comission;
    }
    
    public void setComission(double comission) {
        this.comission = comission;
    }
 
    public void postSale(int employeeId) {
    	 Scanner in = new Scanner(System.in);

         System.out.println("Informe a data da venda:");
         System.out.println("Utilize o formato dia/mês/ano");
         String date = in.nextLine();

         System.out.println("Informe o nome do produto:");
         String itemName = in.nextLine();

         System.out.println("Informe o valor do produto:");
         double value = in.nextDouble();
         
         this.setAcumulatedComission(this.getAcumulatedComission() + (this.comission * value));

         Sale sale = new Sale(date, value, itemName, employeeId);
         salesList.add(sale);
         
         System.out.println("Produto adicionado!");
         System.out.println(salesList.get(salesList.size() - 1).showSale(salesList.get(salesList.size() - 1)));

     }

	public double getAcumulatedComission() {
		return acumulatedComission;
	}

	public void setAcumulatedComission(double acumulatedComission) {
		this.acumulatedComission = acumulatedComission;
	}
	
	@Override
	public Employee choiceEmployee() {
		// TODO Auto-generated method stub
		return this;
	}
    
    

}
