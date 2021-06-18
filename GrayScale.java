import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class GrayScale {
 BufferedImage image;
 int width;
 int height;

 public GrayScale() {

 try {
 
 File input = new File("Obrazek.jpg");
 image = ImageIO.read(input);
 width = image.getWidth();
 height = image.getHeight();


 for(int i=0; i<height; i++){
 for(int j=0; j<width; j++){


 Color c = new Color(image.getRGB(j, i));
 int red = (int)(c.getRed());
 int green = (int)(c.getGreen());
 int blue = (int)(c.getBlue());

 int x, y, z;

 
 x = 0;
 y = 0;
 z = 0;



 if ( i>=0 && i<=1000 && j>=900 && j<=1383 )
 {
 x = -70;
 y = -70;
 z = -70;

 }


 if ( i>=350 && i<=850 && j>=400 && j<=1200)
     
 {
 x = 50;
 y = 50;
 z = 50;

 }


 if ( i>=300 && i<=780 && j>=0 && j<=600 )
 {
 x = 200;
 y = -110;
 z = 100;

 }



 if (red + x>=0 && red + x <=255) red = red + x;
 else red = red;

 if (green + y>=0 && green + y <=255) green = green + y;
 else green = green;

 if (blue + z>=0 && blue + z <=255) blue = blue + z;
 else blue = blue;


 Color newColor = new Color(red, green,blue);
 image.setRGB(j,i,newColor.getRGB());

 }
 }

 File ouptut = new File("grayscale.jpg");
 ImageIO.write(image, "jpg", ouptut);

 } catch (IOException e) {}
 }

 static public void main(String args[]) throws Exception
 {
 GrayScale obj = new GrayScale();
 }
}