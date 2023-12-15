import java.awt.*;


public class AppVars{
    static Color main1 = new Color(0x38785e);
    static Color main2 = new Color(0xc2a25d);
    static Color accent1 = new Color(0x06543c);
    static Color accent2 = new Color(0xad8d49);
    static GridBagConstraints g = new GridBagConstraints();


    public static Color getMain1() {
        return main1;
    }
    public static Color getMain2() {
        return main2;
    }
    public static Color getAccent1() {
        return accent1;
    }
    public static Color getAccent2() {
        return accent2;
    }
    public static GridBagConstraints getGridBagConstraints(){
        g.gridx = 0;
        g.gridy = 0;
        g.fill = GridBagConstraints.BOTH;
        g.weightx = g.weighty = 1.0;
        return g;
    }

    
}