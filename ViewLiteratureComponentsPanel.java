import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewLiteratureComponentsPanel extends JPanel{
    public ViewLiteratureComponentsPanel(String type,String title, String subDesc){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        List<Literature> litList = FileIOManager.readLit(type);

        for(Literature lit : litList){
            JPanel litBlock = new LiteratureBlock(type, lit.getDesc(title), lit.getDesc(subDesc));
            add(litBlock);
        }

    }
     

    public static ViewLiteratureComponentsPanel generatePanel(String name){
        name = name.toLowerCase();
        switch(name){
            case "book":
                return new BookViewComponent();
            case "movie":
                return new MovieViewComponent();
            case "article":
                return new ArticleViewComponent();
            case "research":
                return new ResearchViewComponent();
            case "podcast":
                return new PodcastViewComponent();
            default:
                return null;
        }
    }
    
}

class BookViewComponent extends ViewLiteratureComponentsPanel{
    public BookViewComponent() {
        super("book", "title", "author");
    }
}
class MovieViewComponent extends ViewLiteratureComponentsPanel{
    public MovieViewComponent() {
        super("book", "title", "author");
    }
}
class ArticleViewComponent extends ViewLiteratureComponentsPanel{
    public ArticleViewComponent() {
        super("book", "title", "author");
    }
}
class ResearchViewComponent extends ViewLiteratureComponentsPanel{
    public ResearchViewComponent() {
        super("book", "title", "author");
    }
}
class PodcastViewComponent extends ViewLiteratureComponentsPanel{
    public PodcastViewComponent() {
        super("book", "title", "author");
    }
}


