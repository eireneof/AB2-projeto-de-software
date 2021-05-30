package main;

import java.util.Scanner;

import employee.Employee;
import employee.Sindicate;
import utils.HistoricComands;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        HistoricComands comando = new HistoricComands();
        Text mainText = new Text();
        int commandVerify;
        mainText.firstContact();
        mainText.showCommands();
        
        Sindicate sindicate = new Sindicate();
        Employee employee = new Employee();
        
        do {
        	commandVerify = scanner.nextInt();
        	
        	if (commandVerify != 8 && commandVerify != 0 && commandVerify != 11)
        		comando.setCurrent(commandVerify);
        	
        	int option;
        	 
            
            switch(commandVerify) {
            	case 0:
            		mainText.showCommands();
            		break;
                case 1:
                    System.out.println("Adição de um empregado");
                    employee.add();
                    break;
                case 2:
                	System.out.println("Remoção de um empregado");
                	employee.removeEmployee();
                	
                	break;
                case 3:
                	System.out.println("Lançar um cartão de ponto");
                	employee.postTimeCard();
                	break;
                case 4:
                	System.out.println("Lançar uma venda!");
                	employee.postSale();
                	break;
                case 5:
                	System.out.println("Lançar uma taxa de serviço!");
                	employee.postSale();
                	break;
                case 6: 
                	mainText.changeEmployee();
                	 option = scanner.nextInt();
                	if(option == 1)
                		employee.employeeChange();
                	else if(option == 2)
                		sindicate.changeMember(); 
                	break;
                case 7: //NÃO INICIADO
                	System.out.println("Rodar folha de pagamento para hoje!");
                	break;
                case 8: //INCONPLETO
                	mainText.undoRedo();
                	option = scanner.nextInt();
                	int undoRedo;
                	if(option == 1) {
                		undoRedo = comando.undoCommand();
                	} else if(option == 2) {
                		undoRedo = comando.redoCommand();
                	} else {
                		System.out.println("Opção inválida!");
                	} 
                	break;
                case 9: //NÃO INICIADO
                	System.out.println("9 - Agenda de Pagamento");
                	break;
                case 10: //NÃO INICIADO
                	System.out.println("10 - Criação de novas agendas de pagamento");
                	break;
            }
            mainText.newCicleOrExit();
        } while(commandVerify != 11);
        scanner.close();
    }
}

