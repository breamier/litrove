import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MenuViewThoughts extends MenuViewLiterature{
    MenuViewThoughts(String type){
        super(type);
        super.title.setText("View your thoughts");
    }

    @Override
    public void generateList(String type){
        List<Literature> litList = FileIOManager.readLit(type);
        g.gridy=1;
        for(Literature lit:litList){
            JPanel panel = new JPanel();
            String title = lit.getDefault(0);
            panel = new LiteratureBlock(type,lit.getDesc(title),lit.getDesc("reflection"),this,false);
            add(panel,g);
            g.gridy+=1;
        }

    }
}