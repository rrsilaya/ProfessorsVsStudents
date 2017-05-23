package pvs.essentials;
import pvs.University;

public abstract class Professor extends GameElement implements Runnable {
	protected int salary;
	protected int state = 0;
	protected int cooldown;
	protected int chargeTime = 0;
	protected boolean isAttacking;

	public Professor(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics,
		int salary, int cooldown) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics);

		this.salary = salary;
		this.cooldown = cooldown;
	}

	// Setters
	public void resetState() {
		this.state = 0;
	}

	public void incState(){
		this.state++;
	}

	public void resetChargeTime() {
		this.chargeTime = 0;
	}

	public void incChargeTime(){
		this.chargeTime++;
	}

	// Getters
	public int getSalary() {
		return this.salary;
	}

	public int getState() {
		return this.state;
	}

	public int getChargeTime() {
		return this.chargeTime;
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

		while(this.hitPoints != 0 && this.university.isActive()) {
			if(toAttack != null) {
				this.attack(toAttack);
				this.university.elementRemover();
				this.university.log();

				// toAttack.setOpacity(0.5f);
				// try {
				// 	Thread.sleep(300);
				// } catch (Exception e) {}
				// toAttack.setOpactiy(1.0f);

				try {
					Thread.sleep(100 * this.atkSpeed);
				} catch(Exception e) {}
			}
			if(!this.university.hasStudentsLeft()) break; // finishes the game
			toAttack = this.university.frontStudent(this.arrX, this.arrY);
		}

		if(this.hitPoints == 0) {
			this.removeFromScreen();
			this.repaint();
		}
	}
}
