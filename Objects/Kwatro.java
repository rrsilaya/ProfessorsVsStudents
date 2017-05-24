package pvs.objects;

import pvs.objects.Sprite;
import pvs.essentials.Student;

public class Kwatro extends Sprite {
	private boolean isUsed;
	private int row;
	private int atkAmt;

	public Kwatro(int row) {
		super(10, 100 * (row + 1), "Assets/UI/Gameplay/Kwatro.png");

		this.row = row;
		this.isUsed = false;
	}

	public void giveKwatro(Student student) {
		if(!this.isUsed) {
			student.resetHP(); // invoke attack to student
			this.isUsed = true;

			this.setX(-100);
			this.setY(-100);
			this.repaint();
		}
	}
}
