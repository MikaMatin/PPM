import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Created by MikaMatin on 11/17/16.
 */
public class ImageEditor {

    public static void main(String[] args) {
        System.out.println("Portable Pixmap (PPM) Image Editor!");
        System.out.println("Enter name of image file: ");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        PPM PPMImage = new PPM(file);
        System.out.println("Enter name of output file: ");
        String output = sc.nextLine();

        System.out.println("Here are your choices:");
        System.out.println("[1] convert to greyscale [2] flip horizontally [3] negative of red [4] negative of green [5] negative of blue [6] just the reds [7] just the green [8] just the blues");


        System.out.print("Do you want [1]? (y/n) ");
        String input = sc.nextLine();
        if(input.equals("y")){
            PPMImage.grey_scale();}

        System.out.print("Do you want [2]? (y/n) ");
        String input2 = sc.nextLine();
        if(input2.equals("y")){
            PPMImage.flip_horizontally();}


        System.out.print("Do you want [3]? (y/n) ");
        String input3 = sc.nextLine();
        if(input3.equals("y")){
            PPMImage.flatten_red();}


        System.out.print("Do you want [4]? (y/n) ");
        String input4 = sc.nextLine();
        if(input4.equals("y")){
            PPMImage.flatten_green();}


        System.out.print("Do you want [5]? (y/n) ");
        String input5 = sc.nextLine();
        if(input5.equals("y")){
            PPMImage.flatten_blue();}


        System.out.print("Do you want [6]? (y/n) ");
        String input6 = sc.nextLine();
        if(input6.equals("y")){
            PPMImage.negate_red();}


        System.out.print("Do you want [7]? (y/n) ");
        String input7 = sc.nextLine();
        if(input7.equals("y")){
            PPMImage.negate_green();}


        System.out.print("Do you want [8]? (y/n) ");
        String input8 = sc.nextLine();
        if(input8.equals("y")){
            PPMImage.negate_blue();}



        try {
            PPMImage.save("out.ppm");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
