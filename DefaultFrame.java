import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame{
    public DefaultFrame(String title){
        super(title);
        this.setSize(500, 500);
        // this.setResizable(false);
        this.setLayout(new BorderLayout());  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
    }
}