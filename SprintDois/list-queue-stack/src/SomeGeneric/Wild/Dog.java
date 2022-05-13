package SomeGeneric.Wild;

public class Dog extends Animal{
    String nome;

    Dog(String nome){
        this.nome=nome;
    }
    @Override
    public void consulta() {
        System.out.println("Consultando Doguinho.");
    }

}
