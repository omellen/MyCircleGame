import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingBall extends JFrame {

    private int blueX = 540;
    private int blueY = 180;
    private int redX = 20;
    private  int redY = 180;

    private int redScore = 0;
    private int blueScore = 0;

    JLabel labelR;
    JLabel labelB;

    Circle blue;
    Circle red;

    public MovingBall() {
        KeyListenerObject ball = new KeyListenerObject();
        addKeyListener(ball);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        labelR = new JLabel("Red score: " + redScore);
        labelB = new JLabel("Blue score: " + blueScore);

        container.add(labelR);
        container.add(labelB);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //blue ball
        g2d.setColor(Color.blue);
        g2d.fillOval(blueX, blueY, 40,40);
        blue = new Circle(blueX + 20, blueY + 20,20);

        //red ball
        g2d.setColor(Color.red);
        g2d.fillOval(redX, redY, 40,40);
        red = new Circle(redX + 20, redY + 20, 20);

        //red goal
        g.setColor(Color.black);
        g.fillRect(0,180,10,40);

        //blue goal
        g.fillRect(590,180,10,40);

    }



    public void  checkCollisions() {
        //if red hits blue's goal
        if (red.intersects(590,180,10,40)) {
            blueX = 540;
            blueY = 180;
            redX = 20;
            redY = 180;

            redScore ++;
            labelR.setText("Red score: " + redScore);
        }
        //  if red and blue intersect
        if (blue.intersects(redX,redY,40,40)) {
            blueX = 540;
            blueY = 180;
            redX = 20;
            redY = 180;
        }
        //if blue hits red's goal
        if (blue.intersects(0,180,10,40)) {
            blueX = 540;
            blueY = 180;
            redX = 20;
            redY = 180;

            blueScore ++;
            labelB.setText("Blue score: " + blueScore);
        }

    }

    private class KeyListenerObject implements KeyListener {
        public void keyTyped(KeyEvent e) {
            repaint();
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int speed = 20;

            //blue down
            if (key == KeyEvent.VK_DOWN) {
                if (blueY + speed <= 400) {
                    blueY += speed;
                }
            }
            //red down
            if (key == KeyEvent.VK_S) {
                if (redY + speed <= 400) {
                    redY += speed;
                }
            }
            //blue up
            if (key == KeyEvent.VK_UP) {
                if (blueY - speed >= 20) {
                    blueY -= speed;
                }
            }
            //red up
            if (key == KeyEvent.VK_W) {
                if (redY - speed >= 20) {
                    redY -= speed;
                }
            }
            //blue left
            if (key == KeyEvent.VK_LEFT) {
                if (blueX - speed >= 0) {
                    blueX -= speed;
                }
            }
            //red left
            if (key == KeyEvent.VK_A) {
                if (redX - speed >= 0) {
                    redX -= speed;
                }
            }
            //blue right
            if (key == KeyEvent.VK_RIGHT) {
                if (blueX + speed <= 560) {
                    blueX += speed;
                }
            }
            //red right
            if (key == KeyEvent.VK_D) {
                if (redX + speed <= 560) {
                    redX += speed;
                }
            }
        }

        public void keyReleased(KeyEvent e) {
            repaint();
            checkCollisions();
        }
    }

}
