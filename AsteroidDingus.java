/**
 * AsteroidDingus -- part of HA RandomArtist
 */

import java.awt.Graphics;
import java.awt.Color;

class AsteroidDingus extends Dingus {
    public AsteroidDingus(int maxX, int maxY, int minX, int minY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY, minX, minY);
    }

    @Override
	void draw(Graphics g) { 
        // array to store some color varients of grey
        int[][] rgb = new int[][] {{211, 211, 211}, {192, 192, 192}, {169, 169, 169}, {128, 128, 128}, {105, 105, 105}};
        int row = random.nextInt(rgb.length); // chooses a random row
        color = new Color(rgb[row][0], rgb[row][1], rgb[row][2]);
        g.setColor(color);

        // Old asteroid shapes
        // -------------------
        // int n = random.nextInt(2);
        // if (n == 0) {
        //     int xpos[] = {x, x - 60, x - 90, x - 100, x - 80, x + 10, x + 30, x};
        //     int ypos[] = {y, y, y + 20, y + 50, y + 70, y + 70, y + 50, y};
        //     g.fillPolygon(xpos, ypos, xpos.length);  // asteroid shape 1
        // } else {
        //     int xpos[] = {x, x - 80, x - 100, x - 80, x - 20, x + 40, x + 70, x + 50, x};
        //     int ypos[] = {y, y, y + 50, y + 100, y + 120, y + 100, y + 70, y + 20, y};
        //     g.fillPolygon(xpos, ypos, xpos.length);  // asteroid shape 2
        // }

        // New asteroid shapes
        // -------------------
        int outerRadius = 30 + random.nextInt(25);
        int innerRadius = outerRadius - random.nextInt(10);
        int numVertices = 5 + random.nextInt(5);
        
        int[] xPoints = new int[2 * numVertices];
        int[] yPoints = new int[2 * numVertices];
        
        double angle = Math.PI / numVertices;
        for (int i = 0; i < 2 * numVertices; i++) {
            int radius = (i % 2 == 0) ? outerRadius : innerRadius;
            xPoints[i] = x + (int) (radius * Math.cos(i * angle)) + random.nextInt(10);;
            yPoints[i] = y + (int) (radius * Math.sin(i * angle)) + random.nextInt(10);;
        }
        g.fillPolygon(xPoints, yPoints, 2 * numVertices);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 2 * numVertices);
    }    
}