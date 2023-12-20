import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class HomePanel extends JPanel{
        
    Image image;
    public HomePanel(){
        
        try {
            image = ImageIO.read(getClass().getResource("icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        
        add(imageLabel);
        setBackground(AppVars.getMain2());
    }

}