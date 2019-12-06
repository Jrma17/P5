package dk.aau.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import dk.aau.model.MappingListModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class MappingListCtrl {

    @FXML
    public ListView<String> listView;

    public StringProperty IsolatedIcdCodes = new SimpleStringProperty(""); 
    private MappingListModel MapStructure = new MappingListModel();
    private HashMap NewMap;

    private String icpcCode;

    public MappingListCtrl() {

    }

    public void setCode(String code) { // Henter ICPCkode værdien fra ReferralCtrl.
        icpcCode = code;
        // System.out.println(ICPCkode + " ICPCKODE in setcode"); //Printer ICPC-koden
        // som er tastet ind i feltet, og kommer fra "ReferralCtrl"

        Object relevanteICD = NewMap.get(icpcCode); // Isolere values fra "NewMap" (HashMap som har ICPC som Key, som
                                                    // hver har en liste af ICD10 values tilkoblet), som har "ICPCKode"
                                                    // (se ^) som key. (Hashmaps returnere objects!) Output eks:
                                                    // (object) [ICD1,ICD2]
        //System.out.println(relevanteICD + "This is object"); // Printer de isolerede values i NewMap ud fra "ICPCkode"

        String val = String.valueOf(relevanteICD); //Omdanner objectet til en string (vi skal bruge en string når vi skal sætte det ind i vores view (ListView)) - Output eks: (String) [ICD1,ICD2]
        
        String[] arrOfStr = val.split(",", 0);// && val.split("[",0); - Splitter en String i flere Strings hver gang der er et ",":
        //Output eks: String 1 [ICD1
                    //String 2 ICD2]   (ja det ser lidt wack ud - se næste)

        for (String IsolatedICDCodes : arrOfStr) { //Gør efterfølgende for alle strings i arrayet. 
            IsolatedICDCodes = IsolatedICDCodes.replace("[", ""); //Erstatter [ med ingenting
            IsolatedICDCodes = IsolatedICDCodes.replace("]", ""); //Erstatter ] med ingenting
            IsolatedICDCodes = IsolatedICDCodes.trim(); //Fjerner eventuelle overskydende mellemrum
            listView.getItems().add(IsolatedICDCodes); //Tilføjer de isolerede og tilpassede værdier til listview (listiew = FXML listView)
        }
    }

    @FXML //Funktionen er tilkoblet ListView i MappingListView.fxml under code -> on mouse clicked og styrer hvad der sker når der klikkes. 
    public void clickItemMap(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) // Der skal dobbelt-klikkes. 
        {
            //System.out.println("der er dobbeltklikket");
            
            IsolatedIcdCodes.set(listView.getSelectionModel().getSelectedItem()); // Tjekker hvilken værdi der er
                                                                                  // trykket på i listView og sætter
                                                                                  // denne i IsolatedICDCodes
            //System.out.println(IsolatedICDCodes + "this is a");

            listView.getScene().getWindow().hide(); //Lukker vinduet når der er dobbeltklikket. 
        }
    }

    public void initialize() { //Initialize køres som det første, efterfølgende køres resterende
        //System.out.println("this is initialize");
        MappingMethod(); //Opsætter hashmappet og dermed mapningen
    }

    public HashMap MappingMethod() { //Metode som opsætter mapning
        
        NewMap = MapStructure.getNewMap(); //NewMap består af MapStructure (som er en struktur for mappet og hentes (getMap) fra mappinglistmodel)
        
        //Alle values er en liste (fordi der kan være flere ICD10 koder til én ICPC kode) - disse oprettes her: 
        List<String> icdToL70 = new ArrayList<String>();
        icdToL70.add("dm865"); icdToL70.add("dm650"); icdToL70.add("dm651"); icdToL70.add("dm710"); icdToL70.add("dm711"); icdToL70.add("dm860"); 
        icdToL70.add("dm861"); icdToL70.add("dm862"); icdToL70.add("dm864"); icdToL70.add("dm866"); icdToL70.add("dm868"); icdToL70.add("dm869"); 
        icdToL70.add("dm018"); icdToL70.add("dm600"); icdToL70.add("dm863"); icdToL70.add("dm009"); icdToL70.add("dm465"); icdToL70.add("dm463"); 
        icdToL70.add("dm008"); icdToL70.add("dm010"); icdToL70.add("dm011"); icdToL70.add("dm012"); icdToL70.add("dm013"); icdToL70.add("dm464"); 
        icdToL70.add("dm015"); icdToL70.add("dm016"); icdToL70.add("dm001"); icdToL70.add("dm462"); icdToL70.add("dm000"); icdToL70.add("dm014"); 
        icdToL70.add("dm002");

        List<String> icdToL71 = new ArrayList<String>();
        icdToL71.add("dc490"); icdToL71.add("dc491"); icdToL71.add("dc492"); icdToL71.add("dc493"); icdToL71.add("dc494"); icdToL71.add("dc495"); 
        icdToL71.add("dc496"); icdToL71.add("dc499"); icdToL71.add("dc461"); icdToL71.add("dc410"); icdToL71.add("dc498"); icdToL71.add("dc409"); 
        icdToL71.add("dc400"); icdToL71.add("dc401"); icdToL71.add("dc402"); icdToL71.add("dc412"); icdToL71.add("dc408"); icdToL71.add("dc419"); 
        icdToL71.add("dc411"); icdToL71.add("dc413"); icdToL71.add("dc414"); icdToL71.add("dc418"); icdToL71.add("dc403");
        
        List<String> icdToL72 = new ArrayList<String>();
        icdToL72.add("ds520"); icdToL72.add("ds526"); icdToL72.add("ds529"); icdToL72.add("ds528"); icdToL72.add("ds527"); icdToL72.add("ds524"); 
        icdToL72.add("ds523"); icdToL72.add("ds521"); icdToL72.add("ds522"); icdToL72.add("ds525");
        
        List<String> icdToL73 = new ArrayList<String>();
        icdToL73.add("ds827"); icdToL73.add("ds828"); icdToL73.add("ds826"); icdToL73.add("ds825"); icdToL73.add("ds824"); icdToL73.add("ds823"); 
        icdToL73.add("ds822"); icdToL73.add("ds821"); icdToL73.add("ds829");

        List<String> icdToL74 = new ArrayList<String>();
        icdToL74.add("ds623"); icdToL74.add("ds921"); icdToL74.add("ds929"); icdToL74.add("ds927"); icdToL74.add("ds925"); icdToL74.add("ds924"); 
        icdToL74.add("ds923"); icdToL74.add("ds922"); icdToL74.add("ds920"); icdToL74.add("ds628"); icdToL74.add("ds627"); icdToL74.add("ds626"); 
        icdToL74.add("ds624"); icdToL74.add("ds622"); icdToL74.add("ds621"); icdToL74.add("ds620"); icdToL74.add("ds625");

        List<String> icdToL75 = new ArrayList<String>();
        icdToL75.add("ds728"); icdToL75.add("ds727"); icdToL75.add("ds729"); icdToL75.add("ds723"); icdToL75.add("ds720"); icdToL75.add("ds722"); 
        icdToL75.add("ds721"); icdToL75.add("ds724");

        List<String> icdToL76 = new ArrayList<String>();
        icdToL76.add("ds428"); icdToL76.add("ds322"); icdToL76.add("ds323"); icdToL76.add("ds324"); icdToL76.add("ds325"); icdToL76.add("ds327"); 
        icdToL76.add("ds328"); icdToL76.add("ds420"); icdToL76.add("ds421"); icdToL76.add("ds422"); icdToL76.add("ds423"); icdToL76.add("ds321"); 
        icdToL76.add("ds427"); icdToL76.add("dt129"); icdToL76.add("ds429"); icdToL76.add("ds820"); icdToL76.add("dt089"); icdToL76.add("dt109"); 
        icdToL76.add("dt142"); icdToL76.add("ds022"); icdToL76.add("ds424"); icdToL76.add("ds028"); icdToL76.add("ds320"); icdToL76.add("ds024"); 
        icdToL76.add("ds026"); icdToL76.add("ds027"); icdToL76.add("ds029"); icdToL76.add("ds120"); icdToL76.add("ds121"); icdToL76.add("ds122"); 
        icdToL76.add("ds127"); icdToL76.add("ds129"); icdToL76.add("ds220"); icdToL76.add("ds221"); icdToL76.add("ds222"); icdToL76.add("ds223"); 
        icdToL76.add("ds224"); icdToL76.add("ds229"); icdToL76.add("ds225"); icdToL76.add("ds228"); icdToL76.add("ds128"); icdToL76.add("ds023");

        List<String> icdToL77 = new ArrayList<String>();
        icdToL77.add("ds934");

        List<String> icdToL78 = new ArrayList<String>();
        icdToL78.add("ds834"); icdToL78.add("ds836"); 

        List<String> icdToL79 = new ArrayList<String>();
        icdToL79.add("ds936"); icdToL79.add("ds935"); icdToL79.add("ds932"); icdToL79.add("ds731"); icdToL79.add("ds637"); icdToL79.add("ds636"); 
        icdToL79.add("ds635"); icdToL79.add("ds633"); icdToL79.add("ds634"); icdToL79.add("ds436"); icdToL79.add("dt143"); icdToL79.add("ds035"); 
        icdToL79.add("ds532"); icdToL79.add("ds534"); icdToL79.add("ds034"); icdToL79.add("ds135"); icdToL79.add("ds136"); icdToL79.add("ds234"); 
        icdToL79.add("ds235"); icdToL79.add("ds434"); icdToL79.add("ds435"); icdToL79.add("ds437"); icdToL79.add("ds533");

        List<String> icdToL80 = new ArrayList<String>();
        icdToL80.add("dt112"); icdToL80.add("dt632"); icdToL80.add("dt531"); icdToL80.add("dt630"); icdToL80.add("dt330"); icdToL80.add("dt631"); 
        icdToL80.add("dt433"); icdToL80.add("dt530"); icdToL80.add("dt730"); icdToL80.add("dt830"); icdToL80.add("dt831"); icdToL80.add("dt930"); 
        icdToL80.add("dt931"); icdToL80.add("dt092"); icdToL80.add("dt132"); icdToL80.add("dt143"); icdToL80.add("dt933"); icdToL80.add("dm221"); 
        icdToL80.add("dt432"); icdToL80.add("dt332"); icdToL80.add("dm220"); icdToL80.add("dt030"); icdToL80.add("dt033"); icdToL80.add("dt130"); 
        icdToL80.add("dt131"); icdToL80.add("dt132"); icdToL80.add("dt430"); icdToL80.add("dt230"); icdToL80.add("dt231"); icdToL80.add("dt232"); 
        icdToL80.add("dt331"); icdToL80.add("dt333"); icdToL80.add("dt133"); icdToL80.add("dt431");
        
        List<String> icdToL81 = new ArrayList<String>();
        icdToL81.add("ds868"); icdToL81.add("ds869"); icdToL81.add("ds870"); icdToL81.add("ds878"); icdToL81.add("ds880"); icdToL81.add("ds881"); 
        icdToL81.add("ds889"); icdToL81.add("ds961"); icdToL81.add("ds898"); icdToL81.add("ds899"); icdToL81.add("ds960"); icdToL81.add("ds867"); 
        icdToL81.add("ds781"); icdToL81.add("ds897"); icdToL81.add("ds789"); icdToL81.add("ds764"); icdToL81.add("ds767"); icdToL81.add("ds770"); 
        icdToL81.add("ds771"); icdToL81.add("ds772"); icdToL81.add("ds797"); icdToL81.add("ds982"); icdToL81.add("ds863"); icdToL81.add("ds962"); 
        icdToL81.add("ds798"); icdToL81.add("ds799"); icdToL81.add("ds860"); icdToL81.add("ds861"); icdToL81.add("ds862"); icdToL81.add("ds780"); 
        icdToL81.add("dt064"); icdToL81.add("dt147"); icdToL81.add("dt146"); icdToL81.add("dt143"); icdToL81.add("dt139"); icdToL81.add("dt138"); 
        icdToL81.add("dt136"); icdToL81.add("dt135"); icdToL81.add("dt119"); icdToL81.add("dt118"); icdToL81.add("dt116"); icdToL81.add("dt115"); 
        icdToL81.add("dt099"); icdToL81.add("dt098"); icdToL81.add("ds981"); icdToL81.add("ds763"); icdToL81.add("ds968"); icdToL81.add("ds969"); 
        icdToL81.add("ds970"); icdToL81.add("ds971"); icdToL81.add("ds978"); icdToL81.add("dt096"); icdToL81.add("ds561"); icdToL81.add("dt095"); 
        icdToL81.add("ds983"); icdToL81.add("ds984"); icdToL81.add("ds997"); icdToL81.add("ds998"); icdToL81.add("ds999"); icdToL81.add("ds967"); 
        icdToL81.add("ds980"); icdToL81.add("ds469"); icdToL81.add("ds578"); icdToL81.add("ds570"); icdToL81.add("ds568"); icdToL81.add("ds567"); 
        icdToL81.add("ds565"); icdToL81.add("ds564"); icdToL81.add("ds562"); icdToL81.add("ds560"); icdToL81.add("ds499"); icdToL81.add("ds498"); 
        icdToL81.add("ds497"); icdToL81.add("ds489"); icdToL81.add("ds481"); icdToL81.add("ds579"); icdToL81.add("ds460"); icdToL81.add("ds762"); 
        icdToL81.add("ds563"); icdToL81.add("dm795"); icdToL81.add("ds099"); icdToL81.add("ds169"); icdToL81.add("ds480"); icdToL81.add("ds390"); 
        icdToL81.add("ds479"); icdToL81.add("ds461"); icdToL81.add("ds462"); icdToL81.add("ds463"); icdToL81.add("ds467"); icdToL81.add("ds468"); 
        icdToL81.add("ds091"); icdToL81.add("ds334"); icdToL81.add("ds682"); icdToL81.add("ds760"); icdToL81.add("ds761"); icdToL81.add("ds698"); 
        icdToL81.add("ds697"); icdToL81.add("ds689"); icdToL81.add("ds688"); icdToL81.add("ds580"); icdToL81.add("ds683"); icdToL81.add("ds699"); 
        icdToL81.add("ds681"); icdToL81.add("ds680"); icdToL81.add("ds678"); icdToL81.add("ds670"); icdToL81.add("ds669"); icdToL81.add("ds599"); 
        icdToL81.add("ds581"); icdToL81.add("ds589"); icdToL81.add("ds684"); icdToL81.add("ds668"); icdToL81.add("ds598"); icdToL81.add("ds660"); 
        icdToL81.add("ds661"); icdToL81.add("ds662"); icdToL81.add("ds663"); icdToL81.add("ds664"); icdToL81.add("ds665"); icdToL81.add("ds666"); 
        icdToL81.add("ds667"); icdToL81.add("ds597");

        
        List<String> icdToL82 = new ArrayList<String>();
        icdToL82.add("dq766"); icdToL82.add("dq759"); icdToL82.add("dq753"); icdToL82.add("dq754"); icdToL82.add("dq755"); icdToL82.add("dq758"); 
        icdToL82.add("dq760"); icdToL82.add("dq761"); icdToL82.add("dq762"); icdToL82.add("dq763"); icdToL82.add("dq765"); icdToL82.add("dq767"); 
        icdToL82.add("dq764"); icdToL82.add("dq752"); icdToL82.add("dq751"); icdToL82.add("dq750"); icdToL82.add("dq749"); icdToL82.add("dq748"); 
        icdToL82.add("dq743"); icdToL82.add("dq742"); icdToL82.add("dq741"); icdToL82.add("dq740"); icdToL82.add("dq731"); icdToL82.add("dq768"); 
        icdToL82.add("dq728"); icdToL82.add("dq783"); icdToL82.add("dq727"); icdToL82.add("dq729"); icdToL82.add("dq784"); icdToL82.add("dq730"); 
        icdToL82.add("dq726"); icdToL82.add("dq798"); icdToL82.add("dq796"); icdToL82.add("dq795"); icdToL82.add("dq794"); icdToL82.add("dq793"); 
        icdToL82.add("dq792"); icdToL82.add("dq791"); icdToL82.add("dq790"); icdToL82.add("dq789"); icdToL82.add("dq788"); icdToL82.add("dq781"); 
        icdToL82.add("dq785"); icdToL82.add("dq769"); icdToL82.add("dq782"); icdToL82.add("dq799"); icdToL82.add("dq780"); icdToL82.add("dq779"); 
        icdToL82.add("dq778"); icdToL82.add("dq777"); icdToL82.add("dq776"); icdToL82.add("dq775"); icdToL82.add("dq774"); icdToL82.add("dq773"); 
        icdToL82.add("dq772"); icdToL82.add("dq771"); icdToL82.add("dq770"); icdToL82.add("dq786"); icdToL82.add("dq662"); icdToL82.add("dq678"); 
        icdToL82.add("dq677"); icdToL82.add("dq676"); icdToL82.add("dq675"); icdToL82.add("dq673"); icdToL82.add("dq671"); icdToL82.add("dq670"); 
        icdToL82.add("dq669"); icdToL82.add("dq668"); icdToL82.add("dq667"); icdToL82.add("dq666"); icdToL82.add("dq665"); icdToL82.add("dq680"); 
        icdToL82.add("dq663"); icdToL82.add("dq674"); icdToL82.add("dq661"); icdToL82.add("dq660"); icdToL82.add("dq659"); icdToL82.add("dq658"); 
        icdToL82.add("dq656"); icdToL82.add("dq655"); icdToL82.add("dq654"); icdToL82.add("dq653"); icdToL82.add("dq652"); icdToL82.add("dq651"); 
        icdToL82.add("dq650"); icdToL82.add("dq725"); icdToL82.add("dq738"); icdToL82.add("dq664"); icdToL82.add("dq718"); icdToL82.add("dq710"); 
        icdToL82.add("dq711"); icdToL82.add("dq712"); icdToL82.add("dq681"); icdToL82.add("dq714"); icdToL82.add("dq709"); icdToL82.add("dq716"); 
        icdToL82.add("dq713"); icdToL82.add("dq719"); icdToL82.add("dq720"); icdToL82.add("dq721"); icdToL82.add("dq722"); icdToL82.add("dq723"); 
        icdToL82.add("dq724"); icdToL82.add("dq672"); icdToL82.add("dq690"); icdToL82.add("dq683"); icdToL82.add("dq715"); icdToL82.add("dq704"); 
        icdToL82.add("dq685"); icdToL82.add("dq682"); icdToL82.add("dq688"); icdToL82.add("dq684"); icdToL82.add("dq691"); icdToL82.add("dq692"); 
        icdToL82.add("dq699"); icdToL82.add("dq700"); icdToL82.add("dq701"); icdToL82.add("dq702"); icdToL82.add("dq703");
        
        List<String> icdToL83 = new ArrayList<String>();
        icdToL83.add("dm489"); icdToL83.add("dm501"); icdToL83.add("dm502"); icdToL83.add("dm503"); icdToL83.add("dm508"); icdToL83.add("dm500"); 
        icdToL83.add("dm509"); icdToL83.add("dm530"); icdToL83.add("dm531"); icdToL83.add("dm538"); icdToL83.add("ds134"); icdToL83.add("dm436"); 
        icdToL83.add("dm488"); icdToL83.add("dm539"); icdToL83.add("dm434"); icdToL83.add("dm471"); icdToL83.add("dm485"); icdToL83.add("dm430"); 
        icdToL83.add("dm433"); icdToL83.add("dm435"); icdToL83.add("dm460"); icdToL83.add("dm472"); icdToL83.add("dm478"); icdToL83.add("dm479"); 
        icdToL83.add("dm480"); icdToL83.add("dm481"); icdToL83.add("dm483"); icdToL83.add("dm484"); icdToL83.add("dm431");
        
        List<String> icdToL84 = new ArrayList<String>();
        icdToL84.add("ds337"); icdToL84.add("dm519"); icdToL84.add("dm489"); icdToL84.add("dm512"); icdToL84.add("dm513"); icdToL84.add("dm514"); 
        icdToL84.add("dm518"); icdToL84.add("dm532"); icdToL84.add("dm533"); icdToL84.add("dm538"); icdToL84.add("dm539"); icdToL84.add("ds233"); 
        icdToL84.add("ds336"); icdToL84.add("dm483"); icdToL84.add("ds335"); icdToL84.add("dm435"); icdToL84.add("dm485"); icdToL84.add("dm431"); 
        icdToL84.add("dm488"); icdToL84.add("dm460"); icdToL84.add("dm461"); icdToL84.add("dm468"); icdToL84.add("dm469"); icdToL84.add("dm478"); 
        icdToL84.add("dm479"); icdToL84.add("dm480"); icdToL84.add("dm481"); icdToL84.add("dm482"); icdToL84.add("dm484"); icdToL84.add("dm470"); 
        icdToL84.add("dm430");

        List<String> icdToL85 = new ArrayList<String>();
        icdToL85.add("dm401"); icdToL85.add("dm418"); icdToL85.add("dm413"); icdToL85.add("dm412"); icdToL85.add("dm411"); icdToL85.add("dm410"); 
        icdToL85.add("dm405"); icdToL85.add("dm404"); icdToL85.add("dm402"); icdToL85.add("dm400"); icdToL85.add("dm403"); icdToL85.add("dm419"); 
        icdToL85.add("dm438"); icdToL85.add("dm439"); icdToL85.add("dm415"); icdToL85.add("dm414");

        List<String> icdToL86 = new ArrayList<String>();
        icdToL86.add("dm514"); icdToL86.add("dm544"); icdToL86.add("dm543"); icdToL86.add("dm518"); icdToL86.add("dm512"); icdToL86.add("dm511"); 
        icdToL86.add("dm472"); icdToL86.add("dm471"); icdToL86.add("dg558"); icdToL86.add("dg553"); icdToL86.add("dg552"); icdToL86.add("dg551"); 
        icdToL86.add("dg550"); icdToL86.add("dm510"); icdToL86.add("dm519");

        List<String> icdToL87 = new ArrayList<String>();
        icdToL87.add("dm723"); icdToL87.add("dm764"); icdToL87.add("dm763"); icdToL87.add("dm762"); icdToL87.add("dm761"); icdToL87.add("dm760"); 
        icdToL87.add("dm729"); icdToL87.add("dm728"); icdToL87.add("dm724"); icdToL87.add("dm765"); icdToL87.add("dm725"); icdToL87.add("dm766"); 
        icdToL87.add("dm767"); icdToL87.add("dm768"); icdToL87.add("dm769"); icdToL87.add("dm770"); icdToL87.add("dm772"); icdToL87.add("dm773"); 
        icdToL87.add("dm775"); icdToL87.add("dm722"); icdToL87.add("dm779"); icdToL87.add("dm713"); icdToL87.add("dm778"); icdToL87.add("dm702"); 
        icdToL87.add("dm652"); icdToL87.add("dm653"); icdToL87.add("dm654"); icdToL87.add("dm658"); icdToL87.add("dm659"); icdToL87.add("dm673"); 
        icdToL87.add("dm674"); icdToL87.add("dm715"); icdToL87.add("dm701"); icdToL87.add("dm721"); icdToL87.add("dm703"); icdToL87.add("dm704"); 
        icdToL87.add("dm718"); icdToL87.add("dm700"); icdToL87.add("dm719"); icdToL87.add("dm705"); icdToL87.add("dm714"); icdToL87.add("dm712"); 
        icdToL87.add("dm709"); icdToL87.add("dm708"); icdToL87.add("dm707"); icdToL87.add("dm706"); icdToL87.add("dm720");

        List<String> icdToL88 = new ArrayList<String>();
        icdToL88.add("dm088 Anden form for juvenil artritis"); icdToL88.add("dm068 Anden form for reumatoid artritis "); 
        icdToL88.add("dm089 Juvenil artritis UNS"); icdToL88.add("dm084 Pauciartikulær juvenil artritis"); 
        icdToL88.add("dm083 Juvenil seronegativ polyartritis"); icdToL88.add("dm082 Juvenil artritis med ekstra-artikulære manifestationer"); 
        icdToL88.add("dm081 Juvenil ankyloserende spondylitis"); icdToL88.add("dm080 Juvenil reumatoid artritis"); 
        icdToL88.add("dm069 Reumatoid artritis UNS"); icdToL88.add("dm053 Reumatoid artritis med involvering af andre organsystemer"); 
        icdToL88.add("dm459 Ankyloserende spondylitis"); icdToL88.add("dm064 Polyarthritis inflammatorica"); 
        icdToL88.add("dm051 Reumatoid artritis med lungemanifestationer"); icdToL88.add("dm050 Feltys syndrom"); 
        icdToL88.add("dm058 Anden form for seropositiv reumatoid artritis"); icdToL88.add("dm059 Seropositiv reumatoid artritis UNS"); 
        icdToL88.add("dm060 Seronegativ reumatoid artritis"); icdToL88.add("dm061 Stills sygdom med debut efter det fyldte 16. år"); 
        icdToL88.add("dm062 Bursitis rheumatoides"); icdToL88.add("dm063 Noduli rheumatici"); icdToL88.add("dm052 Reumatoid vaskulitis");

        List<String> icdToL89 = new ArrayList<String>();
        icdToL89.add("dm167 - Anden form for sekundær enkeltsidig hofteledsartrose"); icdToL89.add("dm165 - Posttraumatisk enkeltsidig hofteledsartrose"); 
        icdToL89.add("dm169 - Hofteledsartrose UNS"); icdToL89.add("dm166 - Anden form for sekundær dobbeltsidig hofteledsartrose"); 
        icdToL89.add("dm161 - Primær enkeltsidig hofteledsartrose"); icdToL89.add("dm163 - Dysplastisk enkeltsidig hofteledsartrose"); 
        icdToL89.add("dm160 - Primær dobbeltsidig hofteledsartrose"); icdToL89.add("dm162 - Dysplastisk dobbeltsidig hofteledsartrose"); 
        icdToL89.add("dm164 - Posttraumatisk dobbeltsidig hofteledsartrose"); 

        List<String> icdToL90 = new ArrayList<String>();
        icdToL90.add("dm170 - Primær dobbeltsidig knæledsartrose"); icdToL90.add("dm179 - Knæledsartrose UNS"); 
        icdToL90.add("dm175 - Anden form for sekundær enkeltsidig knæledsartrose"); icdToL90.add("dm174 - Anden form for sekundær bilateral knæledsartrose"); 
        icdToL90.add("dm173 - Posttraumatisk enkeltsidig knæledsartrose"); icdToL90.add("dm172 - Posttraumatisk dobbeltsidig knæledsartrose"); 
        icdToL90.add("dm171 - Primær enkeltsidig knæledsartrose"); 

        List<String> icdToL91 = new ArrayList<String>();
        icdToL91.add("dm181 - Primær enkeltsidig artrose i tommelfingers rodled"); icdToL91.add("dm192 - Anden sekundær artrose i andet (andre) led"); 
        icdToL91.add("dm191 - Posttraumatisk artrose i andet (andre) led"); icdToL91.add("dm190 - Primær artrose i andet (andre) led"); 
        icdToL91.add("dm189 - Artrose i tommelfingers rodled UNS"); icdToL91.add("dm185 - Anden form for sekundær enkeltsidig artrose i tommelfingers rodled"); 
        icdToL91.add("dm184 - Anden form for sekundær bilateral artrose i tommelfingers rodled"); icdToL91.add("dm183 - Posttraumatisk enkeltsidig artrose i tommelfingers rodled"); 
        icdToL91.add("dm182 - Posttraumatisk dobbeltsidig artrose i tommelfingers rodled"); icdToL91.add("dm199 - Artrose UNS"); 
        icdToL91.add("dm150 - Primær generaliseret artrose"); icdToL91.add("dm180 - Primær dobbeltsidig artrose i tommelfingers rodled"); 
        icdToL91.add("dm198 - Anden artrose"); icdToL91.add("dm130 - Polyartritis UNS"); icdToL91.add("dm131 - Monoartritis IKA"); 
        icdToL91.add("dm139 - Artritis UNS"); icdToL91.add("dm151 - Heberdens knuder ved artrose"); icdToL91.add("dm152 - Bouchards knuder ved artrose"); 
        icdToL91.add("dm153 - Sekundær multipel artrose"); icdToL91.add("dm154 - Erosiv artrose"); icdToL91.add("dm158 - Anden polyartrose"); 
        icdToL91.add("dm159 - Polyartrose UNS"); icdToL91.add("dm138 - Anden artritis"); 

        List<String> icdToL92 = new ArrayList<String>();
        icdToL92.add("dm754"); icdToL92.add("dm755"); icdToL92.add("dm759"); icdToL92.add("dm753"); icdToL92.add("dm752"); icdToL92.add("dm750"); 
        icdToL92.add("dm751"); icdToL92.add("dm758");

        List<String> icdToL93 = new ArrayList<String>();
        icdToL93.add("dm771");

        List<String> icdToL94 = new ArrayList<String>();
        icdToL94.add("dm931"); icdToL94.add("dm925"); icdToL94.add("dm926"); icdToL94.add("dm927"); icdToL94.add("dm928"); icdToL94.add("dm930"); 
        icdToL94.add("dm913"); icdToL94.add("dm932"); icdToL94.add("dm938"); icdToL94.add("dm939"); icdToL94.add("dm924"); icdToL94.add("dm929"); 
        icdToL94.add("dm910"); icdToL94.add("dm919"); icdToL94.add("dm923"); icdToL94.add("dm429"); icdToL94.add("dm420"); icdToL94.add("dm911"); 
        icdToL94.add("dm912"); icdToL94.add("dm918"); icdToL94.add("dm920"); icdToL94.add("dm921"); icdToL94.add("dm922"); icdToL94.add("dm421");

        List<String> icdToL95 = new ArrayList<String>();
        icdToL95.add("dm818"); icdToL95.add("dm814"); icdToL95.add("dm815"); icdToL95.add("dm816"); icdToL95.add("dm819"); icdToL95.add("dm820"); 
        icdToL95.add("dm821"); icdToL95.add("dm828"); icdToL95.add("dm813"); icdToL95.add("dm808"); icdToL95.add("dm800"); icdToL95.add("dm811"); 
        icdToL95.add("dm812"); icdToL95.add("dm809"); icdToL95.add("dm810"); icdToL95.add("dm805"); icdToL95.add("dm804"); icdToL95.add("dm803"); 
        icdToL95.add("dm802"); icdToL95.add("dm801");

        List<String> icdToL96 = new ArrayList<String>();
        icdToL96.add("ds835"); icdToL96.add("ds833"); icdToL96.add("ds832"); icdToL96.add("ds837"); 

        List<String> icdToL97 = new ArrayList<String>();
        icdToL97.add("dd167"); icdToL97.add("dd212"); icdToL97.add("dd481"); icdToL97.add("dd480"); icdToL97.add("dd219"); icdToL97.add("dd217"); 
        icdToL97.add("dd216"); icdToL97.add("dd215"); icdToL97.add("dd214"); icdToL97.add("dd213"); icdToL97.add("dd163"); icdToL97.add("dd160"); 
        icdToL97.add("dd169"); icdToL97.add("dd162"); icdToL97.add("dd211"); icdToL97.add("dd164"); icdToL97.add("dd165"); icdToL97.add("dd166"); 
        icdToL97.add("dd168"); icdToL97.add("dd210"); icdToL97.add("dd161");

        List<String> icdToL98 = new ArrayList<String>();
        icdToL98.add("dm204"); icdToL98.add("dm213"); icdToL98.add("dm219"); icdToL98.add("dm218"); icdToL98.add("dm217"); icdToL98.add("dm216"); 
        icdToL98.add("dm215"); icdToL98.add("dm214"); icdToL98.add("dm211"); icdToL98.add("dm210"); icdToL98.add("dm205"); icdToL98.add("dm203"); 
        icdToL98.add("dm202"); icdToL98.add("dm201"); icdToL98.add("dm200"); icdToL98.add("dm206"); icdToL98.add("dm212");

        List<String> icdToL99 = new ArrayList<String>();
        icdToL99.add("dm840"); icdToL99.add("dm850"); icdToL99.add("dm849"); icdToL99.add("dm848"); icdToL99.add("dm844"); icdToL99.add("dm843"); 
        icdToL99.add("dm842"); icdToL99.add("dm851"); icdToL99.add("dm880"); icdToL99.add("dm858"); icdToL99.add("dm888"); icdToL99.add("dm798"); 
        icdToL99.add("dm841"); icdToL99.add("dm852"); icdToL99.add("dm853"); icdToL99.add("dm854"); icdToL99.add("dm856"); icdToL99.add("dm859"); 
        icdToL99.add("dm870"); icdToL99.add("dm871"); icdToL99.add("dm872"); icdToL99.add("dm873"); icdToL99.add("dm878"); icdToL99.add("dm879"); 
        icdToL99.add("dm794"); icdToL99.add("dm855"); icdToL99.add("dm662"); icdToL99.add("dm621"); icdToL99.add("dm622"); icdToL99.add("dm952"); 
        icdToL99.add("dm623"); icdToL99.add("dm889"); icdToL99.add("dm628"); icdToL99.add("dm629"); icdToL99.add("dm630"); icdToL99.add("dm631"); 
        icdToL99.add("dm632"); icdToL99.add("dm633"); icdToL99.add("dm638"); icdToL99.add("dm624"); icdToL99.add("dm661"); icdToL99.add("dm738"); 
        icdToL99.add("dm663"); icdToL99.add("dm664"); icdToL99.add("dm665"); icdToL99.add("dm670"); icdToL99.add("dm671"); icdToL99.add("dm672"); 
        icdToL99.add("dm678"); icdToL99.add("dm679"); icdToL99.add("dm680"); icdToL99.add("dm688"); icdToL99.add("dm730"); icdToL99.add("dm731"); 
        icdToL99.add("dm660"); icdToL99.add("dz891"); icdToL99.add("dm959"); icdToL99.add("dm990"); icdToL99.add("dm991"); icdToL99.add("dm992"); 
        icdToL99.add("dm993"); icdToL99.add("dm994"); icdToL99.add("dm995"); icdToL99.add("dm996"); icdToL99.add("dm997"); icdToL99.add("dm998"); 
        icdToL99.add("dm999"); icdToL99.add("dm950"); icdToL99.add("dz890"); icdToL99.add("dm954"); icdToL99.add("dz892"); icdToL99.add("dz893"); 
        icdToL99.add("dz894"); icdToL99.add("dz895"); icdToL99.add("dz896"); icdToL99.add("dz897"); icdToL99.add("dz898"); icdToL99.add("dz899"); 
        icdToL99.add("dz981"); icdToL99.add("dm257"); icdToL99.add("dm620"); icdToL99.add("dt796"); icdToL99.add("dm905"); icdToL99.add("dm891"); 
        icdToL99.add("dm892"); icdToL99.add("dm893"); icdToL99.add("dm894"); icdToL99.add("dm895"); icdToL99.add("dm896"); icdToL99.add("dm898"); 
        icdToL99.add("dm899"); icdToL99.add("dm900"); icdToL99.add("dm901"); icdToL99.add("dm902"); icdToL99.add("dm958"); icdToL99.add("dm904"); 
        icdToL99.add("dm955"); icdToL99.add("dm906"); icdToL99.add("dm907"); icdToL99.add("dm908"); icdToL99.add("dm940"); icdToL99.add("dm941"); 
        icdToL99.add("dm942"); icdToL99.add("dm943"); icdToL99.add("dm948"); icdToL99.add("dm949"); icdToL99.add("dm951"); icdToL99.add("dm953"); 
        icdToL99.add("dm890"); icdToL99.add("dm903"); icdToL99.add("dm231"); icdToL99.add("dm141"); icdToL99.add("dm142"); icdToL99.add("dm143"); 
        icdToL99.add("dm144"); icdToL99.add("dm145"); icdToL99.add("dm146"); icdToL99.add("dm148"); icdToL99.add("dm222"); icdToL99.add("dm223"); 
        icdToL99.add("dm224"); icdToL99.add("dm228"); icdToL99.add("dm245"); icdToL99.add("dm230"); icdToL99.add("dm125"); icdToL99.add("dm232"); 
        icdToL99.add("dm233"); icdToL99.add("dm234"); icdToL99.add("dm235"); icdToL99.add("dm236"); icdToL99.add("dm238"); icdToL99.add("dm239"); 
        icdToL99.add("dm259"); icdToL99.add("dm241"); icdToL99.add("dm243"); icdToL99.add("dm244"); icdToL99.add("dm229"); icdToL99.add("dm074"); 
        icdToL99.add("dm619"); icdToL99.add("dm022"); icdToL99.add("dm023"); icdToL99.add("dm028"); icdToL99.add("dm029"); icdToL99.add("dm030"); 
        icdToL99.add("dm031"); icdToL99.add("dm032"); icdToL99.add("dm036"); icdToL99.add("dm070"); icdToL99.add("dm071"); icdToL99.add("dm140"); 
        icdToL99.add("dm073"); icdToL99.add("dm128"); icdToL99.add("dm075"); icdToL99.add("dm076"); icdToL99.add("dm090"); icdToL99.add("dm091"); 
        icdToL99.add("dm092"); icdToL99.add("dm098"); icdToL99.add("dm120"); icdToL99.add("dm121"); icdToL99.add("dm122"); icdToL99.add("dm123"); 
        icdToL99.add("dm124"); icdToL99.add("dm242"); icdToL99.add("dm072"); icdToL99.add("dm491"); icdToL99.add("dm355"); icdToL99.add("dm356"); 
        icdToL99.add("dm246"); icdToL99.add("dm358"); icdToL99.add("dm240"); icdToL99.add("dm360"); icdToL99.add("dm361"); icdToL99.add("dm362"); 
        icdToL99.add("dm363"); icdToL99.add("dm364"); icdToL99.add("dm368"); icdToL99.add("dm354"); icdToL99.add("dm490"); icdToL99.add("dm357"); 
        icdToL99.add("dm492"); icdToL99.add("dm493"); icdToL99.add("dm494"); icdToL99.add("dm495"); icdToL99.add("dm498"); icdToL99.add("dm541"); 
        icdToL99.add("dm610"); icdToL99.add("dm611"); icdToL99.add("dm612"); icdToL99.add("dm613"); icdToL99.add("dm614"); icdToL99.add("dm615"); 
        icdToL99.add("dm432"); icdToL99.add("dm258"); icdToL99.add("dm247"); icdToL99.add("dm248"); icdToL99.add("dm249"); icdToL99.add("dm250"); 
        icdToL99.add("dm251"); icdToL99.add("dm252"); icdToL99.add("dm359"); icdToL99.add("dm021"); icdToL99.add("dm353"); icdToL99.add("dm020"); 
        icdToL99.add("dm320"); icdToL99.add("dm321"); icdToL99.add("dm328"); icdToL99.add("dm350"); icdToL99.add("dm352"); icdToL99.add("dm253"); 
        icdToL99.add("dm351"); icdToL99.add("dm329"); icdToL99.add("dm349"); icdToL99.add("dm348"); icdToL99.add("dm341"); icdToL99.add("dm340"); 
        icdToL99.add("dm330"); icdToL99.add("dm339"); icdToL99.add("dm332"); icdToL99.add("dm331"); icdToL99.add("dm342");



        //ICPC-2-dk koden sættes som key (i " ") og values sættes som de forud indtastede lister.  

        NewMap.put("L70",icdToL80);
        NewMap.put("L71",icdToL81);
        NewMap.put("L72",icdToL82);
        NewMap.put("L73",icdToL83);
        NewMap.put("L74",icdToL84);
        NewMap.put("L75",icdToL85);
        NewMap.put("L76",icdToL86);
        NewMap.put("L77",icdToL87);
        NewMap.put("L78",icdToL88);
        NewMap.put("L79",icdToL89);
        NewMap.put("L80",icdToL80);
        NewMap.put("L81",icdToL81);
        NewMap.put("L82",icdToL82);
        NewMap.put("L83",icdToL83);
        NewMap.put("L84",icdToL84);
        NewMap.put("L85",icdToL85);
        NewMap.put("L86",icdToL86);
        NewMap.put("L87",icdToL87);
        NewMap.put("L88",icdToL88);
        NewMap.put("L89",icdToL89);
        NewMap.put("L90",icdToL90);
        NewMap.put("L91",icdToL91);
        NewMap.put("L92",icdToL92);
        NewMap.put("L93",icdToL93);
        NewMap.put("L94",icdToL94);
        NewMap.put("L95",icdToL95);
        NewMap.put("L96",icdToL96);
        NewMap.put("L97",icdToL97);
        NewMap.put("L98",icdToL98);
        NewMap.put("L99",icdToL99);

        // DUMMY MAPNING!! 
        // 
        // List<String> ICD10List1 = new ArrayList<String>();
        // ICD10List1.add("ICD1");
        // ICD10List1.add("ICD2");

        // List<String> ICD10List2 = new ArrayList<String>();
        // ICD10List2.add("ICD3");
        // ICD10List2.add("ICD4");
        // ICD10List2.add("ICD5");

        // List<String> ICD10List3 = new ArrayList<String>();
        // ICD10List3.add("ICD6");
        // ICD10List3.add("ICD7");
        // ICD10List3.add("ICD8");
        // ICD10List3.add("ICD9");

        // NewMap.put("ICPC1", ICD10List1);
        // NewMap.put("ICPC2", ICD10List2);
        // NewMap.put("ICPC3", ICD10List3);

        // System.out.println(NewMap + "this is mappingMethod()");

        return NewMap;
    }
    // KODE DATABASE
    // SLUT*****************************************************************************

}
