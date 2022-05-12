package challengeStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Data
@NoArgsConstructor

 public class Person{
        private String name;
        private SexEnum sex;
        private Professional Professional;

    static List<Person> people = Arrays.asList(
            new Person("Miguel Ballard", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(3500.00))),
            new Person("Davi Harmon", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(2500.00))),
            new Person("Gabriel Schwartz", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(1500.00))),
            new Person("Arthur Love", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1800.00))),
            new Person("Lucas Stokes", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(6500.00))),
            new Person("Matheus Hammond", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
            new Person("Pedro Bird", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
            new Person("Guilherme Frye", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(7500.00))),
            new Person("Gustavo Keith", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(8500.00))),
            new Person("Rafael Sharp", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(3500.00))),
            new Person("Felicia Suarez", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
            new Person("Angela Pope", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(83500.00))),
            new Person("Enzo Rawlings", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(32500.00))),
            new Person("Nicolas Harwood", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(13500.00))),
            new Person("João Pedro Dean", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(23500.00))),
            new Person("Fabricia Henrique Molina", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3500.00))),
            new Person("Cassia Schneider", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(2500.00))),
            new Person("Vitor Graham", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1500.00))),
            new Person("Eduardo Dennis", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(1800.00))),
            new Person("Daniel-Rose Castro", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(6500.00))),
            new Person("Henrique Graham", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(4500.00))),
            new Person("Murilo Laing", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(4500.00))),
            new Person("Vinicius Perkins", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(7500.00))),
            new Person("Samuel Herring", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
            new Person("Pietra Portillo", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(3500.00))),
            new Person("Joana Vitor Bowler", SexEnum.FEMALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(8500.00))),
            new Person("Leonardo Perkins", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(983500.00))),
            new Person("Caio Peralta", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(32500.00))),
            new Person("Heitor Sharpe", SexEnum.MALE, new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(13500.00))),
            new Person("Lois Hyde", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(23500.00))),
            new Person("Isaac Eaton", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3500.00))),
            new Person("Lucca Carlos", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(6500.00))),
            new Person("Thiago Hayward", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(4500.00))),
            new Person("João Gabriel Gomez", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(1500.00))),
            new Person("João Patel", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(2500.00))),
            new Person("Theo Herring", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3800.00))),
            new Person("Bruna Odom", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3590.00))),
            new Person("Britnei Hopkins", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(8500.00))),
            new Person("Carlos Eduardo Blaese", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(983580.00))),
            new Person("Luiz Felipe Collins", SexEnum.MALE, new Professional(1, "GERENTE", BigDecimal.valueOf(32530.00))),
            new Person("Breno Bouvet", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(13500.00))),
            new Person("Emanuela Oneill", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(23500.00))),
            new Person("Ryanna Davison", SexEnum.FEMALE, new Professional(1, "GERENTE", BigDecimal.valueOf(3510.00))),
            new Person("Vitor Hugo Ellwood", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(6500.00))),
            new Person("Yuri Prentice", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(4502.00))),
            new Person("Betania Povey", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(2501.00))),
            new Person("Erica Walters", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(3510.00))),
            new Person("Enzo Gabriel Brooks", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(510.00))),
            new Person("Fernando Gomez", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(6510.00))),
            new Person("Joaquim Horne", SexEnum.MALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(9510.00))),
            new Person("André Mcgrath", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(283100.00))),
            new Person("Antonia Bowden", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(12510.00))),
            new Person("Francisco Hamilton", SexEnum.MALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(3510.00))),
            new Person("Roberat Yu", SexEnum.FEMALE, new Professional(1, "ANALISTA", BigDecimal.valueOf(25520.00))),
            new Person("Isis Fraser", SexEnum.FEMALE, new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(4520.00)))
    );
    public Person(String name, SexEnum sex, challengeStream.Professional professional) {
        this.name = name;
        this.sex = sex;
        Professional = professional;
    }
    private String getNome() {
        return this.name;
    }

    @Override
    public String toString() {
        return  "[name='" + name + '\'' +
                ", sex=" + sex +
                ", Professional : " + Professional;
    }
}

