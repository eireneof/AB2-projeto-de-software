# AB2 - Projeto de Software 
<br>

> EM DESENVOLVIMENTO :mechanic: 

<br>

### :woman_technologist: Objetivo:
O objetivo do projeto é implementar melhorias em um sistema de **folha de pagamento** desenvolvido da [AB1](https://github.com/eireneof/projeto_de_software). 

### :confounded: Code Smells:

Primeiramente, vamos navegar pelo sistema anterior, classe por classe, a fim de identificar os code smells presentes no código. <br>

<br>

Code smells procurados| 
--- |
Duplicated Code |
Long Parameter List |
 Long Method |
 Large Class |
 Divergent Change |
 Shotgun Surger |
 Feature Envy |
 Primitive Obsession |
 Lazy Class |
 Speculative Generality |
 Message Chains |
 Middle Man |
 Indecent Exposure |
 Data Class |
 Refused Bequest |
 Comments |

 <br>

 Os code smelss identificados podem ser vistos [aqui](https://github.com/eireneof/AB2-projeto-de-software/blob/main/code_smells.md) 

 ### :wrench: Refatoramento:

 * **Strategy**
    * Quando um novo empregado é adicionado, ele pode ser de 3 tipos, horista, assalariado ou comissionado. Para isso foi criado um método `add()`na classe principal `Employee` e um relacionamento hierárquico entre as subclasses `Hourly`, `Comissioned`e `Assalaried`.
    * Pôde ser observado 3 tipos de code smells ao fazer o encaminhamento adequado para a criação dos objetos. É interessante observar que a implementação desse padrão de projeto lidou com esses 3 problemas do sistema anterior. <br>
    * *[ANTES:](https://github.com/eireneof/projeto_de_software/blob/main/src/employee/Employee.java#L105)* <br> 
    
    ```java
    if(type.equals("assalariado")) {
        	System.out.println("Informe o salário:");
        	salary = in.nextDouble();
        	Salaried salaried =  new Salaried(name, adress, id, paymentMethod, salary, sindicate);
        	listEmployees.add(salaried);
        } else if (type.equals("horista")) {
        	System.out.println("Informe o salário horário:");
        	salary = in.nextDouble();
        	Hourly hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);
        	listEmployees.add(hourly);
        } else {
        	System.out.println("Informe a porcentagem de comissão:");
        	double percent = in.nextDouble();
        	System.out.println("Informe o salário:");
        	salary = in.nextDouble();
        	Comissioned comissioned = new Comissioned(name, adress, id, paymentMethod, salary, percent, sindicate);
        	listEmployees.add(comissioned);
        } 

    //log method: uso complexo de condicionais
    //exposição indevida: declaração das subclasses ao invés da principal (ex: Hourly hourly = new Hourly(name, adress, id, paymentMethod, salary, sindicate);)
    //long parameter list: as variáveis salaried, hourly e comissioned  não precisavam ser criadas, visto que o construtor poderia ser passado diretamente em listEmployees.add();
    ```
    * A fim de resolver os problemas mencionados, foi aplicada uma estratégia primeiramente criando um `map`: `employeeMap.put("tipo de empregado", posição);`. Depois, foi criada uma `enum`chamada `StrategyEmployee`com os métodos referentes a criação de cada tipo de employee e acessada de acordo com a posição no map. Para dar suporte a essa estratégia, também foi criada uma classe abstrata `ChoiceEmployee` e os métodos de `StrategyEmployees` eram desse tipo. 
    * [StrategyEmployee](https://github.com/eireneof/AB2-projeto-de-software/blob/main/src/employee/StrategyEmployees.java)
    * [ChoiceEmployee](https://github.com/eireneof/AB2-projeto-de-software/blob/main/src/employee/ChoiceEmployee.java)
    * *DEPOIS:* <br>
    ```java
    HashMap<String, Integer> employeeMap = new HashMap();
        employeeMap.put("horista", 0);
        employeeMap.put("assalariado", 1);
        employeeMap.put("comissionado", 2);
    
    listEmployees.add(StrategyEmployees.values()[employeeMap.get(type)].getChoiceEmployee(name,adress,id,sindicate,paymentMethod).choiceEmployee());

    //As condicionais anteriores foram substituídas por essas linhas de código na função add
    ```
    




