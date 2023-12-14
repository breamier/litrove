import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddLiteraturePanel extends JPanel{

    private JComboBox<String> litType;
    private String[] types = {"Book","Movie","Article","Academic Article","Podcast"};
    String currentType = types[0];
    private int size = types.length;

    public AddLiteraturePanel() throws IOException{
        
        setLayout(new GridLayout(2,1));
        LiteraturePanel lit = new LiteraturePanel();
        LiteraturePanel[] litPanels= new LiteraturePanel[size];
        CardPanel cards = new CardPanel();
        
        
        JPanel actions = new JPanel();
        JButton save = new JButton("Save");
        JButton addAnother = new JButton("Add Another");
        save.addActionListener(e -> save(cards,litPanels));
        addAnother.addActionListener(e -> addAnother());

        litType = new JComboBox<String>(types);
        litType.addActionListener(e -> cards.showCard(litType.getSelectedItem()+""));
        litType.addActionListener(e -> currentType = litType.getSelectedItem()+"");

        for(int i = 0; i <size;i++){
            litPanels[i] = lit.generatePanel(types[i]);
            cards.addCard(litPanels[i],types[i]);
        }

        actions.add(litType);
        actions.add(save);
        actions.add(addAnother);
        add(actions);
        add(cards);

        


    }
    public void save(CardPanel cards, LiteraturePanel[] litPanels){
        int i=0;
        while(true){
            if(currentType.equals(types[i])){
                break;
            }
            i+=1; 
        }
        String[] data = litPanels[i].getData();
        for(String x : data){
            System.out.println(x);
        }
        FileIOManager.newBook(data);
 
    }
    public void addAnother(){

    }
}

