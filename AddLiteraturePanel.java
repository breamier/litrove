import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddLiteraturePanel extends JPanel{

    private String[] types = {"Book","Movie","Article","Research","Podcast"};
    String currentType = types[0];
    private int size = types.length;
    public AddLiteraturePanel() throws IOException{
        setLayout(new GridBagLayout());
        GridBagConstraints g = AppVars.getGridBagConstraints();
        LiteraturePanel[] litPanels= new LiteraturePanel[size];
        CardPanel cards = new CardPanel();
        JPanel actions = new JPanel();
        JButton save = new JButton("Save");
        JButton addAnother = new JButton("Add Another");
        JComboBox<String> litType = new JComboBox<String>(types);

        save.addActionListener(e -> save(cards,litPanels));
        addAnother.addActionListener(e -> addAnother());
        litType.addActionListener(e -> cards.showCard(litType.getSelectedItem()+""));
        litType.addActionListener(e -> currentType = litType.getSelectedItem()+"");

        for(int i = 0; i <size;i++){
            litPanels[i] = LiteraturePanel.generatePanel(types[i]);
            cards.addCard(litPanels[i],types[i]);
        }

        actions.add(litType);
        actions.add(save);
        actions.add(addAnother);
        
        g.gridy=0;
        add(actions,g);
        g.gridy=1;
        add(cards,g);
        
        

        


    }
    
    
    
    public void save(CardPanel cards, LiteraturePanel[] litPanels){
        String[] data;
        int i=0;
        while(true){
            if(currentType.equals(types[i])){break;}
            i+=1; 
        }
        data = litPanels[i].getData();
        FileIOManager.newLit(types[i].toLowerCase(),data);

 
    }
    public void addAnother(){

    }
    
}

