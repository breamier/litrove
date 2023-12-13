public class Research {
    private String title;
    private String authors;
    private String date;
    private String doi;
    private String journal;
    private String reflection;

    // Get Methods
    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDate() {
        return date;
    }

    public String getDOI() {
        return doi;
    }

    public String getJournal() {
        return journal;
    }

    public String getReflection() {
        return reflection;
    }

    // Set Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDOI(String doi) {
        this.doi = doi;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }
}
