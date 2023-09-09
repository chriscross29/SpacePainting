/*
 * part of HA Random artist 
 *
 * @author huub
 * @author kees
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    /** you can change the variable SEED if you like
     *  the same program with the same SEED will generate exactly the same sequence of pictures
     */
    final static long SEED = 37; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int numberOfRegenerates = 0;

   /*---- Screenshots ----
    * do not change
    */
    char current = '0';
    String filename = "randomshot_"; // prefix
    
   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<Dingus>();
    //...

    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        //...
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        // draw all shapes
        // ...
        for (Dingus ding : shapes) {
            ding.draw(g);  
        }
    }

    /**
     * reaction to button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++; // do not change
        
        // clear the shapes list
        // ...
        shapes.clear();

        // Define the probabilities for each shape type
        double[] shapeProbabilities = {0.25, 0.18, 0.17, 0.4}; // Adjust these probabilities as needed

        int numberOfShapes = random.nextInt(10) + 15; // Generates a random number of shapes
        
        for (int i = 1; i <= numberOfShapes; i++) {
            double randomValue = random.nextDouble();
            int selectedShape = -1;

            // Determine which shape to add based on probabilities
            double cumulativeProbability = 0;
            for (int j = 0; j < shapeProbabilities.length; j++) {
                cumulativeProbability += shapeProbabilities[j];
                if (randomValue <= cumulativeProbability) {
                    selectedShape = j;
                    break;
                }
            }

            int maxDimX = (700 / numberOfShapes) * i;
            int minDimX = (700 / numberOfShapes) * (i - 1);
            int maxDimY = 350;
            int minDimY = 0;
            
            // Add the selected shape to the ArrayList
            switch (selectedShape) {
                case 0:
                    shapes.add(new PlanetDingus(maxDimX, maxDimY, minDimX, minDimY));
                    break;
                case 1:
                    shapes.add(new RocketDingus(maxDimX, maxDimY, minDimX, minDimY));
                    break;
                case 2:
                    shapes.add(new AsteroidDingus(maxDimX, maxDimY, minDimX, minDimY));
                    break;
                case 3:
                    shapes.add(new StarDingus(maxDimX, maxDimY, minDimX, minDimY));
                    break;
                default:
                    break;
            }
        }
    }

    /** 
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     * do not change
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}