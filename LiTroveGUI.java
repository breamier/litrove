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
        DecoratedButton homeB = new DecoratedButton("Home Screen", "main");
        DecoratedButton addLit = new DecoratedButton("Add Literature", "main");
        DecoratedButton viewLit = new DecoratedButton("View Literature", "main");
        DecoratedButton viewThoughts = new DecoratedButton("View Thoughts", "main");
        DecoratedButton exit = new DecoratedButton("Exit", "main");
        homeB.addActionListener(e -> changeMenu(homeB.getText(), "None"));
        addLit.addActionListener(e -> changeMenu(addLit.getText(), "None"));
        viewLit.addActionListener(e -> changeMenu(viewLit.getText(), "book"));
        viewThoughts.addActionListener(e -> changeMenu(viewThoughts.getText(), "book"));
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
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
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
            case "View Thoughts":
                menu = new MenuViewThoughts(litType);
                ;
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