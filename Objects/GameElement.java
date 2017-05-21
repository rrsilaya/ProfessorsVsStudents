package pvs.essentials;
import pvs.University;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public abstract class GameElement extends JPanel{
	protected int hitPoints;
	protected int dmgPoints;
	protected int atkSpeed;
	protected String type;
	protected String graphics;
	protected University university;
	protected int arrX, arrY; // positions in the array of elements
	protected Image image;

	public GameElement(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics) {
		this.hitPoints = hitPoints;
		this.dmgPoints = dmgPoints;
		this.atkSpeed = atkSpeed;
		this.type = type;
		this.loadImage(graphics);
	}

	public void attack(GameElement element) {
		element.decreaseHP(this.dmgPoints);
		// System.out.println(element.hitPoints + " HP left.");
	}

	// Setters
	protected void decreaseHP(int amount) {
		this.hitPoints -= amount;
		if(this.hitPoints < 0) this.hitPoints = 0; // avoid negative values

		// System.out.println(this.type + " was damaged " + amount + "!");
	}

	public void positionElement(int arrX, int arrY) {
		this.arrX = arrX;
		this.arrY = arrY; 
	}

	public void bindUniversity(University university) {
		this.university = university;
	}

	// Getters
	public int getHP() {
		return this.hitPoints;
	}

	public int getDP() {
		return this.dmgPoints;
	}

	public String getType() {
		return this.type;
	}

	public int getArrX() {
		return this.arrX;
	}

	public int getArrY() {
		return this.arrY;
	}

	// GUI
	public void loadImage(String graphics) {
		try {
			image = getDefaultToolkit().getImage(graphics);
		} catch(Exception e){}
	}

	public Image getImage() {
		return this.image;
	}

	@Override
	public void paintComponent(Graphics image){
		super.paintComponent(image);
		Graphics2D object = (Graphics2D) image;

		object.drawImage(this.getImage(),this.getArrX(),this.getArrY(),null);
		Toolkit.getDefaultToolkit().sync();
	}
}
