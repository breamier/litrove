import javax.swing.*;
import java.awt.*;

public class ViewLiteraturePanel extends JPanel{
    private String[] types = {"Book","Movie","Article","Research","Podcast"};
    String currentType = types[0];
    private int size = types.length;
    JPanel litComponents;
    JPanel[] litPanels= new ViewLiteratureComponentsPanel[size];
    
    public ViewLiteraturePanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints g = AppVars.getGridBagConstraints();
        
        JPanel actions = new JPanel();
        litComponents =
        JComboBox<String> litType = new JComboBox<String>(types);

        litType.addActionListener(e -> changeView(litType.getSelectedItem()+""));

        
        actions.add(litType);
        g.gridy=0;
        add(actions,g);
        g.gridy=1;
        add(litComponents,g);

    }
    
    public void changeView(String type){
        this.remove(litComponents);
        litComponents = ViewLiteratureComponentsPanel.generatePanel(type);
        this.add(litComponents);


    }
}