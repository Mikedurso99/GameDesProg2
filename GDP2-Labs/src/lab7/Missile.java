package lab7;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

    private int x, y;
    private Image image;
    //boolean visible;

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    
    private Explosion explosion;
    
    public int elapsed;
    public int k;
    public double start;
    public enum State { NONE, VISIBLE, EXPLODING, DONE };
    private State state = State.NONE;

    public Missile(int x, int y) {
        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("/res/missile.png"));
        image = ii.getImage();
        //visible = true;
        state = State.VISIBLE;
        this.x = x;
        this.y = y;
        explosion = new Explosion();
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
        //return visible;
    	if (state != State.DONE)
    		return true;
    	else
    		return false;
    }

    public void move() {
//        x += MISSILE_SPEED;
//        if (x > BOARD_WIDTH)
//            visible = false;
    	
    	    if (state == State.VISIBLE) {
    	        x += MISSILE_SPEED;
    	        if(x > BOARD_WIDTH - 150) {
    	            this.state = State.EXPLODING; 
    	            this.start = System.currentTimeMillis();
    	        }
    	    }
    	    else if (this.state == State.EXPLODING) {
    	        this.elapsed = (int) ((System.currentTimeMillis()) - this.start);
    	        k = (this.elapsed / 50);
    	        if (this.explosion.has(k)) {
    	        	if (k == 0) {
    	        		this.y = y - 20;
    	        		this.image = this.explosion.getFrame(k);
    	        	}
    	        	else
    	        		this.image = this.explosion.getFrame(k);
    	        }
    	        else 
    	            state = State.DONE;
    	        
    	    }
    
    }
}
