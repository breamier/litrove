import javax.swing.*;
import java.awt.*;

public class IndividualLiterature extends JPanel{
    String[] descriptions;
    String[] descTitles;
    int size;
    GridBagConstraints g = AppVars.getGridBagConstraints();
    public IndividualLiterature(String[] desc, String[] descTitles){
        this.descTitles = descTitles;
        this.descriptions = desc;
        this.size = descTitles.length;
        System.out.println(descriptions == null);
        setLayout(new GridBagLayout());
        JLabel title = new JLabel(descriptions[0]);

        g.weightx=0.3;
        g.gridx = 0;
        add(title,g);
        addLabels();

    }
    public void addLabels(){
        int num = descriptions.length;
        g.weightx = 0.1;
        for(int i = 1; i<num;i++){
            g.gridy = i;
            JLabel temp = new JLabel(descTitles[i]+": "+descriptions[i]);
            add(temp,g);
        }

    }
}


