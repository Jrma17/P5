package dk.aau.model;



public class PatientModel {
    private  String name;
    private  String adress;
    private  String cprNumber;

    public PatientModel(){
        this(null, null, null);
    }

    public PatientModel(String name, String adress, String cprNumber) {
        this.name = name;
        this.adress = adress;
        this.cprNumber = cprNumber;
    }

    //Getter og Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    
    
}