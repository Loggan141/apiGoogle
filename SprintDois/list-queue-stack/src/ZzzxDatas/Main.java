package ZzzxDatas;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=vZZJqYNxiLg
public class Main {
    public static void main(String[] args) {


        //LocalDate - representa uma data 06/05/1992
        LocalDate ldAte=LocalDate.now();
        System.out.println(ldAte);
        System.out.println(ldAte.plusDays(3));

        //LocalTime - representa uma hora 14:00:00
        LocalTime lclTime = LocalTime.now();
        System.out.println(lclTime);
        //LocalDateTime - representa hora e data 06/05/1992  14:00:00
        LocalDateTime lclDaTime=LocalDateTime.now();
        System.out.println(lclDaTime);


        //ZonedDateTime - LocalDateTime com
        //TimeZone(Fuso horário)
        //06/08/1990 11:40:00 GMT-3 (America/Sao_Paulo)
        ZonedDateTime znDT=ZonedDateTime.now();
        System.out.println(znDT+" = ZonedDateTime");




        //Não há construtor para nenhuma delas





        //Instant - representa um instante/momento na linha do tempo, em milissegundos,
        //(a partir de 01/01/1970)00:00
        //GMT-UTC
        //A classe Instant tem precisão de nanossegundos
        Instant agora = Instant.now();
        System.out.println(agora);
        Instant i1 = Instant.ofEpochMilli(9898989898L);
        System.out.println(i1);

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

        //todo isodatetime

    }
}
