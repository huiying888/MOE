public class School {

    String school_name;
    Address address;
    PrincipalName principalName;

    MarkList markList;


    public School(String school_name,PrincipalName principalName, Address address,MarkList markList){
        this.school_name=school_name;
        this.address=address;
        this.principalName=principalName;
        this.markList=markList;

    }

    public String getSchool_name(){return school_name;}
    public PrincipalName getprincipalName(){return principalName;}
    public Address getAddress(){return address;}
    public MarkList getMarkList(){return markList;}


}
