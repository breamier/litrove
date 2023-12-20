import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MenuViewLiterature extends JPanel{
    private String[] types = {"book","movie","article","research","podcast"};
    JPanel actions;
    GridBagConstraints g;
    JComboBox<String> litChoice = new JComboBox<String>(types);
    String litType;
    JLabel title;
    JPanel panelMain;
    JScrollPane scroller;
    JPanel blank = new JPanel();
    public MenuViewLiterature(String litType){
            this.litType = litType.toLowerCase();
            
            g = AppVars.getGridBagConstraints();
            actions = new JPanel();
            title = new DecoratedLabel("View Literature","title");
            title.setFont(new Font("Serif", Font.PLAIN, 30));
            
            litChoice.setSelectedItem(litType.toLowerCase());
            litChoice.addActionListener(e -> update(litChoice.getSelectedItem()+""));
            actions.add(litChoice);
            
            setLayout(new GridBagLayout());

            g.gridy=0;
            g.gridx=0;
            g.weighty =0;
            add(title,g);
            g.gridy = 1;
            g.gridx = 0;
            g.weighty =0;
            add(actions,g);
            
            generateList(litType);
    }

    public void generateList(String type){
        List<Literature> litList = FileIOManager.readLit(type);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS)); 
        for(Literature lit:litList){
            JPanel panel = new JPanel();
            String title = lit.getDefault(0);
            String subtitle = lit.getDefault(1);
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc(subtitle),this,true);
            panelMain.add(panel,g);
        }
        scroller = new JScrollPane(panelMain);
        g.gridx =0;
        g.gridy =2;
        g.weighty = 1;
        add(scroller,g);
        g.gridy = 3;
        g.weighty = 0.1;
        add(blank,g);

    }

    public void update(String litType){
        String lit = litType.toLowerCase();
        removeAll();
        g.gridy=0;
        g.gridx=0;
        g.weighty =0;
        add(title,g);
        g.gridy = 1;
        g.gridx = 0;
        g.weighty =0;
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