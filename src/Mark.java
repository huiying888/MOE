public class Mark {

    private String name;
    private String ID;
    private float score;
    private String class_name;

    public Mark(String name, String ID, float score, String class_name){
        this.name=name;
        this.ID=ID;
        this.score=score;
        this.class_name=class_name;

    }

    public String getName(){return name;}
    public String getID(){return ID;}
    public float getScrore(){return score;}
    public String getClass_name(){return class_name;}
}
