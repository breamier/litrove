import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class HomePanel extends JPanel{
    public HomePanel() throws IOException{
        Image image = ImageIO.read(getClass().getResource("icon.png"));
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel);
    }

}