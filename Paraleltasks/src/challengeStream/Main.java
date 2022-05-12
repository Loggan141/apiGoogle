package challengeStream;

/*Dado os seguintes objetos abaixo realizar as seguintes buscar.
1) Ordernar por ordem alfabetica.
2) Ordernar por ordem de salario.
3) Trazer os 3 primeiros por ordem alfabetica.
4) Trazer os 3 primeiros por ordem de salario.
5) Trazer o maior salario da profissao ENGENHEIRO DE SOFTWARE.
6) Trazer o maior salario da profissao GERENTE.
5) Trazer o maior salario da profissao ANALISTA.
6) Trazer os 3 maiores salarios da profissao ENGENHEIRO DE SOFTWARE.
7) Trazer os 3 primeiros profissionais que tenham o nome que começa com a letra "b" e "k".
8) Trazer todos profissionais que tem o nome que termina com a letra "d" e "e"
9) Trazer os 6 maiores salarios Masculino.
10) Trazer os 6 maiores salarios feminino.
11) Criar grupos de Map com as profissoes e pessoas ex de como deve ficar --> Map<Professional, List<Person>>
12) Criar uma lista aplicando 10% de aumento para profissionais ENGENHEIRO DE SOFTWARE do sexo feminino.
13) Trazer os 3 maiores salarios da profissao GERENTE
14) Criar um Map com as profissoes ex: Map<Professional, List<Person>>*/

import java.math.BigDecimal;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {

//        1) Ordernar por ordem alfabetica.

        System.out.println(" 1) Ordernar por ordem alfabetica.\n");
        var peopleByAlphabetialOrder= Person.people.stream()
                  .sorted(comparing(Person::getName)).toList();
            peopleByAlphabetialOrder.forEach(System.out::print);
            System.out.println();
//
//        2) Ordernar por ordem de salario.

        System.out.println(" 2) Ordernar por ordem de salario.\n");
        var peopleSortedBySalary = Person.people.stream()
                  .sorted(comparing(person->person.getProfessional().getSalary()));

                   peopleSortedBySalary.forEach(System.out::print);

//        3) Trazer os 3 primeiros por ordem alfabetica.

        System.out.println(" 3) Trazer os 3 primeiros por ordem alfabetica.\n");
        var getsThreeFirstSortedByName= Person.people.stream()
                .sorted(comparing(Person::getName)).toList()
                .stream().limit(3).toList();
             getsThreeFirstSortedByName.forEach(System.out::print);

//        4) Trazer os 3 primeiros por ordem de salario.
        System.out.println(" 4) Trazer os 3 primeiros por ordem de salario.\n");
        var getsThreeFirstSortedBySalary= Person.people.stream()
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .limit(3).toList();
            getsThreeFirstSortedBySalary.forEach(System.out::print);
//        5) Trazer o maior salario da profissao ENGENHEIRO DE SOFTWARE.

        System.out.println(" 5) Trazer o maior salario da profissao ENGENHEIRO DE SOFTWARE.\n");

        var getHighestSalaryByEngenheiro= Person.people.stream()
                    .sorted(comparing(person->person.getProfessional().getSalary())) //organiza confome salário
                    .filter(person -> person.getProfessional().getName().equals("ENGENHEIRO DE SOFTWARE")) //filtra pelos
                                                                                                            // nomes com EngSoftwar
                    .toList();

            System.out.println(getHighestSalaryByEngenheiro.get(getHighestSalaryByEngenheiro.size()-1));
//        6) Trazer o maior salario da profissao GERENTE.

        System.out.println(" 6) Trazer o maior salario da profissao GERENTE.\n");
        var getHighestSalaryByGerente= Person.people.stream()
                    .sorted(comparing(person->person.getProfessional().getSalary())) //organiza confome salário
                    .filter(person -> person.getProfessional().getName().equals("GERENTE")) //filtra pelos nomes com Gerente
                    .toList();
            System.out.println(getHighestSalaryByGerente.get(getHighestSalaryByGerente.size()-1));

//        5) Trazer o maior salario da profissao ANALISTA.

        System.out.println(" 5) Trazer o maior salario da profissao ANALISTA.\n");
        var getHighestSalaryByAnalista= Person.people.stream()
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .filter(person -> person.getProfessional().getName().equals("ANALISTA"))
                .toList();
          System.out.println(getHighestSalaryByAnalista.get(getHighestSalaryByAnalista.size()-1));

//        6) Trazer os 3 maiores salarios da profissao ENGENHEIRO DE SOFTWARE.

        System.out.println(" 6) Trazer os 3 maiores salarios da profissao ENGENHEIRO DE SOFTWARE. \n");
        var getThreeHighestSalarysEngenheiro=Person.people.stream()
                .filter(person -> person.getProfessional().getName().equals("ENGENHEIRO DE SOFTWARE")) //Filtro conforme engenheiro
                .sorted(comparing(Person -> Person.getProfessional().getSalary()))
                //.sorted(Comparator.comparing(person->person.getProfessional().getSalary())) //Organiza conforme salario
                .toList();


//        7) Trazer os 3 primeiros profissionais que tenham o nome que começa com a letra "b" e "k".

        System.out.println(" 7) Trazer os 3 primeiros profissionais que tenham o nome que começa com a letra \"b\" e \"k\".\n");
        var getThreeProfessionalsBeginsLettersB = Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(0)=='B')
                .limit(3)
                .toList();

        var getThreeProfessionalsBeginsLettersK =Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(0)=='K')
                .limit(3)
                .toList();

        System.out.println("Começam com letra B: \n"+getThreeProfessionalsBeginsLettersB+
                           "\n Começam com a letra K: \n"+getThreeProfessionalsBeginsLettersK);
//
//        8) Trazer todos profissionais que tem o nome que termina com a letra "d" e "e"

        System.out.println(" 8) Trazer todos profissionais que tem o nome que termina com a letra \"d\" e \"e\".\n");
        var getAllProfessionalsWhoEndsD=Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(person.getName().length()-1)=='D')
                .toList();
        var getAllProfessionalsWhoEndsE=Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(person.getName().length()-1)=='E')
                .toList();

        System.out.println("Terminam com letra D: \n"+getAllProfessionalsWhoEndsD+
                "\n Terminam com a letra E: \n"+getAllProfessionalsWhoEndsE);

//        9) Trazer os 6 maiores salarios Masculino.

        System.out.println(" 9) Trazer os 6 maiores salarios Masculino.\n");
        var getFirstSixSalarysByMale = Person.people.stream()
                .filter(person->person.getSex().equals(SexEnum.MALE))
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .limit(6)
                .toList();
        getFirstSixSalarysByMale.forEach(System.out::print);

//        10) Trazer os 6 maiores salarios feminino.
        System.out.println("\n 10) Trazer os 6 maiores salarios feminino.\n");
        var getFirstSixSalarysByFemale=Person.people.stream()
                        .filter(person->person.getSex().equals(SexEnum.FEMALE))
                        .sorted(comparing(person->person.getProfessional().getSalary()))
                        .limit(6)
                        .toList();

                getFirstSixSalarysByFemale.forEach(System.out::print);

//        11) Criar grupos de Map com as profissoes e pessoas ex de como deve ficar --> Map<Professional, List<Person>>


//        12) Criar uma lista aplicando 10% de aumento para profissionais ENGENHEIRO DE SOFTWARE do sexo feminino.

        System.out.println("\n 12) Criar uma lista aplicando 10% de aumento para profissionais ENGENHEIRO DE SOFTWARE do sexo feminino.\n");
        var settingTenPercentPlusSoftwareEngFemale=Person.people.stream()

                .filter(person->person.getProfessional().getName().equals("ENGENHEIRO DE SOFTWARE"))
                .filter(person -> person.getSex().equals(SexEnum.FEMALE))
                .map(person ->person.getProfessional().getSalary().multiply(BigDecimal.valueOf(1.1)))

                .toList();

            settingTenPercentPlusSoftwareEngFemale.forEach(System.out::print);

//        13) Trazer os 3 maiores salarios da profissao GERENTE
        System.out.println("\n 13) Trazer os 3 maiores salarios da profissao GERENTE\n");
        var getThreeHighestSalarysGerente=Person.people.stream()
                .filter(person -> person.getProfessional().getName().equals("GERENTE")) //Filtro conforme engenheiro
                .sorted(comparing(Person -> Person.getProfessional().getSalary()))
                .sorted(Comparator.comparing(person->person.getProfessional().getSalary())) //Organiza conforme salario
                .toList();

//        14) Criar um Map com as profissoes ex: Map<Professional, List<Person>>*/

    }
}
