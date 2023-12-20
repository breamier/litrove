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
                title = new DecoratedLabel("Add Your Literature.","title");
                title.setAlignmentX(CENTER_ALIGNMENT);
                title.setBackground(Color.RED);
                title.setFont(new Font("Serif", Font.PLAIN, 30));
                labelsFields = LiteraturePanel.generatePanel(types[0]);
        

                litChoice.addActionListener(e -> changeLiteraturefields(litChoice.getSelectedItem()+""));
                save.addActionListener(e -> save(litChoice.getSelectedItem()+""));
                addAnother.addActionListener(e -> addAnother(litChoice.getSelectedItem()+""));
                
                actions.add(litChoice);
                actions.add(save);
                actions.add(addAnother);

                setLayout(new GridBagLayout());
                g.gridy=0;
                g.gridx=0;
                g.weightx = 0;
                g.weighty = 0;
                g.insets = new Insets(10,20,0,0);
                add(title,g);
                g.weightx =0;
                g.weighty = 0;
                g.gridy=1;
                g.insets = new Insets(10,40,0,0);
                add(actions,g);
                g.insets = new Insets(0,0,0,0);
                g.weighty = 1;
                g.weightx = 1;
                g.gridy=2;
                add(labelsFields,g);


        }


        public void changeLiteraturefields(String litType){
                this.remove(labelsFields);
                labelsFields = LiteraturePanel.generatePanel(litType);
                g.gridy=2;
                g.gridx = 0;
                g.weighty = 1;
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
