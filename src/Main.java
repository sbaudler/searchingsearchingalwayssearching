import processing.core.PApplet;

import java.util.Arrays;

public class Main extends PApplet{
    public static PApplet app;
    final int s = 600;
    final int arrsize = 100;
    float methodSelect = random(1,4);
    public Thing[] array;
    final int key = 27;


    public static void main(String[] args){
        PApplet.main("Main");
    }

    public Main(){
        app = this;
    }

    public void settings() {
        size(s, s);
    }

    public void setup(){
        array = new Thing[arrsize];

        for (int i = 0; i < arrsize; i++){

            int midX = 55 + (55 * i); //boxes are 5 apart and the 1 and 9 are 55 from sides
            int midY = s/2;
            int rad = 50;
            int yell1 = (int)random(255); //for color
            int yell2 = (int) random(255); // for color
            int A = (int)random(255); //for value

            array[i] = new Thing(midX, midY, rad, yell1, yell2, A);
            array[i].drawThing();
        }
        array = sortArray(array);


        //int methodS = (int)methodSelect;
        int returnVal;
        returnVal = binarySearchWhile(array, key); //placeholder until I get other methods working (see commented out code below)

        if (returnVal < 0) {
            System.out.println("no :(");
        } else {
            System.out.println(returnVal);
        }

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

    public void draw(){
        background(30,129,176);
    }





    public int binarySearchWhile(Thing[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            int mid = (low + high)/2;
            int current = arr[mid].INTEGER;
            if (current == key){
                return mid;
            } else if (current < key){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

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

}
