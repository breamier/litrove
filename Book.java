public class Book extends Literature {

    public static String[] defaultDesc = { "Title", "Author", "Publisher", "Genres", "Status", "Rating", "Reflection" };

    public Book() {
        super(defaultDesc, defaultDesc);
    }

    public Book(String[] desc) {
        super(defaultDesc, desc);

    }
}
