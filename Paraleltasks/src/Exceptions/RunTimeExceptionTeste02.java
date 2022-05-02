package Exceptions;

import java.io.IOException;

public class RunTimeExceptionTeste02 {
    public static void main(String[] args) {
        try {
            divisao(1, 0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("Codigo finalizado");
    }

    //Ao colocar o throws dentro desta classe \/ estou tocando para ser tratada lá no principal
    private static int divisao(int a, int b) throws IllegalArgumentException{
        if (b == 0) {
            throw new RuntimeException("Argumento ilegal não pode ser 0");
        }
        return a/b;
    }

}
