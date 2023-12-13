public class Movie {
    private String title;
    private String actors;
    private String director;
    private String genre;
    private String reflection;

    // Get Methods
    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getReflection() {
        return reflection;
    }

    // Set Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }
}
