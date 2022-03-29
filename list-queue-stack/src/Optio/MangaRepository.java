package Optio;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {


    private static List<Manga> mangas = List.of(new Manga(1, "Dragon ball", 290),
                new Manga(2, "Death Note", 30));


    private static Optional<Manga> findByTitle(String title){
        return findBy(m -> m.getName().equals(title));

    }

    private static Optional<Manga> findById(Integer id){
        return findBy(m -> m.getId().equals(id));
    }


    private static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga found = null;
        for(Manga manga: mangas){
            if(predicate.test(manga)){
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }





}
