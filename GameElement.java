package pvs.essentials;

public abstract class GameElement {
	protected int hitPoints;
	protected int dmgPoints;
	protected int atkSpeed;
	protected String type;

	public GameElement(int hitPoints, int dmgPoints, int atkSpeed, String type) {
		this.hitPoints = hitPoints;
		this.dmgPoints = dmgPoints;
		this.atkSpeed = atkSpeed;
		this.type = type;
	}

	public void attack(GameElement element) {
		element.decreaseHP(this.dmgPoints);
	}

	// Setters
	protected void decreaseHP(int amount) {
		this.hitPoints -= amount;

		System.out.println(this.type + " was damaged " + amount + "!");
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
}