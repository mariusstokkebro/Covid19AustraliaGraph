import processing.core.PApplet;

public class Main extends PApplet{
        public static void main(String[] args) { PApplet.main("Main"); }
        AlmindeligKnap genYKnap;
        AlmindeligKnap genAKnap;
        AlmindeligKnap genZKnap;

        FaktaBoks makeAFaktaBoks;

        @Override
        public void settings() {
                super.settings();
                size(1280,720);
                genAKnap = new AlmindeligKnap(this,100,50,100,50,"Generation Alpha");
                genZKnap = new AlmindeligKnap(this,300,50,100,50,"Generation Z");
                genYKnap = new AlmindeligKnap(this,500,50,100,50,"Generation Y");
                makeAFaktaBoks = new FaktaBoks();
        }

        @Override
        public void setup() {
                super.setup();

        }

        @Override
        public void draw() {
                clear();
                genAKnap.tegnKnap();
                genZKnap.tegnKnap();
                genYKnap.tegnKnap();

                makeAFaktaBoks.infoBoks(this,mouseX,mouseY);
        }
}
