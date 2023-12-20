import javax.swing.*;
import java.awt.*;

public class DecoratedLabel extends JLabel {
    public DecoratedLabel(String text, String typeTitle) {
        super(text);
        switch (typeTitle) {
            case "title":
                decorateTitle();
                break;
            case "subtitle":
                decorateSubtitle();
                break;
        }
    }

    private void decorateTitle() {
        setFont(new Font("Garamond", Font.BOLD, 16));
        setForeground(AppVars.accent1);
    }

    private void decorateSubtitle() {
        setFont(new Font("Garamond", Font.BOLD, 12));
        setForeground(AppVars.accent2);
    }
}
