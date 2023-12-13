import javax.swing.*;
import java.awt.*;

public class MoviePanel extends LiteraturePanel{
    private String[] genres = {"fiction", "non-fiction", "fantasy", "sci-fi"};
    MoviePanel(){
        JTextField title = new JTextField("text");
        JTextField author = new JTextField("text");
        JTextField publisher = new JTextField("text");
        JPanel checkboxes = addCheckboxes(genres);
        String ratings[] = {"1","2","3","4","5"};
        JComboBox rating = new JComboBox(ratings);
        JTextArea thoughts = new JTextArea("Insert thoughts");
        
        JLabel titleT = new JLabel("Title:");
        JLabel authorT = new JLabel("Author:");
        JLabel pubT = new JLabel("Publisher:");
        JLabel genreT = new JLabel("Genres:");
        JLabel ratingT = new JLabel("Rating:");
        JLabel thoughtsT = new JLabel("Thoughts");
        
        setLayout(new GridLayout(6,2));
        add(titleT);
        add(title);

        add(authorT);
        add(author);

        add(pubT);
        add(publisher);

        add(genreT);
        add(checkboxes);

        add(ratingT);
        add(rating);

        add(thoughtsT);
        add(thoughts);  

        setBackground(Color.BLUE);
    }


}