package pvs.essentials;

public abstract class Professor extends GameElement {
	protected int salary;
	protected int state;
	protected final int COOLDOWN;

	// Professor Types
	protected final static String TITA = "Tita";
	protected final static String TALKER = "Talker";
	protected final static String WATER = "Water Thrower";
	protected final static String COFFEE = "Coffee Maker";

	public Professor(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics,
		int salary, int cooldown) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics);

		this.salary = salary;
		this.COOLDOWN = cooldown;
	}

	// Setters
	public void resetState() {
		this.state = 0;
	}

	// Getters
	public int getSalary() {
		return this.salary;
	}

	public boolean canBeHired() {
		return this.state == this.COOLDOWN ? true : false;
	}

	public boolean canBeHired(int money) {
		return this.state == this.COOLDOWN || money >= this.salary ? true : false;
	}
}