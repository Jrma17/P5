package dk.aau.model;



public class PatientModel {
    private static String name;
    private static String adress;
    private static String cprNumber;

<<<<<<< Updated upstream
    // Constructor
=======
>>>>>>> Stashed changes
    public PatientModel(String name, String adress, String cprNumber) {
        this.name = name;
        this.adress = adress;
        this.cprNumber = cprNumber;
    }

<<<<<<< Updated upstream
    // Getter og Setter
=======
    //Getter og Setter
>>>>>>> Stashed changes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    
    
}