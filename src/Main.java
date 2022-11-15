import processing.core.PApplet;

import java.util.Arrays;

import java.util.*;

public class Main extends PApplet{
    public static PApplet app;
    final int s = 600; //used for size of screen
    final int arrsize = 9; //how many objects
    //float methodSelect = random(1,4);
    public ArrayList<Thing> mearray; //the array of objects
    private int look; //what we're looking for

    private int high = arrsize - 1;

    private int low = 0;






    public static void main(String[] args){
        PApplet.main("Main");
    }

    public Main(){
        app = this;
    }

    public void settings() {
        size(s, s);
    }

    public void draw(){
        background(30,129,176);


        if (key > 0) {
            Main.app.stroke(255);
            Main.app.fill(255);
            Main.app.textSize(60);
            Main.app.text(key, 300, 100);
        } else {
            Main.app.stroke(255);
            Main.app.fill(255);
            Main.app.textSize(60);
            Main.app.text("please enter value", 300, 100);
        }

        for (Thing i : mearray){
            i.drawThing();

        }
    }

    public void setup(){
        mearray = new ArrayList<>();

        for (int i = 0; i < arrsize; i++){

            int midX = 55 + (60 * i); //boxes are 5 apart and the 1 and 9 are 55 from sides
            int midY = s/2;
            int rad = 50;
            int yell1 = (int)random(255); //for color
            int yell2 = (int) random(255); // for color
            int A = (int)random(10); //for value

            mearray.add(i, new Thing(midX, midY, rad, yell1, yell2, A));

        }

       mearray = sortArray(mearray);

    }

    public void keyPressed(){
        look = key;

        System.out.println(key);

        if (key == 'r'){
            low = 0;
            high = arrsize - 1;
            setup();
        }

    }




    public void mousePressed(){


        int returnVal;

            returnVal = binarySearchWhile(mearray, key); //placeholder until I get other methods working (see commented out code below)

            if (returnVal < 0) {
                System.out.println("no :(");


            } else {
                System.out.println(returnVal);
            }

    }


    public int binarySearchWhile(ArrayList<Thing> arr, int look){

        if (arr.size() > 0) {

            System.out.println("unadjusted" + look);
            look = look - 48; //for some reason it adds 48 to look...i have no idea why but that's not my biggest issue rn
            System.out.println("adjusted" + look);


            /*arr.get(low).yellow1 = 0; //change color to black of high and low!
            arr.get(high).yellow1 = 0;

            arr.get(low).yellow2 = 0;
            arr.get(high).yellow2 = 0;

            arr.get(low).drawThing();
            arr.get(high).drawThing();
            */


            if (low <= high) {
                int mid = (low + high) / 2;

                arr.get(mid).yellow1 = 0;
                arr.get(mid).yellow2 = 0;

                //arr.get(mid).drawThing();


                int current = arr.get(mid).INTEGER;

                System.out.println("current" + current);
                if (current == look) {
                    return mid;
                } else if (current < look) {
                    low = mid + 1;

                   /* for (int m = 0; m <= low; m++) {
                        arr.get(m).yellow1 = 0;
                        arr.get(m).yellow2 = 0;
                        arr.get(m).drawThing();
                   */

                    ArrayList<Thing> arr2 = new ArrayList<Thing>();
                    arr2.addAll(arr);
                    for (int i = 0; i <= low; i++) {
                        arr2.remove(0);
                    }
                    //binarySearchWhile(arr2, look);


                } else { //if curr > look
                    high = mid - 1;

                    /*
                    for (int c = arr.size() - 1; c >= high; c--) {
                        arr.get(c).yellow1 = 0;
                        arr.get(c).yellow2 = 0;
                        arr.get(c).drawThing();
                    }
                    */


                    ArrayList<Thing> arr2 = new ArrayList<Thing>();
                    arr2.addAll(arr);
                    for (int i = arr2.size() - 1; i >= high; i--) {
                        arr2.remove(arr2.size() - 1);
                    }

                    //binarySearchWhile(arr2, look);
                }

            }

            // binarySearchWhile(arr, key);
            return -1;
        } else {
            return -1;
        }

        }



    public ArrayList<Thing> sortArray(ArrayList<Thing> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(i).INTEGER < arr.get(j).INTEGER) {
                    Thing temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    //arr.get(i) = arr.get(j);
                    //arr.get(j) = temp;

                    int tempX = arr.get(i).x;
                    arr.get(i).x = arr.get(j).x;
                    arr.get(j).x = tempX;

                    int tempY = arr.get(i).y;
                    arr.get(i).y = arr.get(j).y;
                    arr.get(j).y = tempY;
                }
            }
        }
        for (Thing i : arr){
            i.drawThing();
        }
        return arr;
    }

}
