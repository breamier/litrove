import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HomePanel extends JPanel {

    Image image;

    public HomePanel() {

        try {
            image = ImageIO.read(getClass().getResource("LiTrove.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel imageLabel = new JLabel(new ImageIcon(image));

        add(imageLabel);
        setBackground(AppVars.getMain2());
    }

}