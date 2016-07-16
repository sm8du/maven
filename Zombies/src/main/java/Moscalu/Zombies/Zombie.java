package Moscalu.Zombies;

/**
 * Zombie.java
 * 
 * The class representing the Zombie object in the game. This class needs to
 * have some representation of current location, a reference to its target (aka
 * the Human) and a speed. You should create methods for checking to see if the
 * Zombie is colliding with another Zombie, checking to see if the Zombie is
 * close enough to eat the Human's brains, and movement.
 * 
 * @authors
 * @compids
 * @lab
 */
public class Zombie {

	
	
	// Fields 
	private double x;
	private double y;
	private double dx;
	private double dy;
	private Human target;
	
	// Constructer 
	
	public Zombie(double x, double y, double dx, double dy, Human target) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.target = target;
	}
	//  String to String 
	@Override
	public String toString() {
		return "Zombie [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy
				+ ", target=" + target + "]";
	}
	// Getters and Setters 
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Human getTarget() {
		return target;
	}

	public void setTarget(Human target) {
		this.target = target;
	}
	
	public  boolean collide(Zombie z )
	{
		
		
		int xdiff = Math.abs(((int) this.x - (int)z.getX()));
		int ydiff = Math.abs(((int) this.y - (int)z.getY()));
		
		
		
		if ( xdiff< 1 && ydiff < 1){
			return true;}
		else 
			return false;
		
		
		}
	
	public  boolean eatbrains(Human player )
	{
		
		int xdiff = Math.abs(((int) this.x - (int)player.getX()));
		int ydiff = Math.abs(((int) this.y - (int)player.getY()));
		
		if ( xdiff< 3 && ydiff < 3){
			return true;}
		else 
			return false;
		
		
		}

	public void move(float elapsedTime){
	
	// Ymove	
		
		if (target.getY() >  getY())
			y = ((getY()+(dy*(elapsedTime))));
		
		else if (target.getY() <  getY())
			y = ((getY()-(dy*(elapsedTime))));
		else 
			y = getY();
		
		
	//Xmove	
		
		
		if (target.getX() >  getX())
			x = ((getX()+(dx*(elapsedTime))));
		
		else if (target.getX() <  getX())
			x = ((getX()-(dx*(elapsedTime))));
		
		else 
			x = getX();
	}
		
	
	
}
