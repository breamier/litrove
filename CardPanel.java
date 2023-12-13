import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CardPanel extends JPanel{
    private CardLayout cl;


    public CardPanel() throws IOException{
        cl = new CardLayout();
        setSize(300,150);
        setLayout(cl);      
    }

    public void showCard(String value){
        System.out.println(value);
        cl.show(this,value);
    }
    public void addCard(JPanel panel,String ref){
        add(panel,ref);
    }

}

