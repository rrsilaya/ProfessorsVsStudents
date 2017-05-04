package pvs.essentials;

public class Professor extends GameElement {
	protected int salary;
	protected int state;
	protected final int COOLDOWN;

	public Professor(int hitPoints, int dmgPoints, int atkSpeed, String type,
		int salary, int cooldown) {
		super(hitPoints, dmgPoints, atkSpeed, type);

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