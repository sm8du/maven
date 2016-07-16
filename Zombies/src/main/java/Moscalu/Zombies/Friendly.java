package Moscalu.Zombies;


public class Friendly {

	
	// Fields 
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	// Constructer 
	
	public Friendly(double x, double y, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		
	}
	//  String to String 


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

	
	
		
	
	public  boolean collide(Zombie z )
	
	{
		
		if (((int)this.x == (int)z.getX()) && ((int)this.y == (int)z.getY())){
			return true;}
		else 
			return false;
		
		
		}
	
	public  boolean eatbrains(Human player )
	{
		
		if (((int) this.x == (int)player.getX()) && ((int)this.y == (int)player.getY())){
			return true;}
		else 
			return false;
		
		
		}

	
		
	
}

