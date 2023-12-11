import javax.swing.*;
import java.awt.*;

public class ActionButtons extends JPanel {
    public ActionButtons() {
        JButton addLit = new JButton("Add Literature");
        JButton viewLit = new JButton("View Literature");
        JButton viewThoughts = new JButton("View Thoughts");
        JButton exit = new JButton("Exit");

        addLit.addActionListener(e -> changeScreen("addLit"));
        viewLit.addActionListener(e -> changeScreen("viewLit"));
        viewThoughts.addActionListener(e -> changeScreen("viewThoughts"));


        setLayout(new FlowLayout());
        add(addLit);
        add(viewLit);
        add(viewThoughts);
        add(exit);
        setPreferredSize(new Dimension(500, 50));
        setPreferredSize(new Dimension(80,500));
        setBackground(Color.GRAY);

    }

    public void changeScreen(String screen) {
        switch (screen) {
            case "addLit":
                AddLiteratureScreen addLit = new AddLiteratureScreen();
                break;
            case "exit":
        
            default:
                break;
        }
    }
}
