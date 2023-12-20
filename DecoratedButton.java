import javax.swing.*;
import java.awt.*;

public class DecoratedButton extends JButton {
    public DecoratedButton(String text, String typeButton) {
        super(text);
        switch (typeButton) {
            case "main":
                decorateMainButton();
                break;
            case "additional":
                decorateAdditionalButton();
                break;
        }

    }

    // Decorates Main Buttons
    private void decorateMainButton() {
        setFont(new Font("Garamond", Font.BOLD, 18));
        setForeground(Color.WHITE);
        setBackground(AppVars.accent1);
        setPreferredSize(new Dimension(190, 50));
        setBorder(BorderFactory.createRaisedBevelBorder());

    }

    // Decorates Additional Buttons
    private void decorateAdditionalButton() {
        setFont(new Font("Arial", Font.BOLD, 12));
        setForeground(Color.WHITE);
        setBackground(AppVars.accent2);
        setPreferredSize(new Dimension(120, 35));
        setBorder(BorderFactory.createRaisedBevelBorder());

    }
}
