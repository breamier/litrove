import javax.swing.*;
import java.awt.*;

public class HomeScreen{
    public void startScreen(){
        DefaultFrame home = new DefaultFrame("Home Screen");

        JPanel textPanel = new JPanel();
        JLabel titleText = new JLabel();
        titleText.setAlignmentX(JLabel.CENTER);
        titleText.setAlignmentY(JLabel.CENTER);
        titleText.setText("Welcome!");
        textPanel.setBackground(Color.GRAY);
        textPanel.add(titleText);

        ActionButtons actions = new ActionButtons();
        home.add(textPanel,BorderLayout.CENTER);
        home.add(actions,BorderLayout.SOUTH);
        home.pack();

    }

    public static void main(String[] args){
        HomeScreen litrove = new HomeScreen();
        litrove.startScreen();
    }
}