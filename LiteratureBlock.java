import javax.swing.*;
import java.awt.*;

public class LiteratureBlock extends JPanel{
    String type;
    String title;
    String subDesc;
    public LiteratureBlock(String type,String title, String subDesc){
        this.type = type;
        this.title = title;
        this.subDesc = subDesc;
        System.out.println("Type: "+type);
        setLayout(new FlowLayout());
        JLabel titleLabel = new JLabel(title);
        JLabel subDescLabel = new JLabel(subDesc);
        JButton view = new JButton("View");
        JButton delete = new JButton("delete");

        view.addActionListener(e -> view());
        delete.addActionListener(e -> delete());
        add(titleLabel);
        add(subDescLabel);
        add(view);
        add(delete);
    }
    private void view(){}
    private void delete(){
        FileIOManager.deleteLit(type,title);

    }


}