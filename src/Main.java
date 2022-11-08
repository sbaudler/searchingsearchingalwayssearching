import processing.core.PApplet;

import java.util.Arrays;

import java.util.*;

public class Main extends PApplet{
    public static PApplet app;
    final int s = 600; //used for size of screen
    final int arrsize = 9; //how many objects
    //float methodSelect = random(1,4);
    public ArrayList<Thing> mearray; //the array of objects
    final int key = 6; //what we're looking for

    private int high;

    private int low;






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

        Main.app.stroke(255);
        Main.app.fill(255);
        Main.app.textSize(60);
        Main.app.text(key, 300, 100);


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



        //int methodS = (int)methodSelect;


        /*
        if (methodS == 1) {
            binarySearchFor();
        } else if (methodS == 2){
            returnVal = binarySearchWhile(array, key);
        } else {
            binarySearchRecursion();
        }
        */

    }




    public void keyPressed(){


        int returnVal;

            returnVal = binarySearchWhile(mearray, key); //placeholder until I get other methods working (see commented out code below)

            if (returnVal < 0) {
                System.out.println("no :(");
            } else {
                System.out.println(returnVal);
            }

    }


    public int binarySearchWhile(ArrayList<Thing> arr, int key){

        low = 0;
        high = arr.size() - 1;

        arr.get(low).yellow1 = 0; //change color to black of high and low!
        arr.get(high).yellow1 = 0;

        arr.get(low).yellow2 = 0;
        arr.get(high).yellow2 = 0;

        arr.get(low).drawThing();
        arr.get(high).drawThing();

        if (low < high){
            int mid = (low + high)/2;

            arr.get(mid).yellow1 = 0;
            arr.get(mid).yellow2 = 0;

            arr.get(mid).drawThing();


            int current = arr.get(mid).INTEGER;
            if (current == key){
                return mid;
            } else if (current < key){
                low = mid + 1;

                for (int m = 0; m < low; m++){
                    arr.get(m).yellow1 = 0;
                    arr.get(m).yellow2 = 0;
                    arr.get(m).drawThing();

                }
            } else {
                high = mid -1;

                for (int c = arr.size() - 1; c > high; c--){
                    arr.get(c).yellow1 = 0;
                    arr.get(c).yellow2 = 0;
                    arr.get(c).drawThing();
                }
            }
        }
        return -1;
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
