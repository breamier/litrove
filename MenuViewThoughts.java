import javax.swing.*;
import java.util.List;

public class MenuViewThoughts extends MenuViewLiterature {
    MenuViewThoughts(String type) {
        super(type);
        super.title.setText("View your thoughts");
    }

    @Override
    public void generateList(String type){
        List<Literature> litList = FileIOManager.readLit(type);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS)); 
        for(Literature lit:litList){
            JPanel panel = new JPanel();
            String title = lit.getDefault(0);
            String subtitle = lit.getDefault(1);
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc(subtitle),this,true);
            panelMain.add(panel);
        }
        scroller = new JScrollPane(panelMain);
        g.gridx =0;
        g.gridy = 2;
        g.weighty = 1;
        add(scroller,g);

    }

}