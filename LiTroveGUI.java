import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LiTroveGUI extends JFrame {
    LiTroveGUI app;
    JPanel menu;
    JPanel actions;
    GridBagConstraints g;

    public void start() {
        setLayout(new GridBagLayout());
        g = AppVars.getGridBagConstraints();

        menu = new HomePanel();
        actions = new JPanel();
        JButton homeB = new JButton("Home Screen");
        JButton addLit = new JButton("Add Literature");
        JButton viewLit = new JButton("View Literature");
        JButton viewThoughts = new JButton("View Thoughts");
        JButton exit = new JButton("Exit");
        homeB.addActionListener(e -> changeMenu(homeB.getText(), "None"));
        addLit.addActionListener(e -> changeMenu(addLit.getText(), "None"));
        viewLit.addActionListener(e -> changeMenu(viewLit.getText(), "book"));
        viewThoughts.addActionListener(e -> changeMenu(viewThoughts.getText(), "None"));
        exit.addActionListener(e -> exitProgram());

        actions.setLayout(new GridBagLayout());
        g.weightx = g.weighty = 0;
        g.gridy = 0;
        actions.add(homeB, g);
        g.gridy = 1;
        actions.add(addLit, g);
        g.gridy = 2;
        actions.add(viewLit, g);
        g.gridy = 3;
        actions.add(viewThoughts, g);
        g.gridy = 4;
        actions.add(exit, g);
        actions.setBackground(AppVars.getMain1());

        g.weightx = g.weighty = 0;
        g.gridx = 0;
        add(actions, g);
        g.gridx = 1;
        g.weightx = g.weighty = 1;
        add(menu, g);
        pack();
        setSize(700, 500);
        setResizable(true);
        setVisible(true);

    }

    public void changeMenu(String type, String litType) {
        this.remove(menu);

        switch (type) {
            case "Home Screen":
                menu = new HomePanel();
                break;
            case "Add Literature":
                menu = new MenuAddLiterature(this);
                break;
            case "View Literature":
                menu = new MenuViewLiterature(litType);
                break;
            default:
                break;
        }

        g.weightx = g.weighty = 0;
        g.gridx = 0;
        add(actions, g);
        g.gridx = 1;
        g.weightx = g.weighty = 1;
        add(menu, g);

        this.repaint();
        this.revalidate();

    }

    private void exitProgram() {
        this.dispose();
    }

    public static void main(String[] args) throws IOException {
        LiTroveGUI app = new LiTroveGUI();
        app.start();
    }

}