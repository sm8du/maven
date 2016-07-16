package Moscalu.Zombies;

public class Human {
	
	
	
	
	// Fields 
	private double x;
	private double y;
	private double dx;
	private double dy;
	private int bombs=0;
	private int score=0;
	private int nuke =0;
	//constructor 
	
	

	public Human(double x,double  y, double dx, double dy, int bombs,int score,int nuke)
	{
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
		this.bombs=bombs;
		this.score=score;
		this.nuke=nuke;
	}
	
	// String to String 
	
	
	@Override
	public String toString() {
		return "Human [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy
				+ ", bombs=" + bombs + "]";
	}
	// Methods 
	public int getNuke() {
		return nuke;
	}

	public void setNuke(int nuke) {
		this.nuke = nuke;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBombs() {
		return bombs;
	}

	public void setBombs(int bombs) {
		this.bombs = bombs;
	}
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
	
	
	public void move(double timeElapsed) {
		
		x = (x + dx*timeElapsed);
		y =( y + dy*timeElapsed);
	}
	public  boolean prize(Friendly f)
		{
			int xdiff = Math.abs(((int) this.x - (int)f.getX()));
			int ydiff = Math.abs(((int) this.y - (int)f.getY()));
			
			if ( xdiff <3  && ydiff <3  ){
				return true;}
			else 
				return false;
			
		
	
	}
	
}

	
	
	
	
	
	

	






