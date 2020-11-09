//Importering af processing libary
import processing.core.PApplet;

public class FaktaBoks {
    //Variabler

    PApplet p;

    void infoBoks(PApplet p, int posX, int posY){
        this.p = p;
        p.rect(posX,posY, 200, 200);
        p.fill(255);
        p.text("Insert Data",posX+10,posY+25);

    }


}
