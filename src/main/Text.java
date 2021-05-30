package main;

public class Text {

	public Text() {}
	
	public void showCommands() {
        System.out.println("1 - Adição de Empregado");
        System.out.println("2 - Remoção de Empregado");
        System.out.println("3 - Lançar um cartão de ponto");
        System.out.println("4 - Lançar um  resultado de venda");
        System.out.println("5 - Lançar uma taxa de serviço");
        System.out.println("6 - Alterar detalhes de um empregado");
        System.out.println("7 - Rodar folha de pagamento para hoje");
        System.out.println("8 - Undo/Redo");
        System.out.println("9 - Agenda de Pagamento");
        System.out.println("10 - Criação de novas agendas de pagamento");
        System.out.println("11 - Sair");
        System.out.println("0 - Mostrar a lista de comandos");
	}
	
	public void firstContact() {
        System.out.println("Olá, seja bem vindo (a) ao Sistema de Folha de Pagamento");
        System.out.println("Qual dos comandos a seguir você deseja executar?");
	}
	
	public void outText() {
		System.out.println("Você saiu do sistema. Até breve!");
	}
	
	public void changeEmployee() {
    	System.out.println("Alterar detalhes de um empregado!");
    	System.out.println("Esses dados são referentes a:");
    	System.out.println("1 - Informações do empregado na EMPRESA");
    	System.out.println("2 - Informações do empregado na SINDICATO");
	}
	
	public void undoRedo() {
    	System.out.println("Undo/Redo!");
    	System.out.println("Informe o que deseja fazer: ");
    	System.out.println("1 - Undo");
    	System.out.println("2 - Redo");
	}
	
	public void newCicleOrExit() {
        System.out.println("Informe um novo comando, digite 11 para sair ou 0 para mostrar a lista de comandos.");
	}

}
