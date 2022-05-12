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
import java.util.*;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {

//        1) Ordernar por ordem alfabetica.

        System.out.println("\n 1) Ordernar por ordem alfabetica.\n");
        var peopleByAlphabetialOrder= Person.people.stream()
                  .sorted(comparing(Person::getName)).toList();
            peopleByAlphabetialOrder.forEach(System.out::print);
            System.out.println();
//
//        2) Ordernar por ordem de salario.

        System.out.println("\n 2) Ordernar por ordem de salario.\n");
        var peopleSortedBySalary = Person.people.stream()
                  .sorted(comparing(person->person.getProfessional().getSalary()));

                   peopleSortedBySalary.forEach(System.out::print);

//        3) Trazer os 3 primeiros por ordem alfabetica.

        System.out.println("\n 3) Trazer os 3 primeiros por ordem alfabetica.\n");
        var getsThreeFirstSortedByName= Person.people.stream()
                .sorted(comparing(Person::getName)).toList()
                .stream().limit(3).toList();
             getsThreeFirstSortedByName.forEach(System.out::print);

//        4) Trazer os 3 primeiros por ordem de salario.
        System.out.println("\n 4) Trazer os 3 primeiros por ordem de salario.\n");
        var getsThreeFirstSortedBySalary= Person.people.stream()
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .limit(3).toList();
            getsThreeFirstSortedBySalary.forEach(System.out::print);
//        5) Trazer o maior salario da profissao ENGENHEIRO DE SOFTWARE.

        System.out.println("\n 5) Trazer o maior salario da profissao ENGENHEIRO DE SOFTWARE.\n");

        var getHighestSalaryByEngenheiro= Person.filterByProfessional("engenheiro de software", Person.people)
                    .stream()
                    .sorted(Comparator.comparing(person->person.getProfessional().getSalary(),Comparator.reverseOrder())) //organiza confome salário
                    .limit(1)
                    .toList();

            getHighestSalaryByEngenheiro.forEach(System.out::print);
//        6) Trazer o maior salario da profissao GERENTE.

        System.out.println("\n 6) Trazer o maior salario da profissao GERENTE.\n");
        var getHighestSalaryByGerente= Person.filterByProfessional("gerente", Person.people)
                    .stream()
                    .sorted(Comparator.comparing(person -> person.getProfessional().getSalary(),Comparator.reverseOrder())) //organiza confome salário
                    .limit(1)
                    .toList();
        getHighestSalaryByGerente.forEach(System.out::print);




//        7) Trazer o maior salario da profissao ANALISTA.

        System.out.println("\n 7) Trazer o maior salario da profissao ANALISTA.\n");
        var getHighestSalaryByAnalista= Person.filterByProfessional("analista", Person.people).stream()
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .toList();

          System.out.println(getHighestSalaryByAnalista.get(getHighestSalaryByAnalista.size()-1));

//        8) Trazer os 3 maiores salarios da profissao ENGENHEIRO DE SOFTWARE.

        System.out.println("\n 8) Trazer os 3 maiores salarios da profissao ENGENHEIRO DE SOFTWARE. \n");

        var getThreeHighestSalarysEngenheiro=Person.filterByProfessional("engenheiro de software", Person.people)
                .stream()//Filtro conforme engenheiro
                .sorted(comparing(Person -> Person.getProfessional().getSalary()))
                .sorted(Comparator.comparing(person->person.getProfessional().getSalary(), Comparator.reverseOrder())) //Organiza conforme salario
                .limit(3)
                .toList();
        getThreeHighestSalarysEngenheiro.forEach(System.out::print);

//        9) Trazer os 3 primeiros profissionais que tenham o nome que começa com a letra "b" e "k".

        System.out.println("\n 9) Trazer os 3 primeiros profissionais que tenham o nome que começa com a letra \"b\" e \"k\".\n");

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
//        10) Trazer todos profissionais que tem o nome que termina com a letra "d" e "e"

        System.out.println(" 10) Trazer todos profissionais que tem o nome que termina com a letra \"d\" e \"e\".\n");

        var getAllProfessionalsWhoEndsD=Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(person.getName().length()-1)=='D')
                .toList();
        var getAllProfessionalsWhoEndsE=Person.people.stream()
                .filter(person -> person.getName().toUpperCase().charAt(person.getName().length()-1)=='E')
                .toList();

        System.out.println("Terminam com letra D: \n"+getAllProfessionalsWhoEndsD+
                "\n Terminam com a letra E: \n"+getAllProfessionalsWhoEndsE);

//        11) Trazer os 6 maiores salarios Masculino.

        System.out.println("\n 11) Trazer os 6 maiores salarios Masculino.\n");
        var getFirstSixSalarysByMale = Person.people.stream()
                .filter(person->person.getSex().equals(SexEnum.MALE))
                .sorted(comparing(person->person.getProfessional().getSalary()))
                .limit(6)
                .toList();
        getFirstSixSalarysByMale.forEach(System.out::print);

//        12) Trazer os 6 maiores salarios feminino.

        System.out.println("\n 12) Trazer os 6 maiores salarios feminino.\n");
        var getFirstSixSalarysByFemale=Person.people.stream()
                        .filter(person->person.getSex().equals(SexEnum.FEMALE))
                        .sorted(comparing(person->person.getProfessional().getSalary(), Comparator.reverseOrder()))
                        .limit(6)
                        .toList();

                getFirstSixSalarysByFemale.forEach(System.out::print);

//        13) Criar grupos de Map com as profissoes e pessoas ex de como deve ficar --> Map<Professional, List<Person>>

             System.out.println("\n 13) Criar grupos de Map com as profissoes e pessoas\n");

                 Map<Professional, List<Person>> organizedByProfessionalsEngenheiro = new HashMap<>();

                    organizedByProfessionalsEngenheiro.put(new Professional(1 ,"Engenheiro de Software"),
                        Person.filterByProfessional("Engenheiro de software",Person.people));
                        organizedByProfessionalsEngenheiro.forEach((k, v) -> System.out.printf("Professional: %s | Persons: %s%n", k, v));


                 Map<Professional, List<Person>> organizedByProfessionalsAnalista = new HashMap<>();

                    organizedByProfessionalsAnalista.put(new Professional(1 ,"Analista"),
                            Person.filterByProfessional("Analista",Person.people));
                    organizedByProfessionalsAnalista.forEach((k, v) -> System.out.printf("Professional: %s | Persons: %s%n", k, v));

                 Map<Professional, List<Person>> organizedByProfessionalsGerente = new HashMap<>();

                    organizedByProfessionalsGerente.put(new Professional(1 ,"Gerente"),
                            Person.filterByProfessional("Gerente",Person.people));
                    organizedByProfessionalsGerente.forEach((k, v) -> System.out.printf("Professional: %s | Persons: %s%n", k, v));

                 Map<Professional, List<Person>> organizedByProfessionalsDesenvolvedor = new HashMap<>();

                    organizedByProfessionalsDesenvolvedor.put(new Professional(1 ,"Desenvolvedor"),
                            Person.filterByProfessional("Desenvolvedor",Person.people));

                    organizedByProfessionalsDesenvolvedor.forEach((k, v) -> System.out.printf("Professional: %s | Persons: %s%n", k, v));


//        14) Criar uma lista aplicando 10% de aumento para profissionais ENGENHEIRO DE SOFTWARE do sexo feminino.

        System.out.println("\n 14) Criar uma lista aplicando 10% de aumento para profissionais ENGENHEIRO DE SOFTWARE do sexo feminino.\n");
             var settingTenPercentPlusSoftwareEngFemale=Person.people.stream()

                .filter(person->person.getProfessional().getName().equals("ENGENHEIRO DE SOFTWARE"))
                .filter(person -> person.getSex().equals(SexEnum.FEMALE))
                .map((Person person) ->{person.getProfessional().setSalary(person.getProfessional().getSalary().multiply(BigDecimal.valueOf(1.1)));
                    return Person.builder()
                                 .name(person.getName())
                                 .professional(person.getProfessional())
                                 .sex(person.getSex())
                                 .build();}
                    )
                .toList();

            settingTenPercentPlusSoftwareEngFemale.forEach(System.out::print);

//        15) Trazer os 3 maiores salarios da profissao GERENTE

                System.out.println("\n 15) Trazer os 3 maiores salarios da profissao GERENTE\n");
                var getThreeHighestSalarysGerente=Person.people.stream()
                        .filter(person -> person.getProfessional().getName().equals("GERENTE")) //Filtro conforme engenheiro
                        .sorted(comparing(Person -> Person.getProfessional().getSalary(), Comparator.reverseOrder()))
                        .sorted(Comparator.comparing(person->person.getProfessional().getSalary())) //Organiza conforme salario
                        .limit(3)
                        .toList();

//        16) Criar um Map com as profissoes ex: Map<Professional, List<Person>>
        System.out.println("\n 16) Criar um Map com as profissoes ex: Map<Professional, List<Person>>\n");
            Map<Professional, List<Person>> mapComPersonsEProfissoes= new HashMap<>();
            mapComPersonsEProfissoes.put(new Professional(1,"Engenheiro de software"),
                    Person.filterByProfessional("Engenheiro de software",Person.people));

            mapComPersonsEProfissoes.put(new Professional(1,"Analista"),
                    Person.filterByProfessional("Analista",Person.people));

            mapComPersonsEProfissoes.put(new Professional(1,"Desenvolvedor"),
                    Person.filterByProfessional("Desenvolvedor",Person.people));

            mapComPersonsEProfissoes.put(new Professional(1,"Gerente"),
                    Person.filterByProfessional("Gerente",Person.people));

        mapComPersonsEProfissoes.forEach((k, v) -> System.out.printf("Professional: %s | Persons: %s%n", k, v));
    }
}
