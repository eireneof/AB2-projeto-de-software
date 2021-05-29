# AB2 - Projeto de Software 
<br>

> EM DESENVOLVIMENTO :mechanic: 

<br>

### :woman_technologist: Objetivo:
O objetivo do projeto é implementar melhorias em um sistema de **folha de pagamento** desenvolvido da [AB1](https://github.com/eireneof/projeto_de_software). 

### :confounded: Code Smells:

Primeiramente, vamos navegar pelo sistema anterior, classe por classe, a fim de identificar os code smells presentes no código.
<p>
Os seguintes code smells serão procurados:<br>

* Duplicated Code
* Long Parameter List
* Long Method
* Large Class
* Divergent Change
* Shotgun Surger
* Feature Envy
* Primitive Obsession
* Lazy Class
* Speculative Generality
* Message Chains
* Middle Man
* Indecent Exposure
* Data Class
* Refused Bequest
* Comments



**1) Organização das pastas**

* os pacotes `sells`, `itens` e `historic` apresentam apenas uma classe

**2) `sells.Sale`** 


* **Long Parameter List**
```java
Sale(String date, double value, String item, int employeeId)

//"double value" e "String item" poderiam ser um objeto produto ao invés de dois tipos separados
```
<br>

* **Primitive Obsession**

```java
  private String date;
	private double value;
	private String item;
	private int employeeId;

//"double value" e "String item" poderiam ser um objeto produto ao invés de dois tipos separados
```
* **Lazy Class**
```java
 public void postSale(int employeeId) {
   ...
 }

//Essa função de postagem de vendas está na classe Comissioned do package employee ao invés de estar na atual classe de vendas. Consequentemente sells.Sale não está cumprindo seu papel pleno
```


* **Speculative Generality**
verificar se todos os gets e sets estão sendo utilizados
<br>

**3) `main.Main`**


* **Long Method**

```java
switch(commandVerify) {...}

//muitas condicionais 10 no total.
```

* **Speculative Generality**

```java
case 8: //INCONPLETO
  ...
  break;
case 9: //NÃO INICIADO
    System.out.println("9 - Agenda de Pagamento");
    break;
case 10: //NÃO INICIADO
      System.out.println("10 - Criação de novas agendas de pagamento");
      break;
//Como a proposta da AB1 não foi 100% implementada, esses trechos de código ficaram especulativos
```

<br>

**4) `main.Text`**

* **Lazy Class**

```java

//Foi pensada para ser uma classe de suporte aos textos, para não ter que repetir tantos System.out.println's, porém ainda é uma classe que apresenta insuficiência para cumprir esse papel, pois não foi bem arquitetada 
```
<br>

**5) `itens.TimeCard`**

* **Speculative Generality**
verificar se todos os gets e sets estão sendo utilizados

**6) `historic.HistoricComands`**

<br>

**7) `employee.Comissioned`**

* **Large Class**
```java
 public void postSale(int employeeId) {
   ...
 }

//A classe cumpre uma função que não é dela, no caso a de postagem de vendas
```
<br>

**8) `employee.Employee`**


* **Duplicated Code**
```java
public Employee(){}

public Employee(String name, String adress, int id, String paymentMethod, int sindicate) {...}

public Employee(String name, String adress, int id) {...}

//A classe cumpre uma função que não é dela, no caso a de postagem de vendas
```

* **Long Parameter List e Long Method**
```java

int size = listEmployees.size();
    	for(int i = 0; i < size; i++) { ...}

//A variável size foi criada inutilmente
```
<br>

```java

 int id = idGenerate();

 if(type.equals("assalariado")) { 
  ...
  Salaried salaried =  new Salaried(name, adress, id, paymentMethod, salary, sindicate);
  ...
  } 
  else if (type.equals("horista")) {
    ...
    Hourly hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);
    ...
  } 
  else {
  ...
  Comissioned comissioned = new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);
  ...
  } 

//A variável id foi criada inutilmente, visto que a função idGenerate() retorna um parâmetro e poderia ser utilizada no lugar
```
<br>

```java

 if(type.equals("assalariado")) {
    ...
    Salaried salaried =  new Salaried(name, adress, id, paymentMethod, salary, sindicate);
    listEmployees.add(salaried);
    } 
  else if (type.equals("horista")) {
      ...
      Hourly hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);
      listEmployees.add(hourly);
    } 
  else {
      ...
      Comissioned comissioned = new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);
      listEmployees.add(comissioned);
  } 

//As variáveis salaried, hourly e comissioned foram criadas inutilmente, pois o construtor poderia ter sido passado como parâmetro em "listEmployees.add();"
//Além disso, aqui temos o uso de três condiconais com códigos complexos e extensos
```
<br>

```java

public void employeeChange() {
  ...
  switch(command) {
      case 1:
      ...
      break;

      case 2:
      ...
      break;

      case 3:
      ...
      break;

      case 4:
      ...
      break;
  }
}
//muitas condicionais
```

* **Large Class**
```java
 public void postTimeCard() {...}

public void postSale() {...}

//A classe cumpre funções que não são dela, no caso a de postagem de cartão de ponto e de vendas
```
<br>

* **Indecent Exposure**
```java

Salaried salaried =  new Salaried(name, adress, id, paymentMethod, salary, sindicate);

Hourly hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);

Comissioned comissioned = new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);

//Poderia ter feito: Employee salaried = new Salaried(name, adress, id, paymentMethod, salary, sindicate);
//                   Employee salaried = hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);
//                   Employee comissioned = new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);
```
<br>

**9) `employee.Hourly`**


```java
public int coutingHours() {
    	int count = 0;
    	for(TimeCard j : timeCards ) {
    		System.out.println("Data:" + j.getDate() + "\n Horas trabalhadas:" + j.getWorkedHours() + "\n \n");
    		count += j.getWorkedHours();
    	}    	
    	return count;
    }
//Como a proposta da AB1 não foi 100% implementada, esses trecho de código ficaram especulativos, seu objetivo seria contar o número de horas trabalhadas pelo horista para colocar na folha de pagamento
```
<br>

**10) `employee.Salaried`**

**11) `employee.Sindicate`**

* **Duplicated Code**

```java

  private String name;
	private int employeeId;
	private int sindicateId;
	private double feeMonthly;
	private double feeService;
	private static ArrayList<Sindicate> listSindicate = new ArrayList<Sindicate>();

	public Sindicate(String name, int employeeId, int sindicateId, double feeMonthly, double feeService) {
		this.setName(name);
		this.setFeeMonthly(feeMonthly);
		this.setFeeService(feeService);
		this.setSindicateId(sindicateId);
	}

//O sindicato acaba se assemelhando muito em relação à classe Employee com as variáveis: String name e private int employeeId que também acabam se assemelhando no construtor
```
<br>

```java

public Sindicate(String name, int employeeId, int sindicateId, double feeMonthly, double feeService) {...}
	
public Sindicate() {...}

//Métodos semelhantes
```
<br>

* **Long Parameter List**

```java
int size = listSindicate.size();
    	for(int i = 0; i < size; i++) {...}
//variável size foi criada inutilmente
```
<br>

```java
	public void addSindicateMember(String name, int employeeId) { 
		int id = idGenerate();
		Sindicate member = new Sindicate(name, employeeId, id, 0, 0);
		listSindicate.add(member);
    ...
	}
  //variável id e member foram criados inutilemnte 
```
<br>

* **Long Method**

```java
public void changeMember() {
  ...
    switch(command) {
    		...
        //4 cases
    	}
}
//muitas condicionais
```
<br>

* **Speculative Generality**
verificar se todos os gets e sets estão sendo utilizados















# AB2-projeto-de-software
