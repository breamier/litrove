import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class LiteratureBlock extends JPanel {
    String type;
    String title;
    String subDesc;
    MenuViewLiterature parent;

    public LiteratureBlock(String type, String title, String subDesc, MenuViewLiterature parent, boolean canDelete) {
        this.type = type;
        this.title = title;
        this.subDesc = subDesc;
        this.parent = parent;
        JLabel titleLabel = new DecoratedLabel(title, "title");
        JLabel subDescLabel = new DecoratedLabel(subDesc, "subtitle");
        JButton view = new JButton("View");
        JButton delete = new JButton("delete");

        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(0,0,0,0);
        g.gridy = 0;
        g.gridx = 0;
        view.addActionListener(e -> view());
        delete.addActionListener(e -> delete());
        add(titleLabel,g);

        
        if (canDelete) {
            g.gridx=1;
            add(subDescLabel,g);
            g.gridx=2;
            add(view);
            g.gridx=3;
            add(delete,g);
        }else{
            g.gridy = 1;
            g.gridx = 0;
            add(subDescLabel,g);
            g.gridy = 0;
            g.gridx = 2;
            add(view,g);
        }
        
    }

    private void view() {
        parent.gotoLiterature(title, type);
    }

    private void delete() {
        FileIOManager.deleteLit(type, title);
        parent.update(type);

    }

}