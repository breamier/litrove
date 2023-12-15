import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CardPanel extends JPanel{
    private CardLayout cl;


    public CardPanel(){
        cl = new CardLayout();
        setLayout(cl);      
    }

    public void showCard(String value){
        cl.show(this,value);
    }
    public void addCard(JPanel panel,String ref){
        add(panel,ref);
    }

}

