import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
        public static void main(String[] args) { PApplet.main("Main"); }


        DataBroker db;
        graph casesGraph;
        PImage img;
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
                img = loadImage("australien er cool.PNG");


        }

        @Override
        public void draw() {
                clear();


                background(255);
                image(img,1650,-10);
                textSize(40);
                fill(3,145,213);
                text("Cases of covid-19 in Australia",width/2-270,100);
               casesGraph.drawGraph();

        }

        @Override
        public void mouseClicked() {
        casesGraph.klik();


        }
}
