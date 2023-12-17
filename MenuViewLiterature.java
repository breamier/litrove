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
            
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc(subtitle),this);
            add(panel,g);
            g.gridy+=1;
        }

    }

    public void update(String litType){
        String lit = litType.toLowerCase();
        removeAll();
        g.gridy=0;
        add(actions,g);
        System.out.println(litType);
        generateList(lit);
            
        repaint();
        revalidate();
    }

    public void gotoLiterature(String title, String type){
        removeAll();
        Literature lit = FileIOManager.searchLit(type,title);

        String[] desc = lit.getDesc();
        System.out.println(desc == null);
        String[] descTitles = lit.getDescTitles();
        add(new IndividualLiterature(desc,descTitles));
        repaint();
        revalidate();
    }

}