package lab3.p1;
import lab3.Circle;
import lab3.Ellipse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ellipse[] ellipses = new Ellipse[2];

		ellipses[0] = new Ellipse(5, 7);
		ellipses[1] = new Circle(6);
		
		for (int i=0; i<ellipses.length;i++) {
			System.out.println(ellipses[i] + " has area of: " + ellipses[i].area());
		}

	}

}
