import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainApp extends JFrame{
    public void start() throws IOException{
        String[] cardName = {"Home Screen","Add Literature","View Literature","View Thoughts"};
        setLayout(new BorderLayout());
        
        CardPanel cards = new CardPanel();
        
        JPanel actions = new JPanel();
        JButton homeB = new JButton("Home Screen");
        JButton addLit = new JButton("Add Literature");
        JButton viewLit = new JButton("View Literature");
        JButton viewThoughts = new JButton("View Thoughts");
        JButton exit = new JButton("Exit");
        homeB.addActionListener(e -> cards.showCard(cardName[0]) );
        addLit.addActionListener(e -> cards.showCard(cardName[1]) );
        viewLit.addActionListener(e -> cards.showCard(cardName[2]) );
        viewThoughts.addActionListener(e -> cards.showCard(cardName[3]));
        exit.addActionListener(e -> exitProgram());


        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));
        actions.add(homeB);
        actions.add(addLit);
        actions.add(viewLit);
        actions.add(viewThoughts);
        actions.add(exit);

        actions.setBackground(Color.GRAY);


        
        AddLiteraturePanel addLitPanel = new AddLiteraturePanel();
        HomePanel home = new HomePanel();

        cards.addCard(home, cardName[0]);
        cards.addCard(addLitPanel, cardName[1]);


        add(actions,BorderLayout.WEST);
        add(cards,BorderLayout.CENTER);
        pack();
        setVisible(true);
        



    }
    public void exitProgram(){
        this.dispose();
    }
    public static void main(String[] args) throws IOException{
        MainApp app = new MainApp();
        app.start();
    }
}

