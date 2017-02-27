/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movingimage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class MovingImage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Moving Image");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
}
class MyPanel extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 120;
    private int squareH = 100;

    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

    }

    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        }
    }


    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Image moving with Pointer...!",10,20);
        g.setColor(Color.RED);

        g.fillRect(squareX,squareY,squareW,squareH);
       /*g.fillOval(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
        g.drawRect(squareX+1,squareY+40,15,12);
        g.drawRect(squareX+100,squareY+40,15,12);
        g.drawOval(squareX+15,squareY+10,10,10);
        g.drawOval(squareX+30,squareY+10,10,10);
        g.drawOval(squareX+45,squareY+10,10,10);
        g.drawOval(squareX+60,squareY+10,10,10);
        g.drawOval(squareX+75,squareY+10,10,10);
        g.drawOval(squareX+90,squareY+10,10,10);
        g.drawRect(squareX+15, squareY+20, 83, 10);
        g.drawOval(squareX+50,squareY+40,10,10);
        g.drawRect(squareX+15, squareY+60, 83, 10);
        g.drawOval(squareX+15,squareY+70,10,10);
        g.drawOval(squareX+30,squareY+70,10,10);
        g.drawOval(squareX+45,squareY+70,10,10);
        g.drawOval(squareX+60,squareY+70,10,10);
        g.drawOval(squareX+75,squareY+70,10,10);
        g.drawOval(squareX+90,squareY+70,10,10);*/


    }
}
