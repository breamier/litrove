import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MainApp extends JFrame{
    public void start() throws IOException{
        String[] cardName = {"Home Screen","Add Literature","View Literature","View Thoughts"};
        setLayout(new GridBagLayout());
        GridBagConstraints g = AppVars.getGridBagConstraints();

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

        
        actions.setLayout(new GridBagLayout());
        g.weightx =g.weighty=0;
        g.gridy=0;
        actions.add(homeB,g);
        g.gridy=1;
        actions.add(addLit,g);
        g.gridy=2;
        actions.add(viewLit,g);
        g.gridy=3;
        actions.add(viewThoughts,g);
        g.gridy=4;
        actions.add(exit,g);
        actions.setBackground(AppVars.getMain1());


        
        AddLiteraturePanel addLitPanel = new AddLiteraturePanel();
        HomePanel home = new HomePanel();
        ViewLiteraturePanel viewLitPanel = new ViewLiteraturePanel();

        cards.addCard(home, cardName[0]);
        cards.addCard(addLitPanel, cardName[1]);
        cards.add(viewLitPanel,cardName[2]);

        
        g.weightx =g.weighty=1;
        g.gridx = 0;
        add(actions,g);
        g.gridx = 1;
        add(cards,g);

        setResizable(false);
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

