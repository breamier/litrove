public class Literature{
    String[] litDefault;
    String[] desc;
    public Literature(String[] litDefault, String[] desc){
        this.litDefault = litDefault;
        this.desc = desc;
    }
    // 
    // Literature lit = new Literature();
    // lit.getDesc();

    // get("Title") return title na string
    public String getDesc(String type){
        int index = 0;
        for (String description:litDefault){
            if (description.equals(type)){
                return this.desc[index];
            }
            index += 1;
        }
        return "";
    }

    public void setDesc(String type, String name){
        int index = 0;
        for (String description:litDefault){
            if (description.equals(type)){
                // return this.desc[index];
            }
            index += 1;
        }

        // insert replace the thingy on the .txt
    }
}

class Book extends Literature {
    // defaultDesc -> descType
    public static String[] defaultDesc = { "Title","Author","Publisher","Genres","Status","Rating","Reflection"};
    public Book(){
        super(defaultDesc,defaultDesc);
    }
    public Book(String[] desc){
        super(defaultDesc,desc);
    }
}

class Podcast extends Literature{
    public static String[] defaultDesc ={"Title","Episode Title / Num","Creator","Rating","Reflection"};


}
    