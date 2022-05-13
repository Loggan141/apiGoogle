package challengeStream;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Data
@Builder
public class Professional {

    private Integer id;
    private String name;
    private BigDecimal salary;

    public Professional(Integer id, String name, BigDecimal salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    public Professional(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", post='" + name + '\'' +
                ", salary= " + salary +" ] \n ";
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

}