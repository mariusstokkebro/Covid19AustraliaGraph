import processing.core.PApplet;

import java.util.ArrayList;

public class DataBroker {
    PApplet p;


    ArrayList<Data> list = new ArrayList<Data>();

    DataBroker(PApplet p) {
        this.p = p;

    }

    void loadData() {

        String[] rows = p.loadStrings("owid-covid-data.csv");
        String[] location = rows[0].split(",");
        for (int i = 1; i < rows.length; i++) {
            String[] cells = p.split(rows[i], ",");
            for (int j = 2; j < cells.length; j++) {
                p.println(cells);
                if (cells[j].equals("")) {
                    cells[j] = "0";
                }
            }

        }


    }
}
