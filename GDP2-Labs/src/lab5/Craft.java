package lab5;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Craft {

    //private String craft = "/res/craft.png";
    private String crafta = "/res/craft-a.png";
    private String craft1 = "/res/craft-1.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    public boolean isMoving;
    ImageIcon ii1 = new ImageIcon(this.getClass().getResource(craft1));
    ImageIcon iia = new ImageIcon(this.getClass().getResource(crafta));

    public Craft() {
        image = ii1.getImage();

        x = 40;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            isMoving = true;
            image = iia.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            isMoving = true;
            image = iia.getImage();
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            isMoving = true;
            image = iia.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            isMoving = true;
            image = iia.getImage();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            isMoving = false;
            image = ii1.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            isMoving = false;
            image = ii1.getImage();
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            isMoving = false;
            image = ii1.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            isMoving = false;
            image = ii1.getImage();
        }
    }
}
