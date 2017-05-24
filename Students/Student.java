package pvs.essentials;
import pvs.University;

public abstract class Student extends GameElement implements Runnable {
	protected int movementSpeed;
	protected int pos = 300; // to be moved to sprite class

	public Student(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics, int movementSpeed) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics);
		this.movementSpeed = movementSpeed;
	}

	// Threading
	@Override
	public void run() {
		Professor toAttack;

		while(this.hitPoints != 0 && this.pos != 0) {
			this.pos -= this.movementSpeed; // movement

			if(this.pos / 30 < this.arrX) { // movement in array
				// this.university.repositionStudent(this.arrX, --this.arrX, this);
				this.arrX--;
				this.university.log();
			}

			toAttack = this.university.frontProfessor(this.arrX, this.arrY);
			while(toAttack != null) {
				this.attack(toAttack);
				this.university.elementRemover();
				this.university.log();

				try {
					Thread.sleep(150 * this.atkSpeed);
				} catch(Exception e) {}
			}

			try {
				Thread.sleep(3500);
			} catch(Exception e) {}
		}

		// this.hitPoints = 0; // kwatro ka na bui
		if(this.hitPoints == 0) {
			this.removeFromScreen();
			this.repaint();
		}
	}
}