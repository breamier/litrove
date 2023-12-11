import javax.swing.*;
import java.awt.*;

public class AddLitScreen {
    public void startScreen() {
        DefaultFrame home = new DefaultFrame("Add Lit Screen");

        JPanel textPanel = new JPanel();
        JLabel titleText = new JLabel();
        titleText.setAlignmentX(JLabel.CENTER);
        titleText.setAlignmentY(JLabel.CENTER);
        titleText.setText("Add Your Literature");
        textPanel.setBackground(Color.GRAY);
        textPanel.add(titleText);

        ActionButtons actions = new ActionButtons();
        home.add(textPanel, BorderLayout.CENTER);
        home.add(actions, BorderLayout.SOUTH);
        home.pack();

    }
}