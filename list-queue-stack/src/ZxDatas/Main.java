package ZxDatas;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //A classe Instant tem precisão de nanossegundos
        Instant agora = Instant.now();
        System.out.println(agora);

        //data no instante 0 com a data normal sem tempo em horas e segundos.
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        //Data fixa para, por exemplo, data de confecção do RG
        LocalDate emissaoRG = LocalDate.of(2000, 1, 15);


        //Pode-se calcular o tempo de execução de algo
        List<Integer> teste = new ArrayList<>();
        Instant inicio = Instant.now();
            for(int i=0;i<1000;i++){
                teste.add(i);
            }
        Instant fim = Instant.now();
        Duration duracao = Duration.between(inicio, fim);
        long duracaoEmNanosegundos = duracao.toNanos();
        System.out.println(duracaoEmNanosegundos+"ns");



        //Calcular o tempo entre 2 datas.
        LocalDate homemNoEspaco = LocalDate.of(1961, Month.APRIL, 12);
        LocalDate homemNaLua = LocalDate.of(1969, Month.MAY, 25);

        Period periodo = Period.between(homemNoEspaco, homemNaLua);

        System.out.printf("%s anos, %s mês e %s dias", periodo.getYears() , periodo.getMonths(), periodo.getDays());

        //Datas e meses importantes
        //classes MonthDay para representar datas que repetem todos os anos, e YearMonth

        MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
        YearMonth copaDoMundo2014 = YearMonth.of(2014, Month.JUNE);



    }
}
