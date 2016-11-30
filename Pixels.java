import java.io.File;
import java.util.Scanner;

/**
 * Created by MikaMatin on 11/17/16.
 */
public class Pixels {

    int red;
    int blue;
    int green;

    public Pixels(){
        red = 0;
        blue = 0;
        green = 0;
    }

    public Pixels(int red, int green, int blue){

        this.red = red;
        this.green = green;
        this.blue = blue;


    }

    public int getRed() {return red;}
    public int getBlue() {return blue;}
    public int getGreen() {return green;}

    public void setRed(int red) {this.red = red;}
    public void setBlue(int blue) {this.blue = blue;}
    public void setGreen(int green) {this.green = green;}

    public void print(){

        System.out.print(red+","+ green+","+ blue);
    }



}
