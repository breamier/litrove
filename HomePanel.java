import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class HomePanel extends JPanel{
    public HomePanel() throws IOException{
        Image image = ImageIO.read(getClass().getResource("icon.png"));
        image = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        
        add(imageLabel);
        setBackground(AppVars.getMain2());
    }

}