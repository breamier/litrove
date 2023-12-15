public class Podcast extends Literature {
    public static String[] defaultDesc = {  "Episode Title / Num", "Title", "Creator", "Rating", "Reflection" };

    public Podcast() {
        super(defaultDesc, defaultDesc);
    }

    public Podcast(String[] desc) {
        super(defaultDesc, desc);

    }
}
