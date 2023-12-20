import javax.swing.*;
import java.awt.*;

public class LiteratureBlock extends JPanel{
    String type;
    String title;
    String subDesc;
    MenuViewLiterature parent;
    public LiteratureBlock(String type,String title, String subDesc, MenuViewLiterature parent, boolean canDelete){
        this.type = type;
        this.title = title;
        this.subDesc = subDesc;
        this.parent = parent;
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
        if(canDelete){add(delete);}
    }
    private void view(){
        parent.gotoLiterature(title, type);
    }
    private void delete(){
        FileIOManager.deleteLit(type,title);
        parent.update(type);

    }


}