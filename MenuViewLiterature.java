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
            litChoice.setSelectedItem(litType);
            litChoice.addActionListener(e -> update(litChoice.getSelectedItem()+""));
            actions.add(litChoice);
            g.gridy=0;
            g.anchor= GridBagConstraints.PAGE_START;
            add(actions,g);
            generateList(litType);
    }

    public void generateList(String type){
        List<Literature> litList = FileIOManager.readLit(type);

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridLayout());
        for(Literature lit:litList){
            JPanel panel = new JPanel();
            String title = lit.getDefault(0);
            String subtitle = lit.getDefault(1);
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc(subtitle),this,true);
            panelMain.add(panel,g);
        }
        g.gridx =0;
        g.gridy =1;
        add(panelMain,g);

    }

    public void update(String litType){
        String lit = litType.toLowerCase();
        removeAll();
        g.gridy=0;
        g.gridx=0;
        add(actions,g);
        generateList(lit);
            
        repaint();
        revalidate();
    }

    public void gotoLiterature(String title, String type){
        removeAll();
        Literature lit = FileIOManager.searchLit(type,title);

        String[] desc = lit.getDesc();
        String[] descTitles = lit.getDescTitles();
        add(new IndividualLiterature(desc,descTitles,type,this));
        repaint();
        revalidate();
    }

}