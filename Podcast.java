public class Podcast extends Literature {
    public static String[] defaultDesc = { "Title", "Episode Title / Num", "Creator", "Rating", "Reflection" };

    public Podcast() {
        super(defaultDesc, defaultDesc);
    }

    public Podcast(String[] desc) {
        super(defaultDesc, desc);

    }
}
