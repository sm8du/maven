package Moscalu.Zombies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * SurvivalField.java
 * 
 * The SurvivalField is the field of play for the game. It passes messages
 * between the Human and the Zombies. It also picks up the commands from the
 * mouse and does the appropriate action. This is the class that will have the
 * main method to start the game.

 */
public class SurvivalField {

	// The SurvivalField needs a canvas to draw on
	public SimpleCanvas canvas;

	// The InfoFrame that you use for output instead of System.out
	private InfoFrame output;

	// -----------------------------------------
	// Fields
	private Human player;
	private ArrayList<Zombie> zombie;
	private ArrayList<Friendly> friend;
	private double mX = 0;
	private double mY = 0;
	private int click = 0;

	

	
	public SurvivalField() {

		// Making random numbers for my guy
		Random random = new Random();

		// Create canvas object with 500x500 spatial dimensions.
		canvas = new SimpleCanvas(600, 600, this);

		// Initialize your output frame
		output = new InfoFrame(this);

		

		player = new Human(250, 250, 35, 35, 3, 0, 1);
		zombie = new ArrayList<Zombie>();
		friend = new ArrayList<Friendly>();

		int i = 501;
		int speed = 20;
		zombie.add(new Zombie(random.nextInt(i), random.nextInt(i), speed,
				speed, player));
		zombie.add(new Zombie(random.nextInt(i), random.nextInt(i), speed,
				speed, player));
		zombie.add(new Zombie(random.nextInt(i), random.nextInt(i), speed,
				speed, player));
		zombie.add(new Zombie(random.nextInt(i), random.nextInt(i), speed,
				speed, player));

		output.println("New Player Created!  You start with 3 bombs(mouse-click) and 1 nuke!");
		output.println("There are three levels to this game. Good luck!");
	}

	
	public void mouseAction(float x, float y, int button) {
		mX = x;
		mY = y;
		click = button;

		/*
		 * if (button == -1) { output.println("Mouse: " + x + "," + y); }
		 * 
		 * if (button == 1) {
		 * output.println("You clicked the left mouse button!"); }
		 */
		// if (button == 3) {
		//
		// output.println("You clicked the right mouse button!"); }

	}

	
	public void detonateBomb(Human player) {

		int pixels = 50;
		double xdiff = 0;
		double ydiff = 0;

		if (player.getBombs() != 0) {
			if (click == 1) {
				player.setBombs((player.getBombs() - 1));

				output.println("BOOM! You dropped a bomb! You lost a bomb! ");
				output.println("You have: " + player.getBombs() + " left!");
				click = 0;
				for (int i = 0; i < zombie.size(); i++) {
					Zombie z = zombie.get(i);
					xdiff = Math.abs(player.getX() - z.getX());
					ydiff = Math.abs(player.getY() - z.getY());
					if (xdiff < pixels && ydiff < pixels) {
						zombie.remove(i);
						i--;
					}

				}

			}

		}
	}

	public void detonateNuke(Human player) {

		int pixels = 500;
		double xdiff = 0;
		double ydiff = 0;

		if (player.getNuke() != 0) {
			if (click == 3) {
				player.setNuke((player.getNuke() - 1));

				output.println("BOOM! You dropped a Nuke! " + " ");
				output.println("You have: " + player.getNuke()
						+ "  Nukes left!");
				click = 0;
				for (int i = 0; i < zombie.size(); i++) {
					Zombie z = zombie.get(i);
					xdiff = Math.abs(player.getX() - z.getX());
					ydiff = Math.abs(player.getY() - z.getY());
					if (xdiff < pixels && ydiff < pixels) {
						zombie.remove(i);
						i--;

					}

				}

			}

		}
	}

	public void addfriend() {
		Random random = new Random();

		if (friend.size() < 1);
		{
			friend.add(new Friendly(random.nextInt(450), random.nextInt(450),
					25, 25));

		}

	}

	
	int ZombieCounter = 0;
	int BombCounter = 0;
	int NukeCounter = 0;
	int FriendCounter = 0;
	int durationFriend = 0;
	boolean fun = true;
	double ScoreCounter = 0;
	double scoretotal = 0;
	int endgame;
	int LevelCounter;
	boolean level3 = false;
	int a =0;
	boolean level2 = false;
	int b=0;
	boolean level1 = false;
	int c = 0;
	
	public void draw(Graphics2D g, float elapsedTime) {

		Random random = new Random();
		Scanner myKeyboard = new Scanner(System.in);
		// My counters
		BombCounter = BombCounter + 1;
		ZombieCounter = ZombieCounter + 1;
		NukeCounter = NukeCounter + 1;
		FriendCounter = FriendCounter + 1;
		ScoreCounter = ScoreCounter + 1;
		LevelCounter = LevelCounter + 1;
		// Bomb + Zombie Maker

		// Levels

		if (fun) {

			if (LevelCounter < 50000) {
				level1 = true;
				if (level1 && c <1) {
					output.println("Level 1");
					c++;
				}
				if (ZombieCounter > 5000) {
					zombie.add(new Zombie(random.nextInt(501), random
							.nextInt(501), 15, 15, player));
					ZombieCounter = 0;
				}
			}
			// level 2 Extra feature

			else if (LevelCounter > 75000 && LevelCounter < 125000) {
				level2 = true;
				if (level2 && b <1) {
					output.println("Congrats you have advanced to Level 2");
					b++;
				}
				if (ZombieCounter > 2000) {

					zombie.add(new Zombie(random.nextInt(501), random
							.nextInt(501), 15, 15, player));
					ZombieCounter = 0;
				}

			}
			// level 3 Extra Feature
			else if (LevelCounter > 125000 && zombie.size() < 55) {
			level3 = true;
				if (level3 && a <1) {
					output.println("Congrats you have advanced to the Last Level. Prepare to die.");
					a++;
				}
				
				
				if (ZombieCounter > 900) {
					zombie.add(new Zombie(random.nextInt(501), random
							.nextInt(501), 15, 15, player));
					ZombieCounter = 0;
				}
			}

		}

		// Score
		if (fun) {
			if (ScoreCounter > 100) {
				player.setScore(player.getScore() + 1);
				ScoreCounter = 0;
			}

		}
		// Bomba
		if (fun) {
			if (BombCounter > 100000) {
				player.setBombs((player.getBombs() + 1));
				output.println("You gained a bomb ");
				output.println(" You now have " + player.getBombs() + "!");
				BombCounter = 0;

			}
		}
		// Nuke  +1 feature

		if (fun) {
			if (NukeCounter > 200000) {
				player.setNuke((player.getNuke() + 1));
				output.println("You gained a NUKE ");
				NukeCounter = 0;

			}
		}
		// Yellow dot Creation  Extra feature
		if (fun) {
			if (FriendCounter > 30000 && friend.size() == 0) {
				addfriend();
				FriendCounter = 0;

			}
		}

		// Following the mouse: Player Chose to do this here. The zombies were
		// done in their own class...

		// X direction
		if (player.getX() > mX)
			player.setDx(-Math.abs(player.getDx()));
		else if (player.getX() < mX)
			player.setDx(Math.abs(player.getDx()));
		else
			player.setDx(0);

		// Y direction
		if (player.getY() > mY)
			player.setDy(-Math.abs(player.getDy()));

		else if (player.getY() < mY)
			player.setDy(Math.abs(player.getDy()));
		else

			player.setDy(0);

		// Drawing player
		if (fun) {
			player.move(elapsedTime);

			canvas.drawDot(g, player.getX(), player.getY(), Color.green);
		}
		// Drawing Zombie
		// Main For loop
		outerLoop: for (int i = 0; i < zombie.size(); i++) {
			// Trying to make the yellow  dots come to the screen
			if (friend.size() == 1) {
				Friendly F = friend.get(0);
				canvas.drawDot(g, F.getX(), F.getY(), Color.yellow);
				
				// Prize Colliding with the Green dot
				
				if (player.prize(F)) {
					player.setBombs(player.getBombs() + 1);
					output.println("Score +100 Bomb +1 ");
					player.setScore(player.getScore() + 100);
					friend.remove(0);
				}
			}

			// Making zombie
			Zombie z = zombie.get(i); 

			// Collisions with the Zombies 

			innerLoop: for (int j = 0; j < zombie.size(); j++) {
				if (i != j) {
					Zombie z2 = zombie.get(j);// making collision zombie
					// colliding
					if (z.collide(z2)) {

						int number = random.nextInt(10);
						//Redrawing zombies 
//						
						 if (number > 1) {
							z.setX((z2.getX() + (random.nextInt(2))));
							z.setY((z2.getY() + (random.nextInt(2))));
						}

					} else
						canvas.drawDot(g, z.getX(), z.getY(), Color.red);

				}

			}

			// Checking to see if the zombie ate the human
			if (z.eatbrains(player)) {
				fun = false;

			}
			// Checking to see if the game is over and Moving the Zombies /
			// freezing the zombies if it is.
			if (fun)
				z.move(elapsedTime);

			else if (!fun && endgame < 1) {
				output.println("Your Score was: " + player.getScore());
				output.println("NONOMNONONNONONONONOMMMMMMNOMMMNOMMNNOMM You got eaten. x_x");
				endgame++;
			}

			// Bomb and Nuke Methods
			detonateBomb(player);
			detonateNuke(player);
			

		}

	}

	/**
	 * Your standard main method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SurvivalField simulator = new SurvivalField();
		simulator.play();

	}

	/**
	 * This method starts the game.
	 */
	public void play() {
		canvas.setupAndDisplay();

	}
}