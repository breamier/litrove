public class Book extends Literature {
    
    public static String[] defaultDesc = { "Title","Author","Publisher","Genres","Status","Rating","Reflection"};
    //public static String[] defaultDesc = { "Rae","Piage","Publishedsfasr","Gesafnres","Status","Rating","Reflection"};
    // private String title;
    // private String author;
    // private String publisher;
    // private String genre;
    // private String status;
    // private String rating;
    // private String reflection;
    public Book(){
        super(defaultDesc,defaultDesc);
    }
    public Book(String[] desc){
        super(defaultDesc,desc);

    }
    
    // Getter Methods
    // public String getTitle() {
    //     return desc[0];
    // }

    // public String getAuthor() {
    //     return desc[1];
    // }

    // public String getPublisher() {
    //     return desc[2];
    // }

    // public String getGenre() {
    //     return desc[3];
    // }

    // public String getStatus() {
    //     return desc[4];
    // }

    // public String getRating() {
    //     return desc[5];
    // }

    // public String getReflection() {
    //     return desc[6];
    // }

    // // Setter methods
    // public void setTitle(String title) {
    //     desc[0] = title;
    // }

    // public void setAuthor(String author) {
    //     desc[1] = author;
    // }

    // public void setPublisher(String publisher) {
    //     desc[2] = publisher;
    // }

    // public void setGenre(String genre) {
    //     desc[3] = genre;
    // }

    // public void setStatus(String status) {
    //     desc[4] = status;
    // }

    // public void setRating(String rating) {
    //     desc[5] = rating;
    // }

    // public void setReflection(String reflection) {
    //     desc[6] = reflection;
    // }
}
