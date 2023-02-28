public class Address {

    private String unitno;
    private String street;
    public Address(String unitno, String street){
        this.unitno=unitno;
        this.street=street;

    }

    public String getAddress(){
        return unitno+" "+street;
    }


}
