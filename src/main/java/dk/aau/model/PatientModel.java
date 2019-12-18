package dk.aau.model;

public class PatientModel {
    private  String name;
    private  String address;
    private  Integer cprNumber;
    private  Integer postalCode;
    private  String city;
    
    // Constructor
    public PatientModel(String name, String address, Integer cprNumber, Integer postalCode, String city) {
        this.name = name;
        this.address = address;
        this.cprNumber = cprNumber;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Integer getCprNumber() {
        return cprNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }
    
}