import processing.core.PApplet;

public class Main extends PApplet{
        public static void main(String[] args) { PApplet.main("Main"); }
        AlmindeligKnap sickKnap;
        AlmindeligKnap deathsKnap;
        AlmindeligKnap genZKnap;
        DataBroker db;
        graph casesGraph;
        FaktaBoks makeAFaktaBoks;

        @Override
        public void settings() {
                super.settings();
                fullScreen();
                sickKnap = new AlmindeligKnap(this,100,50,100,50,"Sick");
                deathsKnap = new AlmindeligKnap(this,300,50,100,50,"Deaths");
                makeAFaktaBoks = new FaktaBoks();
                db = new DataBroker(this);
                casesGraph = new graph(this,db.dates,db.dataMap);
        }

        @Override
        public void setup() {
                db.loadData();

        }

        @Override
        public void draw() {
                clear();

                background(100);
                sickKnap.tegnKnap();
                deathsKnap.tegnKnap();
                makeAFaktaBoks.infoBoks(this,mouseX,mouseY);
               casesGraph.drawGraph();

        }
}
