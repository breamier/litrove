import javax.swing.*;
import java.awt.*;

public class IndividualLiterature extends JPanel {
    String[] descriptions;
    String[] descTitles;
    String type;
    MenuViewLiterature parent;
    int size;
    GridBagConstraints g = AppVars.getGridBagConstraints();

    public IndividualLiterature(String[] desc, String[] descTitles, String type, MenuViewLiterature parent) {
        this.descTitles = descTitles;
        this.descriptions = desc;
        this.size = descTitles.length;
        this.type = type;
        this.parent = parent;
        setLayout(new GridBagLayout());
        showDescription();
    }

    public void addLabels() {
        int num = descriptions.length;
        g.weightx = 0.1;
        for (int i = 1; i < num; i++) {
            g.gridy = i;
            DecoratedLabel temp = new DecoratedLabel(descTitles[i] + ": " + descriptions[i], "subtitle");
            add(temp, g);
        }
    }

    public void goBack() {
        parent.remove(this);
        parent.update(type);
    }

    public void goEdit() {
        removeAll();
        g.gridy = 0;
        g.gridx = 0;
        LiteraturePanel panel = LiteraturePanel.generatePanel(type.toLowerCase(), descriptions);
        add(panel, g);
        JButton save = new JButton("Save");
        save.addActionListener(e -> save(panel));
        g.gridy = 1;
        add(save, g);
        revalidate();
        repaint();

    }

    public void save(LiteraturePanel panel) {
        String[] data = panel.getData();
        FileIOManager.deleteLit(type, descriptions[0]);
        FileIOManager.newLit(type, data);
        parent.gotoLiterature(data[0], type);

    }

    public void showDescription() {
        removeAll();
        JLabel title = new DecoratedLabel(descriptions[0], "title");

        DecoratedButton edit = new DecoratedButton("Edit", "individual");
        DecoratedButton back = new DecoratedButton("Back", "individual");

        back.addActionListener(e -> goBack());
        edit.addActionListener(e -> goEdit());
        g.weightx = 0.3;
        g.gridx = 0;
        add(title, g);
        addLabels();
        g.gridy += 1;
        add(back);
        g.gridy += 1;
        g.gridx = 1;
        add(edit);
        revalidate();
        repaint();
    }
}
