import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class graph {
    HashMap<String, Data> dataMap;
    ArrayList<String> dates;
    PApplet p;
    graph(PApplet p,ArrayList<String> dates,HashMap<String,Data>dataMap){
        this.p = p;
        this.dates = dates;
        this.dataMap = dataMap;
    }
// MArcus lugtter
    void drawGraph() {
        for(int i =0;i< dates.size();i++){
            p.fill(140,180,250);
            p.noStroke();
            p.rect(-600+i*8,1000,5,(-dataMap.get(dates.get(i)).cases)/50);
        }

    }
}