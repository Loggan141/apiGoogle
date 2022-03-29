package Optio;

import java.util.List;
import java.util.Optional;

public class Zoption {

    public static void main(String[] args) {


        List<Manga> mangas = List.of(new Manga(5,"DBGT", 64),
                                     new Manga(3,"DBZ", 290),
                                     new Manga(2,"DB", 150));


        mangas.stream().filter( a -> a.getChapters() > 100).findAny();

        //Optional<Manga> amanga = Optional.of(new Manga(5,"Naruto", 480));
        Optional<Manga> amanga = Optional.of(null);

        if((Optional.ofNullable(amanga)==null)){
            System.out.println("Tem nada aqui");
        }else{
            System.out.println(amanga.get());
        };


    }
}
