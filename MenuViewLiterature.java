import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MenuViewLiterature extends JPanel{
    private String[] types = {"Book","Movie","Article","Research","Podcast"};
    JPanel actions;
    GridBagConstraints g;
    public MenuViewLiterature(){
            setLayout(new GridBagLayout());
            g = AppVars.getGridBagConstraints();
            actions = new JPanel();
            JComboBox<String> litChoice = new JComboBox<String>(types);

            litChoice.addActionListener(e -> update(litChoice.getSelectedItem()+""));
            
            actions.add(litChoice);
            g.gridy=0;
            add(actions,g);
    }
    public void generateList(String type){
        List<Literature> litList = FileIOManager.readLit(type);
        g.gridy=1;
        for(Literature lit:litList){
            JPanel panel = new JPanel();
            String title = lit.getDefault(0);
            String subtitle = lit.getDefault(1);
            
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc(subtitle));
            add(panel,g);
            g.gridy+=1;
        }

    }

    public void update(String litType){
            String lit = litType.toLowerCase();
            removeAll();
            System.out.println("REMOVED");
            g.gridy=0;
            add(actions,g);
            System.out.println("ADDED ACTIONS");
            System.out.println(litType);
            generateList(lit);
            
            repaint();
            System.out.println("repainted");
            revalidate();
            System.out.println("revalidated");
    }

}