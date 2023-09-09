import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus --  part of HA Random Artist
 * abstract class representing an arbitrary shape
 * @author huub
 */
abstract class Dingus {
    /** random generator to be used by all subclasses of Dingus 
     *  do not change
     */
    Random random = Painting.random;

    /** postion of the shape (upper left corner) **/
    protected int x, y;

    /** color used for drawing this shape **/
    protected Color color;

    /** maximal coordinates; drawing area is (0,0)- (maxX,maxY) **/
    int maxX, maxY;

    /**
     * initializes color and position to random values
     *
     * @param maxX, maxY - give maximum values for the position
     */    
     public Dingus(int maxX, int maxY, int minX, int minY) {
        this.maxX = maxX; this.maxY = maxY;
        // initialize to a random position
        x = minX + random.nextInt(maxX - minX);
        y = minY + random.nextInt(maxY - minY);
        // initialize to a random color
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        color = new Color(red, green, blue);
    }

    abstract void draw(Graphics g);
}