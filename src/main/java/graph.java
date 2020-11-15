import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class graph {
    HashMap<String, Data> dataMap;
    ArrayList<String> dates;
    ToggleKnap sickKnap;
    ToggleKnap deathsKnap;

    PApplet p;
    int height = 0;
    int maxHD =0;
    int maxHC = 0;
    boolean casesVisible=false, deathsVisible=false;

    graph(PApplet p,ArrayList<String> dates,HashMap<String,Data>dataMap){
        this.p = p;
        this.dates = dates;
        this.dataMap = dataMap;
        sickKnap = new ToggleKnap(p,100,50,100,50,"Sick");
        deathsKnap = new ToggleKnap(p,300,50,100,50,"Deaths");
    }

    void drawGraph() {

        sickKnap.tegnKnap();
        deathsKnap.tegnKnap();
        p.println(sickKnap.erKlikket());

        if(deathsKnap.erKlikket()) {
        casesVisible =false;
        deathsVisible = true;
            maxHD++;
            for (int i = 0; i < dates.size(); i++) {
                p.fill(140, 180, 250);
                p.noStroke();
                this.p = p;
                p.stroke(255);
                p.rect(p.mouseX,p.mouseY, 200, 200);
                p.fill(255);
                p.text("Cases"+(dataMap.get(dates.get(i)).deaths),p.mouseX+10,p.mouseY+25);




                height = p.constrain((dataMap.get(dates.get(i)).deaths) / 10, (dataMap.get(dates.get(i)).deaths) / 10, maxHD);
                if(deathsVisible) {
                    p.rect(-600 + i * 8, 1000, 5, height * -1);
                }
            }



        }

        if(sickKnap.erKlikket()) {
            casesVisible =true;
            deathsVisible = false;
            maxHC++;
            for (int i = 0; i < dates.size(); i++) {
                p.fill(140, 180, 250);
                p.noStroke();
                p.fill(140, 180, 250);
                p.noStroke();
                this.p = p;
                p.stroke(255);
                p.rect(p.mouseX,p.mouseY, 200, 200);
                p.fill(255);
                p.text("Cases"+(dataMap.get(dates.get(i)).cases),p.mouseX+10,p.mouseY+25);

                if(casesVisible) {
                    height = p.constrain((dataMap.get(dates.get(i)).cases) / 50, (dataMap.get(dates.get(i)).deaths) / 10, maxHC);
                }
                p.rect(-600 + i * 8, 1000, 5, height * -1);
            }






        }

    }

void klik() {
    if (sickKnap.erKlikket()) {

    } else {
        deathsKnap.registrerKlik(p.mouseX, p.mouseY);
    }

    if (deathsKnap.erKlikket()) {

    } else {
        sickKnap.registrerKlik(p.mouseX, p.mouseY);
    }
}
}