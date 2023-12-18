import javax.swing.*;
import java.awt.*;

public class IndividualLiterature extends JPanel{
    String[] descriptions;
    String[] descTitles;
    String type;
    MenuViewLiterature parent;
    int size;
    GridBagConstraints g = AppVars.getGridBagConstraints();
    public IndividualLiterature(String[] desc, String[] descTitles,String type, MenuViewLiterature parent){
        this.descTitles = descTitles;
        this.descriptions = desc;
        this.size = descTitles.length;
        this.type = type;
        this.parent = parent;
        System.out.println(descriptions == null);
        setLayout(new GridBagLayout());
        JLabel title = new JLabel(descriptions[0]);

        JButton edit = new JButton("Edit");
        JButton back = new JButton("Back");
        
        back.addActionListener(e -> goBack());
        g.weightx=0.3;
        g.gridx = 0;
        add(title,g);
        addLabels();
        g.gridy+=1;
        add(back);
        g.gridy+=1;
        g.gridx=1;
        add(edit);

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

    public void goBack(){
        parent.update(type);
    }
    public void goEdit(){

    }
}


