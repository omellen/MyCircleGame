import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingBall extends JFrame {

    private int blueX = 530;
    private int blueY = 180;
    private int redX = 30;
    private  int redY = 180;



    public MovingBall() {
        KeyListenerObject ball = new KeyListenerObject();
        addKeyListener(ball);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.fillOval(blueX, blueY, 40,40);

        g2d.setColor(Color.red);
        g2d.fillOval(redX, redY, 40,40);

    }

    public void  checkCollisions() {

    }

    private class KeyListenerObject implements KeyListener {
        public void keyTyped(KeyEvent e) { }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int speed = 40;

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

            repaint();

        }

        public void keyReleased(KeyEvent e) { }
    }

}
