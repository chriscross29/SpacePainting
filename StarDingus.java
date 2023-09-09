/**
 * StarDingus -- part of HA RandomArtist
 */

import java.awt.Color;
import java.awt.Graphics;

class StarDingus extends Dingus {
    protected boolean filled; //true: filled, false: outline

    public StarDingus(int maxX, int maxY, int minX, int minY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY, minX, minY);
    }

    @Override
    void draw(Graphics g) {
        // Old stars
        // ---------
        // g.setColor(color);
        // int xpos[] = {x, x - 40, x + 60, x - 60, x + 40, x};
        // int ypos[] = {y, y + 80, y + 25, y + 25, y + 80, y};
        // if (filled) {
        //     g.fillPolygon(xpos, ypos, xpos.length);
        // } else {
        //     g.drawPolyline(xpos, ypos, xpos.length);
        // }
        
        // New stars
        // ---------
        int[][] rgb = new int[][] {{253, 204, 13}, {255, 223, 0}, {254, 242, 78}, 
                                    {253, 253, 102}, {254, 254,   190}, {253, 253, 150}};
        int row = random.nextInt(rgb.length); // chooses a random row
        color = new Color(rgb[row][0], rgb[row][1], rgb[row][2]);
        g.setColor(color);
        
        int outerRadius = 20;
        int innerRadius = 5;
        int numVertices = 10;
        
        int[] xPoints = new int[2 * numVertices];
        int[] yPoints = new int[2 * numVertices];
        
        double angle = Math.PI / numVertices;
        for (int i = 0; i < 2 * numVertices; i++) {
            int radius = (i % 2 == 0) ? outerRadius : innerRadius;
            xPoints[i] = x + (int) (radius * Math.cos(i * angle));
            yPoints[i] = y + (int) (radius * Math.sin(i * angle));
        }
        g.fillPolygon(xPoints, yPoints, 2 * numVertices);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 2 * numVertices);
    }
}