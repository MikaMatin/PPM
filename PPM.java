import java.awt.*;

/**
 * Created by MikaMatin on 11/17/16.
 */
/**
 * Created by MikaMatin on 11/3/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class PPM extends Image
{
    Pixels [][] pixels;
    int [][] pic;
    public PPM(){

        magic = "";
        width = 0;
        height = 0;
        depth = 0;

    }
    public String getMagic(){
        return magic;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getDepth(){
        return depth;
    }

    public void setMagic(String m) {
        magic = m;

    }

    public void setWidth(int w) {
        width = w;

    }

    public void setHeight(int h) {
        height = h;
    }

    public void setDepth(int d) {
        depth = d;

    }

    public PPM(String s) {
        Scanner sc = new Scanner("");

        try {
            File f = new File(s);
            sc = new Scanner(f);
            magic = sc.nextLine();
            String m[] = sc.nextLine().split(" ");
            width = Integer.parseInt(m[0]);
            height = Integer.parseInt(m[1]);
            depth = Integer.parseInt(sc.nextLine());
            pixels = new Pixels[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int r = sc.nextInt();
                    int g = sc.nextInt();
                    int b = sc.nextInt();
                    pixels[i][j] = new Pixels(r, g, b);
                    pixels[i][j].print();
                }
                System.out.println();
            }
        }

        catch (FileNotFoundException e){
            System.out.print("error");
        }

    }
    public void flip_horizontally() {

        Pixels [][] tmp = new Pixels[height][width];
        for(int i = 0; i < tmp.length; i++){
            for(int j = tmp[i].length-1; j >= 0; j--){
                tmp[i][width-1-j] = pixels[i][j];

            }
        }
        pixels = tmp;
    }

    //NEGATE FUNCTIONS

    public void negate_red(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setRed(255-pixels[i][j].getRed());

            }
        }

    }
    public void negate_green(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setGreen(255-pixels[i][j].getGreen());

            }
        }

    }
    public void negate_blue(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setBlue(255-pixels[i][j].getBlue());

            }
        }

    }
    //FLATTEN FUNCTIONS
    public void flatten_red(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setRed(0);

            }
        }

    }
    public void flatten_blue(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setBlue(0);

            }
        }

    }
    public void flatten_green(){

        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                pixels[i][j].setGreen(0);

            }
        }

    }
    public void grey_scale(){

        int total = 0;
        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j < pixels[i].length;j++){
                total = pixels[i][j].getRed()+pixels[i][j].getBlue()+pixels[i][j].getGreen();
                pixels[i][j].setRed(total/3);
                pixels[i][j].setBlue(total/3);
                pixels[i][j].setGreen(total/3);

            }
        }
}

    public void save(String s) throws Exception {
        File file = new File(s);
        PrintWriter pw = new PrintWriter(s);
        pw.println(magic);
        pw.println(width + " " + pixels.length);
        pw.println(depth);
        //System.out.println(pic[0].length +" "+pic.length);
        for(int i = 0; i < pixels.length;i++){
            for(int j = 0; j <pixels[i].length;j++){
               pw.print(pixels[i][j].getRed()+" ");
                pw.print(pixels[i][j].getGreen()+" ");
                pw.print(pixels[i][j].getBlue()+ " ");

            }
            pw.println();
        }
        pw.close();

    }

}

