package Moscalu.Zombies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class SimpleCanvas extends JPanel implements MouseListener,
		MouseMotionListener {

	// width and height of the window
	int width;
	int height;

	// lastTime that the screen was refreshed
	long lastTime;

	// a link back to the SurvivalField for updating it
	SurvivalField simulator;

	/**
	 * Constructor for the SimpleCanvas
	 * 
	 * @param width_
	 *            width of the window
	 * @param height_
	 *            height of the window
	 * @param simulator_
	 *            link back to the SurvivalField
	 */
	public SimpleCanvas(int width_, int height_, SurvivalField simulator_) {
		width = width_;
		height = height_;
		simulator = simulator_;
		lastTime = -1L;
	}

	/**
	 * Called to start the game
	 */
	public void setupAndDisplay() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(width, height);
		f.setLocation(200, 200);
		f.setVisible(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	
	protected void paintComponent(Graphics g) {
		boolean first = (lastTime == -1L);
		long elapsedTime = System.nanoTime() - lastTime;
		lastTime = System.nanoTime();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.white);
		simulator.draw((Graphics2D) g, (first ? 0.0f
				: (float) elapsedTime / 1e9f));
		repaint();
	}

	
	public void drawDot(Graphics2D g, double x, double y, Color color) {
		g.setColor(color);
		g.fillOval((int) (x + .5f), (int) (y + .5f), 10, 10);
	
	
	
	}

	
	public void mouseMoved(MouseEvent e) {
		simulator.mouseAction((float) e.getX(), (float) e.getY(), -1);
		 
	
	}

	
	public void mouseClicked(MouseEvent e) {
		simulator.mouseAction((float) e.getX(), (float) e.getY(), e.getButton());
	}

	
	public void mouseEntered(MouseEvent e) {
	}

	
	public void mouseExited(MouseEvent e) {
	}


	public void mousePressed(MouseEvent e) {
	}

	
	public void mouseReleased(MouseEvent e) {
	}

	
	public void mouseDragged(MouseEvent arg0) {
	}

}
