import javax.swing.*;
import java.awt.*;

public class ActionButtons extends JPanel{
    public ActionButtons(){
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
        setPreferredSize(new Dimension(500,50));
        setBackground(Color.GRAY);
        
    }

    public void changeScreen(String screen){
        switch (screen) {
            case "addLit":
                System.out.println("Add Literature Pressed");
                AddLitScreen addLit = new AddLitScreen();
                addLit.startScreen();
                break;
            case "viewLit":
                System.out.println("View Literature Pressed");
                break;
            case "viewThoughts":
                System.out.println("View Thougts Pressed");
                break;
            case "exit":

                break;
        }
    }
}
