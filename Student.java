package pvs.essentials;

public abstract class Student {
	public Student(int hitPoints, int atkSpeed, String type, String graphics) {
		super(hitPoints, atkSpeed, type, graphics);
		this.isSlow = false;
	}
}