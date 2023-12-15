public class Research extends Literature {
    public static String[] defaultDesc = { "Title", "Authors", "Year Published", "DOI", "Journal", "Reflection" };

    public Research() {
        super(defaultDesc, defaultDesc);
    }

    public Research(String[] desc) {
        super(defaultDesc, desc);

    }
}
