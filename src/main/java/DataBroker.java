import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBroker {
    PApplet p;
Table dataTable;

    HashMap<String,Data> dataMap = new HashMap<>();
    ArrayList<String> dates = new ArrayList<>();





    DataBroker(PApplet p) {
        this.p = p;

    }

    void loadData() {
        dataTable = p.loadTable("owid-covid-data.csv","header");
        for (TableRow row : dataTable.rows()) {
            if(row.getString("location").equals("Australia")){
                dates.add(row.getString("date"));
                getData(row.getString("date"),row.getInt("total_cases"),row.getInt("total_deaths"));

            }
        }

        }
    void getData(String key,int cases,int deaths){
        dataMap.put(key,new Data(key,cases,deaths));
        p.println(cases);


    }


}
