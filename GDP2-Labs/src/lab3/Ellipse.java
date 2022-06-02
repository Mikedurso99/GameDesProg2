package lab3;

public class Ellipse {

    protected int w;
    protected int h;
    
    public int getWidth() {
    	return w;
    }
    
    public int getHeight() {
    	return h;
    }
    
    public Ellipse(int w, int h) {
    	this.w = w;
    	this.h = h;
    }

    public Ellipse(int r) {
		// TODO Auto-generated constructor stub
	}

	public double area() {
        
        return w * h * Math.PI;
    }
    
    @Override
    public String toString() {
      return getClass().getSimpleName() + "(w="+w+", h="+h+")";
    }
}
