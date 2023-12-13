public class Podcast {
    private String title;
    private String creator;
    private String episode;
    private String reflection;

    // Get Methods
    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getEpisode() {
        return episode;
    }

    public String getReflection() {
        return reflection;
    }

    // Set Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }
}
