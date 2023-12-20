import javax.swing.*;

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
        DecoratedButton view = new DecoratedButton("View", "individual");
        DecoratedButton delete = new DecoratedButton("delete", "individual");

        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(0,0,0,0);
        g.gridy = 0;
        g.gridx = 0;
        view.addActionListener(e -> view());
        delete.addActionListener(e -> delete());
        add(titleLabel,g);
        if (canDelete) {
            g.insets = new Insets(5,5,5,10);
            g.gridx=1;
            add(subDescLabel,g);
            g.insets = new Insets(5,5,5,5);
            g.gridx=2;
            add(view);
            g.gridx=3;
            add(delete,g);
        }else{
            g.insets = new Insets(5,5,5,5);
            g.gridy = 1;
            g.gridx = 0;
            add(subDescLabel,g);
            g.gridy = 0;
            g.gridx = 2;
            g.gridheight = 2;
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