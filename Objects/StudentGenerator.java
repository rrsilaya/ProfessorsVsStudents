package pvs.objects;

import pvs.University;
import pvs.essentials.*;

import java.util.Random;

public class StudentGenerator implements Runnable {
	private int gameLength;
	private int maxStudents;
	private University university;

	private final static int REST_TIME = 7500;

	public StudentGenerator(int gameLength, int maxStudents, University university) {
		this.gameLength = gameLength;
		this.maxStudents = maxStudents;
		this.university = university;
	}

	private Student randStudent() {
		Random rand = new Random();

		switch(rand.nextInt(3)) {
			case 0:
				return new Freshie();
			case 1:
				return new Sabaw();
			case 2:
				return new Graduating();
		}

		return null;
	}

	@Override
	public void run() {
		Random rand = new Random();

		// Allow player to hire professors
		try {
			Thread.sleep(StudentGenerator.REST_TIME);
		} catch(Exception e) {}


		while(this.university.isTimerActive()) {
			this.university.positionStudent(rand.nextInt(5), this.randStudent());
			this.university.log();

			// Pause
			try {
				if(this.university.getTime() > this.gameLength - 15)
					Thread.sleep((rand.nextInt(3) + 1) * 2000);
				else
					Thread.sleep(rand.nextInt(this.gameLength / this.maxStudents) * 1500);
			} catch(Exception e) {}
		}
	}
}
