import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddLiteraturePanel extends JPanel{
    private JComboBox<String> litType;
    private String[] types = {"Book","Movie","Article","Academic Article","Podcast"};
    private int size = types.length;
    public AddLiteraturePanel() throws IOException{
        setLayout(new GridLayout(2,1));
        LiteraturePanel lit = new LiteraturePanel();
        LiteraturePanel[] litPanels= new LiteraturePanel[size];
        CardPanel cards = new CardPanel();
        litType = new JComboBox<String>(types);
        litType.addActionListener(e -> cards.showCard(litType.getSelectedItem()+""));

        for(int i = 0; i <size;i++){
            litPanels[i] = lit.generatePanel(types[i]);
            cards.addCard(litPanels[i],types[i]);
        }   
        add(litType);
        add(cards);

        


    }
    public void changeLitType(String type, CardPanel litCard){
        litCard.showCard(type);
        }
}

