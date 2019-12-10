package dk.aau.model;

public class PatientModel {
    private  String name;
    private  String address;
    private  String cprNumber;
    
    // Constructor
    public PatientModel(String name, String address, String cprNumber) {
        this.name = name;
        this.address = address;
        this.cprNumber = cprNumber;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getCprNumber() {
        return cprNumber;
    }
    
}