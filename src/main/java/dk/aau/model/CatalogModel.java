package dk.aau.model;

public class CatalogModel {
    private String icdCode;
    private String selectedIcdCode;

    //Getter og Setter
    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getSelectedIcdCode() {
        return selectedIcdCode;
    }

    public void setSelectedIcdCode(String selectedIcdCode) {
        this.selectedIcdCode = selectedIcdCode;
    }

}