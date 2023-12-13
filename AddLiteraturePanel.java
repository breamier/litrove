import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddLiteraturePanel extends JPanel{
    private JComboBox<String> litType;
    private String[] types = {"Book","Movie","Article","Academic Article","Series","Podcast"};
    public AddLiteraturePanel() throws IOException{
        //JPanel buttons = new JPanel();
        setLayout(new GridLayout(2,1));
        CardPanel cards = new CardPanel();
        litType = new JComboBox<String>(types);
        litType.addActionListener(e -> cards.showCard(litType.getSelectedItem()+""));

        BookPanel book = new BookPanel();
        MoviePanel movie = new MoviePanel();

        cards.addCard(book,types[0]);
        cards.addCard(movie,types[1]); 
        add(litType);
        add(cards);

        


    }
    public void changeLitType(String type, CardPanel litCard){
        litCard.showCard(type);
        }
}

