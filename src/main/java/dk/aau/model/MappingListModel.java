package dk.aau.model;

public class MappingListModel{
    private String selectedIcpc;
    private String mappedIcdCodes;
    private String allMappedIcpcToIcd;
    private String selectedIcdCode;


    //Getter og Setter
    public String getSelectedIcpc() {
        return selectedIcpc;
    }

    public void setSelectedIcpc(String selectedIcpc) {
        this.selectedIcpc = selectedIcpc;
    }

    public String getMappedIcdCodes() {
        return mappedIcdCodes;
    }

    public void setMappedIcdCodes(String mappedIcdCodes) {
        this.mappedIcdCodes = mappedIcdCodes;
    }

    public String getAllMappedIcpcToIcd() {
        return allMappedIcpcToIcd;
    }

    public void setAllMappedIcpcToIcd(String allMappedIcpcToIcd) {
        this.allMappedIcpcToIcd = allMappedIcpcToIcd;
    }

    public String getSelectedIcdCode() {
        return selectedIcdCode;
    }

    public void setSelectedIcdCode(String selectedIcdCode) {
        this.selectedIcdCode = selectedIcdCode;
    }
}