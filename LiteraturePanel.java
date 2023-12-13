import javax.swing.*;
//import java.awt.*;

public class LiteraturePanel extends JPanel{
    JPanel addCheckboxes(String names[]){
        JPanel checkboxes = new JPanel();

        for(String name : names){
            checkboxes.add(new JCheckBox(name));
        }
        return checkboxes;
    }

}

