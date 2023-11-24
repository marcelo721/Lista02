package frontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Button extends JButton {

    private Color startColor = Color.white; // White background
    private Color endColor = Color.white;   // White background
    private int arcWidth = 35;              // Width of the rounded corners

   
    
    public Button(String text) {
    	
        setText(text);
        setForeground(Color.black);
        setContentAreaFilled(false);  // Make the content area transparent
        setBorderPainted(false);      // Remove the default border
    	setFont(new Font("arial", Font.BOLD, 13)); // font 


        // Add movement effect on button hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                moveButton(5, 0);
                setBackground(endColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                moveButton(-5, 0);
                setBackground(startColor);
            }
        });
    }

    // Paint the rounded rectangle on the button background
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Paint the rounded rectangle with a white background
        g2d.setColor(Color.orange);
        g2d.fill(new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcWidth));

        // Draw a black rounded border
        g2d.setColor(Color.black);
        g2d.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcWidth, arcWidth));

        g2d.dispose();

        super.paintComponent(g);
    }

    // Move the button by a specified offset
    private void moveButton(int xOffset, int yOffset) {
        Point currentLocation = getLocation();
        setLocation(currentLocation.x + xOffset, currentLocation.y + yOffset);
    }

}
