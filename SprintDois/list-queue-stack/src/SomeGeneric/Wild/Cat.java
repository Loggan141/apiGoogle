package SomeGeneric.Wild;

public class Cat extends Animal{
    String nome;

    Cat(String nome){
        this.nome=nome;
    }

    @Override
    public void consulta() {
        System.out.println("Consultando gato.");
    }


}
