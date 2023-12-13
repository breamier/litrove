import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class HomeScreen{
    public void startScreen() throws IOException{
        DefaultFrame home = new DefaultFrame("Home Screen");
        JPanel textPanel = new JPanel();
        JLabel titleText = new JLabel();
        Image image = ImageIO.read(getClass().getResource("icon.png"));
        JLabel label = new JLabel(new ImageIcon(image));
        textPanel.add(label);

        
        
        titleText.setAlignmentX(JLabel.CENTER);
        titleText.setAlignmentY(JLabel.CENTER);
        titleText.setText("Welcome!");
        textPanel.setBackground(Color.GRAY);
        textPanel.add(titleText);


        ActionButtons actions = new ActionButtons();

        home.add(textPanel,BorderLayout.CENTER);
        home.add(actions,BorderLayout.WEST);
        home.pack();

    }

    public static void main(String[] args) throws IOException{
        HomeScreen litrove = new HomeScreen();
        litrove.startScreen();
    }
}