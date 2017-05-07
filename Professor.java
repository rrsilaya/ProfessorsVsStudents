package pvs.essentials;
import pvs.University;

public abstract class Professor extends GameElement implements Runnable {
	protected int salary;
	protected int state;
	protected int cooldown;
	protected boolean isAttacking;

	public Professor(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics,
		int salary, int cooldown, University university) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics, university);

		this.salary = salary;
		this.cooldown = cooldown;
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
		return this.state == this.cooldown ? true : false;
	}

	public boolean canBeHired(int money) {
		return this.state == this.cooldown || money >= this.salary ? true : false;
	}

	// Threading
	@Override
	public void run() {
		Student toAttack = this.university.frontStudent(this.arrX, this.arrY);

		while(true) {
			if(toAttack != null) {
				this.attack(toAttack);
				this.university.elementRemover();
				this.university.log();

				try {
					Thread.sleep(100 * this.atkSpeed);
				} catch(Exception e) {}
			}

			toAttack = this.university.frontStudent(this.arrX, this.arrY);
		}
	}
}