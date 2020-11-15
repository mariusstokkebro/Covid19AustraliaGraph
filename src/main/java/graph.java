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
    int deaths = 0;
    String dato = "";
    int cases = 0;
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
                p.text("20-03-2020",0,1050);
                p.text("11-04-2020",1650,1050);
                p.text("0",1750,1000);
                p.text("910",1750,920);
                p.fill(140, 180, 250);
                p.noStroke();
                this.p = p;
                p.stroke(255);
                p.rect(p.mouseX,p.mouseY+10, 200, 200);
                p.fill(255);
                if(p.mouseX>-600+i*7.5&&p.mouseX<-600+i*7.5+5&& p.mouseY>-dataMap.get(dates.get(i)).deaths/10&&p.mouseY<1000){
                   deaths =dataMap.get(dates.get(i)).deaths;
                    dato = dataMap.get(dates.get(i)).date;

                }
                p.text("Deaths"+""+deaths,p.mouseX+10,p.mouseY+35);
                p.text("Date"+""+dato,p.mouseX+10,p.mouseY+45);




                height = p.constrain((dataMap.get(dates.get(i)).deaths) / 10, (dataMap.get(dates.get(i)).deaths) / 10, maxHD);
                if(deathsVisible) {
                    if(p.mouseX>-600+i*7.5&&p.mouseX<-600+i*7.5+5&& p.mouseY>-dataMap.get(dates.get(i)).deaths/10&&p.mouseY<1000){
                        p.fill(100,100,200);
                    }
                    p.rect((float) (-600 + i * 7.5), 1000, 5, height * -1);
                }
            }



        }

        if(sickKnap.erKlikket()) {
            casesVisible =true;
            deathsVisible = false;
            maxHC++;
            for (int i = 0; i < dates.size(); i++) {
                p.text("20-03-2020",0,1050);
                p.text("11-04-2020",1650,1050);
                p.text("0",1750,1000);
                p.text("27610",1750,470);
                p.fill(140, 180, 250);
                p.noStroke();
                this.p = p;
                p.stroke(255);
                p.rect(p.mouseX-50,p.mouseY+10, 100, 100);
                p.fill(255);
                if(p.mouseX>-600+i*7.5&&p.mouseX<-600+i*7.5+5&& p.mouseY>-dataMap.get(dates.get(i)).cases/50&&p.mouseY<1000){
                    cases =dataMap.get(dates.get(i)).cases;
                    dato = dataMap.get(dates.get(i)).date;

                }
                p.text("Cases"+""+cases,p.mouseX-50,p.mouseY+35);
                p.text("Date"+""+dato,p.mouseX-50,p.mouseY+45);
                if(casesVisible) {
                    height = p.constrain((dataMap.get(dates.get(i)).cases) / 50, (dataMap.get(dates.get(i)).deaths) / 10, maxHC);
                }
                if(p.mouseX>-600+i*7.5&&p.mouseX<-600+i*7.5+5&& p.mouseY>-dataMap.get(dates.get(i)).cases/50&&p.mouseY<1000){
                    p.fill(100,100,200);

                }
                p.rect((float) (-600 + i * 7.5), 1000, 5, height * -1);
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