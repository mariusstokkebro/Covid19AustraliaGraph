import processing.core.PApplet;

public class Main extends PApplet{
        public static void main(String[] args) { PApplet.main("Main"); }
        AlmindeligKnap sickKnap;
        AlmindeligKnap deathsKnap;
        AlmindeligKnap genZKnap;
        DataBroker db;

        FaktaBoks makeAFaktaBoks;

        @Override
        public void settings() {
                super.settings();
                size(1280,720);
                sickKnap = new AlmindeligKnap(this,100,50,100,50,"Sick");
                deathsKnap = new AlmindeligKnap(this,300,50,100,50,"Deaths");
                makeAFaktaBoks = new FaktaBoks();
                db = new DataBroker(this);
        }

        @Override
        public void setup() {
                super.setup();

        }

        @Override
        public void draw() {
                clear();
                sickKnap.tegnKnap();
                deathsKnap.tegnKnap();

                db.loadData();
                makeAFaktaBoks.infoBoks(this,mouseX,mouseY);
        }
}
