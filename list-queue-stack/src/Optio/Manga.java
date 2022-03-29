package Optio;

public class Manga {
    private Integer id;
    private String name;
    private int chapters;

    public Manga(Integer id, String name, int chapters) {
        this.id = id;
        this.name = name;
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
