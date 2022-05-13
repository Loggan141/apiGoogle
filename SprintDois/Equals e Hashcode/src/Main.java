package src;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto("2525","Iphone X");
        Produto p2 = new Produto("1010", "Samsung");
        Produto p3 = new Produto("2525", "Iphone 8");

        System.out.println("Hash produto 1 = "+p1.hashCode());
        System.out.println("Hash produto 2 = "+p2.hashCode());
        System.out.println("Hash produto 3 = "+p3.hashCode());


        System.out.println((p1.equals(p2)) ? "ID's são iguais : "+ p1.getId() : "ID's são diferentes");
        System.out.println((p1.equals(p3)) ? "ID's são iguais : "+ p1.getId() : "ID's são diferentes");
        System.out.println((p2.equals(p3)) ? "ID's são iguais : "+ p1.getId() : "ID's são diferentes");

    }
}


