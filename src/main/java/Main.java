import processing.core.PApplet;

public class Main extends PApplet{
        public static void main(String[] args) { PApplet.main("Main"); }


        DataBroker db;
        graph casesGraph;


        @Override
        public void settings() {
                super.settings();
               fullScreen();
               //size(500,500);


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


               casesGraph.drawGraph();

        }

        @Override
        public void mouseClicked() {
        casesGraph.klik();


        }
}
