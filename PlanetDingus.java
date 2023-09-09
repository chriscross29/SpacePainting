/**
 * PlanetDingus -- part of HA RandomArtist
 */

import java.awt.Graphics;
import java.awt.Color;

class PlanetDingus extends Dingus {
    protected int diameter;

    public PlanetDingus(int maxX, int maxY, int minX, int minY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY, minX, minY);
        // initialize randomly the PlanetDingus properties, i.e., diameter
        diameter = 100 + random.nextInt(maxX / 4);
    }

    // method to give random rgb values 
    Color randomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, diameter, diameter, 0, 360); // planet
        g.setColor(Color.BLACK);
        g.drawArc(x, y, diameter, diameter, 0, 360); // planet border
        
        // Old craters
        // -----------
        // for (int i = 0; i < 20; i ++) {
        //     int x1 = random.nextInt(diameter) + x;
        //     int y1 = random.nextInt(diameter) + y;
        //     g.fillArc(x1, y1, 5, 5, 0, 360);  // fills dots on planet resembling craters and other objects
        // }    

        // New craters
        // -----------
        // a square of max side length diameter / sq.root(2) can fit inside the circle
        int squareSide = (int) ((double) diameter / Math.sqrt(2));
        // calculating the point where the top left vertex of the square touches the circle
        int xIntersect = x + (diameter / 2) - (squareSide / 2);
        int yIntersect = y + (diameter / 2) - (squareSide / 2);

        color = randomColor();  // calls the ranodomColor function
        g.setColor(color);

        for (int i = 0; i < 20; i ++) {
            int x1 = random.nextInt(squareSide) + xIntersect;
            int y1 = random.nextInt(squareSide) + yIntersect;
            int d = random.nextInt(15);
            g.fillArc(x1, y1, d, d, 0, 360);  // fills dots on planet resembling craters
        }    
    }
}