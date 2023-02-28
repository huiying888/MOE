public class PrincipalName {

    private String f_name;
    private String m_name;
    private String l_name;

    public PrincipalName(String fname, String mname, String lname){
        this.f_name=fname;
        this.m_name=mname;
        this.l_name=lname;
    }

    public String getF_name(){return f_name;}
    public String getM_name(){return m_name;}
    public String getL_name(){return l_name;}

    public String getFullName(){
        return f_name+" "+m_name+" "+l_name;
    }

}
