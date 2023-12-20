import javax.swing.*;
import java.awt.*;


public class MenuAddLiterature extends JPanel{
        private String[] types = {"Book","Movie","Article","Research","Podcast"};
        LiteraturePanel labelsFields;
        JPanel actions;
        GridBagConstraints g;
        LiTroveGUI parent;
        JLabel title;
        public MenuAddLiterature(LiTroveGUI parent){                
                JPanel actions = new JPanel();
                JButton save = new JButton("Save");
                JButton addAnother = new JButton("Add Another");
                JComboBox<String> litChoice = new JComboBox<String>(types);
                
                this.parent = parent;
                g = AppVars.getGridBagConstraints();
                title = new JLabel("Add Your Literature.");
                labelsFields = LiteraturePanel.generatePanel(types[0]);
        

                litChoice.addActionListener(e -> changeLiteraturefields(litChoice.getSelectedItem()+""));
                save.addActionListener(e -> save(litChoice.getSelectedItem()+""));
                addAnother.addActionListener(e -> addAnother(litChoice.getSelectedItem()+""));
                
                actions.add(litChoice);
                actions.add(save);
                actions.add(addAnother);

                setLayout(new GridBagLayout());
                g.gridy=0;
                g.gridx=1;
                add(title,g);
                g.gridy=1;
                add(actions,g);
                g.gridy=2;
                add(labelsFields,g);

        }


        public void changeLiteraturefields(String litType){
                this.remove(labelsFields);
                labelsFields = LiteraturePanel.generatePanel(litType);
                g.gridy=1;
                add(labelsFields,g);
                repaint();
                revalidate();
        }
        public void save(String type){
                String[] data = labelsFields.getData();
                int i=0;
                while(true){
                    if(type.equals(types[i])){break;}
                    i+=1; 
                }
                FileIOManager.newLit(type.toLowerCase(), data);
                parent.changeMenu("View Literature",type);
        }

        public void addAnother(String type){
                String[] data = labelsFields.getData();
                int i =0;
                while(true){
                        if(type.equals(types[i])){break;}
                        i+=1;
                }
                FileIOManager.newLit(type, data);
                changeLiteraturefields(type);
        }


}