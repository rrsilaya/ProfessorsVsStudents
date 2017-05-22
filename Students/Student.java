package pvs.essentials;
import pvs.University;

public abstract class Student extends GameElement implements Runnable {
	protected int movementSpeed;

	public Student(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics, int movementSpeed) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics);
		this.movementSpeed = movementSpeed;
	}

	// Threading
	@Override
	public void run() {
		Professor toAttack;

		while(this.hitPoints != 0 && this.x != 0) {
			this.x -= this.movementSpeed / 15; // movement

			if(this.x / 115 < this.arrX) { // movement in array
				this.arrX--;
				this.university.log();
			}
			this.repaint();
			toAttack = this.university.frontProfessor(this.arrX, this.arrY);
			while(toAttack != null) {
				this.attack(toAttack);
				this.university.elementRemover();
				this.university.log();

				try {
					Thread.sleep(150 * this.atkSpeed);
				} catch(Exception e) {}

				if(toAttack.getHP() == 0) toAttack = null;
			}

			try {
				Thread.sleep(80);
			} catch(Exception e) {}
		}

		// this.hitPoints = 0; // kwatro ka na bui
		if(this.hitPoints == 0) {
			this.removeFromScreen();
			this.repaint();
		}
	}
}