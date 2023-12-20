import javax.swing.*;
import java.awt.*;

public class LiteraturePanel extends JPanel{
    public static String[] genres = {"fiction", "non-fiction", "fantasy", "sci-fi"};
    public static String[] ratings = {"1","2","3","4","5"};
    public static String[] status = {"to read","reading","read"};
    

    public JComponent[] components;
    public String fieldTitles[];
    public String fieldTypes[];
    public String fieldData[];    
    public int size;
    public LiteraturePanel(String[] fieldTitles, String[] fieldTypes){
        this.fieldTitles = fieldTitles;
        this.fieldTypes = fieldTypes;
        this.size = fieldTitles.length;
        
        setLayout(new GridBagLayout());
        
        
        JLabel[] fieldLabels = createLabels(fieldTitles);
        components = createComponents();
        addComponents(this, fieldLabels,0,true);
        addComponents(this, components,1,false);
    }
    public LiteraturePanel(String[] fieldTitles, String[] fieldTypes, String[] data){
        this.fieldTitles = fieldTitles;
        this.fieldTypes = fieldTypes;
        this.size = fieldTitles.length;
        
        setLayout(new GridBagLayout());
        
        
        JLabel[] fieldLabels = createLabels(fieldTitles);
        components = createComponents(data);
        addComponents(this, fieldLabels,0,true);
        addComponents(this, components,1,false);
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
            JLabel temp = new JLabel(labels[i]);
            temp.setForeground(AppVars.getMain2());
            temp.setFont(new Font("Helvetica", Font.PLAIN, 20));

            jlabels[i] = temp;
        }
        return jlabels;
    }

    public JComponent[] createComponents(){
        JComponent comp[] = new JComponent[size];
        for(int i = 0;i<size;i++){
            String x = fieldTypes[i];
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
                    switch(fieldTitles[i]){
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
    public JComponent[] createComponents(String[] data){
        JComponent comp[] = new JComponent[size];
        for(int i = 0;i<size;i++){
            String x = fieldTypes[i];
            switch(x){
                case "textArea":
                    comp[i] = new JTextArea(data[i]);
                    break;
                case "textField":
                    comp[i] = new JTextField(data[i]);
                    break;
                case "checkboxes":
                    comp[i] = addCheckboxes(genres);
                    break;
                case "comboBox":
                    switch(fieldTitles[i]){
                        case "Rating":
                            JComboBox<String> tempR = new JComboBox<String>(ratings);
                            tempR.setSelectedItem(data[i]);
                            comp[i] = tempR;
                            
                            break;
                        case "Status":
                            JComboBox<String> tempS = new JComboBox<String>(status);
                            tempS.setSelectedItem(data[i]);
                            comp[i] = tempS;
                            break;
                    }
                    break;
            }
        }
        return comp;
    }

    public void addComponents(JPanel panel,JComponent[] components, int x, Boolean isLabel){
        GridBagConstraints g = AppVars.getGridBagConstraints();
        g.gridx = x;
        if(isLabel){g.weightx=0.1;}

        for(int i = 0; i<size;i++){ 
            g.gridy=i;
            panel.add(components[i],g);
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
        if(s.equals("")){return "";}
        return s.substring(0,s.length()-1);
    }


    public String[] getData(){
        String[] data= new String[size];
        for(int i=0;i<size;i++){
            switch(fieldTypes[i]){
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

    public static LiteraturePanel generatePanel(String name){
        switch(name){
            case "Book":
                return new BookPanel();
            case "Movie":
                return new MoviePanel();
            case "Article":
                return new ArticlePanel();
            case "Research":
                return new ResearchPanel();
            case "Podcast":
                return new PodcastPanel();
            default:
                return null;
        }

    }
    public static LiteraturePanel generatePanel(String type, String[] data){
            switch(type){
            case "book":
                return new BookPanel(data);
            case "movie":
                return new MoviePanel(data);
            case "article":
                return new ArticlePanel(data);
            case "research":
                return new ResearchPanel(data);
            case "podcast":
                return new PodcastPanel(data);
            default:
                return null;
        }
    }

}

class BookPanel extends LiteraturePanel{
    static String fieldTitles[] = { "Title","Author","Publisher","Genres","Status","Rating","Reflection"};

    static String fieldTypes[] = {"textField","textField","textField","checkboxes","comboBox","comboBox","textArea"};
    public BookPanel(){
        super(fieldTitles,fieldTypes);
    }
    public BookPanel(String[] data){
        super(fieldTitles,fieldTypes,data);
    }
}

class MoviePanel extends LiteraturePanel{
    static String fieldTitles[] = { "Title","Main Actors","Director","Genre","Rating","Reflection" };
    static String fieldTypes[] =   {"textField","textArea","textField","checkboxes","comboBox","textArea"};
    
    public MoviePanel(){
        super(fieldTitles,fieldTypes);
    }
    public MoviePanel(String[] data){
        super(fieldTitles,fieldTypes,data);
    }
}

class ArticlePanel extends LiteraturePanel{
    static String fieldTitles[] = { "Title", "Author", "Reflection" };
    static String fieldTypes[] =   {"textField","textField","textArea"};
    
    public ArticlePanel(){
        super(fieldTitles,fieldTypes);
    }
    public ArticlePanel(String[] data){
        super(fieldTitles,fieldTypes,data);
    }
}
class ResearchPanel extends LiteraturePanel{
    static String fieldTitles[] = { "Title", "Authors", "Year Published", "DOI", "Journal", "Reflection" };
    static String fieldTypes[] =   {"textField","textArea","textField","textField","textField","textArea"};

    
    public ResearchPanel(){
        super(fieldTitles,fieldTypes);
    }
    public ResearchPanel(String[] data){
        super(fieldTitles,fieldTypes,data);
    }
}
class PodcastPanel extends LiteraturePanel{
    static String fieldTitles[] = { "Episode Title", "Podcast Name", "Creator", "Rating", "Reflection" };
    static String fieldTypes[] =  { "textField","textField","textField", "comboBox","textArea"};

    
    public PodcastPanel(){
        super(fieldTitles,fieldTypes);
    }
    public PodcastPanel(String[] data){
        super(fieldTitles,fieldTypes,data);
    }
}

