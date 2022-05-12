package challengeStream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@AllArgsConstructor
@Data

public class Professional {

    private Integer id;
    private String name;
    private BigDecimal salary;

//    Professional engSoftware = new Professional(1, "ENGENHEIRO DE SOFTWARE", BigDecimal.valueOf(3500.00));
//    Professional gerente = new Professional(1, "GERENTE", BigDecimal.valueOf(2900.00));
//    Professional analista = new Professional(1, "ANALISTA", BigDecimal.valueOf(3800.00));
//    Professional desenvolvedor = new Professional(1, "DESENVOLVEDOR", BigDecimal.valueOf(3800.00));

    @Override
    public String toString() {
        return  "id=" + id +
                ", post='" + name + '\'' +
                ", salary= " + salary +" ] \n ";
    }

    public BigDecimal getSalary() {
        return this.salary;
    }
//    @Override
//    public int compareTo(Professional outroProfessional) {
//        return this.salary.compareTo(outroProfessional.getSalary());
//    }
}