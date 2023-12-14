public class Movie extends Literature {
    public static String[] defaultDesc = { "Title", "Main Actors", "Director", "Genre", "Rating", "Reflection" };

    public Movie() {
        super(defaultDesc, defaultDesc);
    }

    public Movie(String[] desc) {
        super(defaultDesc, desc);

    }
}
