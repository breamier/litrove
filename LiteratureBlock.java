import javax.swing.*;
import java.awt.*;

public class LiteratureBlock extends JPanel{
    public LiteratureBlock(String type,String title, String subDesc){
        setLayout(new FlowLayout());
        JLabel titleLabel = new JLabel(title);
        JLabel subDescLabel = new JLabel(subDesc);
        JButton view = new JButton("View");
        JButton delete = new JButton("delete");

        view.addActionListener(e -> view() );
        delete.addActionListener(e -> delete(type,title));
        add(titleLabel);
        add(subDescLabel);
        add(view);
        add(delete);
    }
    private void view(){}
    private void delete(String type, String title){
        FileIOManager.deleteLit(type,title);
        ((ViewLiteraturePanel)this.getParent().getParent()).changeView(type);

    }


}