/** Main class for HA Random Artist
 * can be used unchanged in most cases
 *
 * @author kees
 * @author huub
 * @author Chris D'Mello ID : 1566105 
 * @author Jayin Nejal   ID : 1537199 
 * as group 9
 */

import java.awt.*;
import javax.swing.*;

public class RandomArtist {
    JFrame frame;
    Painting painting; // panel that provides the random painting
    JButton regenerateButton;
    JButton shotButton; 

    RandomArtist() {
        // invokeLater: preferred way to create components
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                painting = new Painting();
                frame = new JFrame("Computer Assisted Random Artist");
                frame.add(painting, BorderLayout.CENTER);
                regenerateButton = new JButton("Regenerate");
                regenerateButton.addActionListener(painting); // painting provides reaction to buttonclick
                frame.add(regenerateButton, BorderLayout.SOUTH);
                shotButton = new JButton("Screenshot");
                shotButton.addActionListener(painting);
                frame.add(shotButton, BorderLayout.NORTH);
                frame.pack();
                painting.regenerate(); // can be done here since painting has a size!
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                painting.setBackground(new Color(60, 44, 86));
            }
        } );
    }

    public static void main(String[] arg) {
        new RandomArtist();
    }
}