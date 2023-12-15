public class Article extends Literature {
    public static String[] defaultDesc = { "Title", "Author", "Reflection" };

    public Article() {
        super(defaultDesc, defaultDesc);
    }

    public Article(String[] desc) {
        super(defaultDesc, desc);

    }

}
