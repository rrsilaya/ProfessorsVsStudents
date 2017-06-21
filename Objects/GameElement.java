package pvs.essentials;

import pvs.University;
import pvs.objects.Sprite;

public abstract class GameElement extends Sprite {
	protected int hitPoints;
	protected int dmgPoints;
	protected int atkSpeed;
	protected String type;
	protected String graphics;
	protected University university;
	protected int arrX, arrY; // positions in the array of elements

	public GameElement(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics) {
		super(0, 0, graphics);
		this.hitPoints = hitPoints;
		this.dmgPoints = dmgPoints;
		this.atkSpeed = atkSpeed;
		this.type = type;
		this.graphics = graphics;
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

	public void setUIPosition(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public void removeFromScreen() {
		this.setX(-100);
		this.setY(-100);
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

	public int getAtkSpeed(){
		return this.atkSpeed;
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
}
