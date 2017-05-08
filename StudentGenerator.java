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

		switch(rand.nextInt(2)) {
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

		while(true) {
			// Allow player to hire professors
			try {
				Thread.sleep(StudentGenerator.REST_TIME);
			} catch(Exception e) {}

			// Randomize Students (not hellWeek)
			while(true/*time == (gameLength / 4) * 3*/) {
				this.university.positionStudent(rand.nextInt(5), this.randStudent());
				this.university.log();

				// Pause
				try {
					Thread.sleep(((this.gameLength / 4) * 3) / ((this.maxStudents / 4) * 3) * (rand.nextInt(4) * 2000));
				} catch(Exception e) {}
			}
		}
	}
}