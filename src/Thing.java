import processing.core.PApplet;
import processing.core.PImage;

public class Thing {
    final int x;
    final int y;
    final int sizer;
    final int INTEGER;
    public int yellow1;
    public int yellow2;


   // private PImage img;

    public Thing(int x, int y, int sizer, int yellow1, int yellow2, int INTEGER){
        //thing needs left x/y and then sizers and then it will have two int values, one for image selection and one for sorting...lol
        this.x = x;
        this.y = y;
        this.sizer = sizer;
        this.yellow1 = yellow1;
        this.yellow2 = yellow2;
        this.INTEGER = INTEGER;
    }

    public void drawThing(){
        Main.app.fill(yellow1, yellow2, 0);
        Main.app.circle(x, y, sizer);

    }
/*
    public Thing[] sortArray(Thing[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].INTEGER < arr[j].INTEGER) {
                    Thing temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

 */


}


