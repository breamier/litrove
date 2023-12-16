public class Literature {
    String[] litDefault;
    String[] description;

    public Literature(String[] litDefault, String[] desc) {
        this.litDefault = litDefault;
        this.description = desc;
    }

    public String getDesc(String type) {
        int index = 0;
        for (String description : litDefault) {
            if (description.equalsIgnoreCase(type)) {
                return this.description[index];
            }
            index += 1;
        }
        return "";
    }

    public String[] getDesc() {
        return description;
    }

    public void setDesc(String type, String name) {
        int index = 0;
        for (String a : litDefault) {
            if (a.equalsIgnoreCase(type)) {
                this.description[index] = name;
            }
            index += 1;
        }
    }

    public static Literature generateLitObject(String type, String[] description) {
        switch (type) {
            case "book":
                return new Book(description);
            case "movie":
                return new Movie(description);
            case "podcast":
                return new Podcast(description);
            case "article":
                return new Article(description);
            case "research":
                return new Research(description);
            default:
                return new Literature(null, null);
        }
    }
}

class Book extends Literature {
    // defaultDesc -> descType
    public static String[] defaultDesc = { "Title", "Author", "Publisher", "Genres", "Status", "Rating", "Reflection" };

    public Book(String[] description) {
        super(defaultDesc, description);
    }
}

class Movie extends Literature {
    public static String[] defaultDesc = { "Title", "Main Actors", "Director", "Genre", "Rating", "Reflection" };

    public Movie(String[] description) {
        super(defaultDesc, description);
    }
}

class Podcast extends Literature {
    public static String[] defaultDesc = { "Episode Title", "Podcast Name", "Creator", "Rating", "Reflection" };

    public Podcast(String[] description) {
        super(defaultDesc, description);
    }
}

class Article extends Literature {
    public static String[] defaultDesc = { "Title", "Author", "Reflection" };

    public Article(String[] description) {
        super(defaultDesc, description);
    }
}

class Research extends Literature {
    public static String[] defaultDesc = { "Title", "Authors", "Year Published", "DOI", "Journal", "Reflection" };

    public Research(String[] description) {
        super(defaultDesc, description);
    }
}
