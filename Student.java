package pvs.essentials;
import pvs.University;

public abstract class Student extends GameElement {
	protected int movementSpeed;

	public Student(int hitPoints, int dmgPoints, int atkSpeed, String type, String graphics, int movementSpeed, University university) {
		super(hitPoints, dmgPoints, atkSpeed, type, graphics, university);
		this.movementSpeed = movementSpeed;
	}
}