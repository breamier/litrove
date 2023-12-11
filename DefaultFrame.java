import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame{
    public DefaultFrame(String title){
        super(title);
        this.setSize(500, 500);
        // this.setResizable(false);
        this.setLayout(new BorderLayout());  
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
        this.setVisible(true);  

        ImageIcon image = new ImageIcon("icon.png");
        this.setIconImage(image.getImage());
    }
}