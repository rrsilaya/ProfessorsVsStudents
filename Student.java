package pvs.essentials;

public abstract class Student {
	boolean isSlow;

	public Student() {
		super();
		this.isSlow = false;
	}

	// Getters
	public boolean isSlow() {
		return this.isSlow;
	}
}