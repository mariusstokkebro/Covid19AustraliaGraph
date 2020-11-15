//Importering af processing libary
import processing.core.PApplet;

public class FaktaBoks {
    //Variabler

    PApplet p;

    void infoBoks(PApplet p, int posX, int posY,int cases, int deaths){
        this.p = p;
        p.stroke(255);
        p.rect(posX,posY, 200, 200);
        p.fill(255);
        p.text("Cases"+cases,posX+10,posY+25);
        p.text("Deaths"+deaths,posX+10,posY+35);

    }


}
