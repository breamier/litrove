import javax.swing.*;
import java.awt.*;

public class AddLiteratureScreen extends JFrame{
    public AddLiteratureScreen(){
        super("Add Literature");
        setLayout(new FlowLayout());  
        setSize(500, 500);
        setTitle("Card Layout Example");
        ActionButtons buttonPanel = new ActionButtons();
        BookPanel book = new BookPanel();
        add(buttonPanel);
        add(book);
        setVisible(true);
        pack();
    }
    
}

class LiteraturePanel extends JPanel{
    JPanel addCheckboxes(String names[]){
        JPanel checkboxes = new JPanel();

        for(String name : names){
            checkboxes.add(new JCheckBox(name));
        }
        return checkboxes;
    }

}

class BookPanel extends LiteraturePanel{
    String[] genres = {"fiction", "non-fiction", "fantasy", "sci-fi"
    };
    BookPanel(){
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
        
        setLayout(new FlowLayout());
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

        setPreferredSize(new Dimension(500,800));
        setBackground(Color.RED);
    }

}