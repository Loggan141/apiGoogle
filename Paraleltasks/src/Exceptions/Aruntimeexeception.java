package Exceptions;

import java.io.File;
import java.io.IOException;

//Todos os exceptions são objetos no java, da classe Throwable
//Quando há erros a JVM para de executar para que seja tratada, por isto o desenvolvedor tem que estar
//um passo a frente.
//A classe exception é a mais genérica, estara tratando tudo.
//Por boas práticas é importante tratar aquilo que tem q ser tratado.
//https://www.youtube.com/watch?v=iNlGgh0s_F8&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=98

public class Aruntimeexeception {
    public static void main(String[] args) {



    }

    private static void criarNovoArquivo(){
        File file = new File("arquivo");
        try{
           boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado "+isCriado);
        }catch(IOException e){//Não colocar lógica de negócios no catch! é somente para lidar com exceções
            e.printStackTrace();
        }

    }
}
