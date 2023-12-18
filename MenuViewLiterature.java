import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MenuViewLiterature extends JPanel{
    private String[] types = {"book","movie","article","research","podcast"};
    JPanel actions;
    GridBagConstraints g;
    JComboBox<String> litChoice = new JComboBox<String>(types);
    String litType;
    public MenuViewLiterature(String litType){
            this.litType = litType.toLowerCase();
            setLayout(new GridBagLayout());
            g = AppVars.getGridBagConstraints();
            actions = new JPanel();
            litChoice.addActionListener(e -> update(litChoice.getSelectedItem()+""));
            
            



            setLitType();
            actions.add(litChoice);
            g.gridy=0;
            add(actions,g);
            generateList(litType);
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
        add(new IndividualLiterature(desc,descTitles,type,this));
        repaint();
        revalidate();
    }

    public void setLitType(){
        switch (litType) {
            case "book":
                litChoice.setSelectedIndex(0);
                break;
            case "movie":
                litChoice.setSelectedIndex(1);
                break;
            case "article":
                litChoice.setSelectedIndex(2);
            case "research":
                litChoice.setSelectedIndex(3);
            case "podcast":
                litChoice.setSelectedIndex(4);
            default:
                break;
        }
    }
}