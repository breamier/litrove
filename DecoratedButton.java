import javax.swing.*;
import java.awt.*;

public class DecoratedButton extends JButton {
    public DecoratedButton(String text) {
        super(text);
        decorateButton();
    }

    private void decorateButton() {
        setFont(new Font("Dancing Script", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setBackground(AppVars.accent1);
        setPreferredSize(new Dimension(190, 50));
        setBorder(BorderFactory.createRaisedBevelBorder());

    }
}
