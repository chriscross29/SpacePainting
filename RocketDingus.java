/**
 * RocketDingus -- part of HA RandomArtist
 */

import java.awt.Graphics;
import java.awt.Color;

class RocketDingus extends Dingus {
    protected boolean filled; //true: filled, false: outline

    public RocketDingus(int maxX, int maxY, int minX, int minY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY, minX, minY);
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
        // Old Rocket
        // ----------
        // int xpos[] = {x, x - 20, x - 20, x - 40, x + 40, x + 20, x + 20, x};
        // int ypos[] = {y, y + 20, y + 100, y + 115, y + 115, y + 100, y + 20, y};

        // New Rocket
        // ----------
        int xBodyPos[] = {x - 20, x - 27, x - 32, x - 36, x - 38, x - 39, x - 38, x - 36, x - 32, x - 27, x - 20, x, x + 20, x + 27, x + 32, x + 36, x + 38, x + 39, x + 38, x + 36, x + 32, x + 27, x + 20};
        int yBodyPos[] = {y + 20, y + 30, y + 40, y + 55, y + 70, y + 75, y + 80, y + 95, y + 110, y + 120, y + 130, y + 125, y + 130, y + 120, y + 110, y + 95, y + 80, y + 75, y + 70, y + 55, y + 40, y + 30, y + 20};

        int xTopPos[] = {x, x - 20, x + 20};
        int yTopPos[] = {y, y + 20, y + 20};

        int xFin1Pos[] = {x - 20, x - 50, x - 50, x - 20};
        int yFin1Pos[] = {y + 75, y + 90, y + 145, y + 130};

        int xFin2Pos[] = {x + 20, x + 50, x + 50, x + 20};
        int yFin2Pos[] = {y + 75, y + 90, y + 145, y + 130};

        // fins and top
        color = randomColor();
        g.setColor(color);
        g.fillPolygon(xFin1Pos, yFin1Pos, xFin1Pos.length);
        g.fillPolygon(xFin2Pos, yFin2Pos, xFin1Pos.length);
        g.fillPolygon(xTopPos, yTopPos, xTopPos.length);
        // black borders for fins and top
        g.setColor(Color.BLACK);
        g.drawPolygon(xFin1Pos, yFin1Pos, xFin1Pos.length);
        g.drawPolygon(xFin2Pos, yFin2Pos, xFin1Pos.length);
        g.drawPolygon(xTopPos, yTopPos, xTopPos.length);

        // rocket body
        color = randomColor();
        g.setColor(color);
        g.fillPolygon(xBodyPos, yBodyPos, xBodyPos.length);
        // black border for body
        g.setColor(Color.BLACK);
        g.drawPolygon(xBodyPos, yBodyPos, xBodyPos.length);

        // rocket window
        color = randomColor();
        g.setColor(color);
        g.fillArc(x - 20, y + 40, 40, 40, 0, 360);
        // black border for window
        g.setColor(Color.BLACK);
        g.drawArc(x - 20, y + 40, 40, 40, 0, 360);
    }    
}