import javax.swing.*;
import java.awt.*;

public class LiteraturePanel extends JPanel{
    public String[] genres = {"fiction", "non-fiction", "fantasy", "sci-fi"};
    public String[] ratings = {"1","2","3","4","5"};
    public String[] status = {"to read","reading","read"};
    
    public JComponent[] components;

    public int size;
    private String[][] fields;
    public LiteraturePanel(){

    }
    public LiteraturePanel(String[][] field){
        fields = field;
        this.size = fields[0].length;
        setLayout(new BorderLayout());
        
        components = createComponents(fields);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        addComponents(fieldPanel, components);

        JLabel[] fieldLabels = createLabels(fields[0]);
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(fields[0].length,1));
        addComponents(labels, fieldLabels);
    
        add(labels,BorderLayout.WEST);
        add(fieldPanel,BorderLayout.CENTER);

        setBackground(Color.RED);
    }

    JPanel addCheckboxes(String names[]){
        JPanel checkboxes = new JPanel();
        for(String name : names){
            checkboxes.add(new JCheckBox(name));
        }
        return checkboxes;
    }

    public JLabel[] createLabels(String[] labels){
        JLabel jlabels[]= new JLabel[size];

        for(int i = 0; i<size;i++){
            jlabels[i] = new JLabel(labels[i]);
        }
        return jlabels;
    }

    public JComponent[] createComponents(String[][] fields){
        JComponent comp[] = new JComponent[size];
        for(int i = 0;i<size;i++){
            String x = fields[1][i];
            switch(x){
                case "textArea":
                    comp[i] = new JTextArea();
                    break;
                case "textField":
                    comp[i] = new JTextField();
                    break;
                case "checkboxes":
                    comp[i] = addCheckboxes(genres);
                    break;
                case "comboBox":
                    switch(fields[0][i]){
                        case "Rating":
                            comp[i] = new JComboBox<String>(ratings);
                            break;
                        case "Status":
                            comp[i] =new JComboBox<String>(status);
                            break;
                    }
                    break;

            }
        }
        return comp;
    }
    public void addComponents(JPanel panel,JComponent[] components){
        for(int i = 0; i<size;i++){
            panel.add(components[i]);
       }
    }

    public String getChecked(JPanel panel){
        Component[] checkboxes=panel.getComponents();
        String s="";
        int compSize = checkboxes.length;
        for(int i =0;i<compSize;i++){
            JCheckBox a = (JCheckBox)checkboxes[i];
            if(a.isSelected()){
                s+=a.getText()+",";
            }
        }
        return s.substring(0,s.length()-1);
    }
    public String[] getData(){
        String[][] fields=this.fields;
        String[] data= new String[size];
        for(int i=0;i<size;i++){
            switch(fields[1][i]){
                case "textArea":
                    data[i] = ((JTextArea)components[i]).getText();
                    break;
                case "textField":
                    data[i] = ((JTextField)components[i]).getText();
                    break;
                case "checkboxes":
                    data[i] = getChecked((JPanel)components[i]);
                    break;
                case "comboBox":
                    data[i] = (String)((JComboBox)components[i]).getSelectedItem();
            }   
        }
        return data;
    }

    LiteraturePanel generatePanel(String name){
        name = name.toLowerCase();
        switch(name){
            case "book":
                System.out.println("HELO");
                return new BookPanel();
            case "movie":
                return new MoviePanel();
            case "article":
                return new ArticlePanel();
            case "academic article":
                return new AcademicArticlePanel();
            case "podcast":
                return new PodcastPanel();
            default:
                return null;
        }

    }

}

class BookPanel extends LiteraturePanel{
    static String fields[][] = {{  "Title","Author","Publisher","Genres","Status","Rating","Thoughts"},
                                {   "textField","textField","textField","checkboxes","comboBox","comboBox","textArea"}};
    public BookPanel(){
        super(fields);
    }

}

class MoviePanel extends LiteraturePanel{
    static String fields[][] = {{"Title","Main Actors","Director","Genre","Rating","Reflection"},
                                {"textField","textArea","textField","checkboxes","comboBox","textArea"}
    };
    public MoviePanel(){
        super(fields);
    }

}
class ArticlePanel extends LiteraturePanel{
    static String fields[][] = {{"Title","Author","Reflection"},
                                {"textField","textArea","textArea"}
    };
    public ArticlePanel(){
        super(fields);
    }

}
class AcademicArticlePanel extends LiteraturePanel{
    static String fields[][] = {{"Title","Authors","Date Published","DOI","Journal","Reflection"},
                                {"textField","textField","textField","textField","textField","textArea"}
    };
    public AcademicArticlePanel(){
        super(fields);
    }

}
class PodcastPanel extends LiteraturePanel{
    static String fields[][] = {{"Title","Episode Title / Num","Creator","Rating","Reflection"},
                                {"textField","textField","textField","comboBox","textArea"}
    };
    public PodcastPanel(){
        super(fields);
    }

}