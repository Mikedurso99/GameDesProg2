package lab9;

import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import lab7.Missile.State;
import sf.Sound;
import sf.SoundFactory;
import lab7.Explosion;

public class Missile {

    private int x, y;
    private Image image;
    private int width, height;

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    public double start;
    private Explosion explosion;
    public int elapsed;
    public int k;
    
    private State state = State.NONE;
    public final static String DIR = "src/res/";
    public final static String SOUND_EXPLOSION = DIR + "explosion+1.wav";



    public Missile(int x, int y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("/res/missile.png"));
        image = ii.getImage();
        state = State.VISIBLE;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x;
        this.y = y;
        explosion = new Explosion();
    }

    
    public void explode() {
    	if (this.state == State.EXPLODING) {
    		return;
    	}
    	else {
    		this.state = State.EXPLODING;
    		this.start = System.currentTimeMillis();
        	this.y -= explosion.getFrame(0).getHeight(null)/2;
            Sound sound = SoundFactory.getInstance(SOUND_EXPLOSION);
            SoundFactory.play(sound);
    	}
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return (state != State.DONE);
    }

    public void setVisible(Boolean visible) {
        this.state = State.VISIBLE;
    }

    public Rectangle getBounds() {
        if (this.state != State.EXPLODING) {
        	return new Rectangle(x, y, this.image.getWidth(null), this.image.getHeight(null));
        }
        else {
        	return new Rectangle(x, y, width, height);
        }
    }

    public void move() {
        if (state == State.VISIBLE) {
        	x += MISSILE_SPEED;
            if (x > BOARD_WIDTH)
                this.state = State.DONE;
        }
	    else if (this.state == State.EXPLODING) {
	        this.elapsed = (int) ((System.currentTimeMillis()) - this.start);
	        this.k = (this.elapsed / 50);
	        if (this.explosion.has(k))
	        	this.image = explosion.getFrame(k);
	        else 
	            this.state = State.DONE;	        
	    }
    }
}