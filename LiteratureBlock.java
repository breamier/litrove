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

        view.addActionListener(e -> view());
        delete.addActionListener(e -> delete());
        add(titleLabel);

        if (canDelete) {
            add(subDescLabel);
            add(view);
            add(delete);
        } else {
            add(subDescLabel);
            add(view);
        }

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(50, 10));

    }

    private void view() {
        parent.gotoLiterature(title, type);
    }

    private void delete() {
        FileIOManager.deleteLit(type, title);
        parent.update(type);

    }

}