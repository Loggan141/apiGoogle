package Exceptions.fluxos;

import Exceptions.MinhaExcecao;
import Exceptions.MinhaNovaException;



public class Fluxo {
            public static void main(String[] args) {
                System.out.println("Ini do main");
               try{
                metodo1();
               }catch (ArithmeticException | NullPointerException ex){
                   String msg = ex.getMessage();
                   System.out.println("Exception "+msg);
                   ex.printStackTrace();
               }
                System.out.println("Fim do main");
            }

            private static void metodo1() {
                System.out.println("Ini do metodo1");
                metodo2();
                System.out.println("Fim do metodo1");
            }

            private static void metodo2() {
                //Não é usual colocar assim \/
                //ArithmeticException exceptions = new ArithmeticException("Deu errado | Mensagem em vermelho");

                throw new ArithmeticException();

                //System.out.println("Fim do metodo2");

            }

         private static void metodo3() {

          throw new MinhaExcecao("Erou");



        }

        //Como EXCEPTION é uma classe checada pelo compilador, é necessário declarar.
         private static void metodo4() throws MinhaNovaException {

        throw new MinhaNovaException("Testando nova exceção");

        }
        //Para não precisar colocar o throws na assinatura, seria necessário tratar a exceção primeiro.

    }