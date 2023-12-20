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
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc("reflection"),this,false);
            panelMain.add(panel);
        }
        scroller = new JScrollPane(panelMain);
        g.gridx =0;
        g.gridy = 2;
        g.weighty = 1;
        add(scroller,g);
        g.gridy = 3;
        g.weighty = 0.1;
        add(blank,g);

    }

}