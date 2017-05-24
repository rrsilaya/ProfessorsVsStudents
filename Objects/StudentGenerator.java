package pvs.objects;

import pvs.University;
import pvs.essentials.*;
import pvs.objects.LevelData;

import java.util.Random;
import java.util.ArrayList;

public class StudentGenerator implements Runnable, LevelData {
	private int gameLength;
	private int maxStudents;
	private University university;
	private ArrayList<Student> levelStudents;
	private ArrayList<Integer> renderedStudents;

	private final static int REST_TIME = 2000;

	public StudentGenerator(int gameLength, int maxStudents, University university) {
		Random rand = new Random();

		this.gameLength = gameLength;
		this.maxStudents = maxStudents;
		this.university = university;
		this.renderedStudents = new ArrayList<Integer>();

		this.levelStudents = new ArrayList<Student>();
		for(int freshie = 0; freshie < _students[this.university.getLevel()][0]; freshie++) 
			this.levelStudents.add(new Freshie());

		for(int sabaw = 0; sabaw < _students[this.university.getLevel()][1]; sabaw++)
			this.levelStudents.add(new Sabaw());

		for(int graduating = 0; graduating < _students[this.university.getLevel()][2]; graduating++) {
			this.levelStudents.add(new Graduating());
		}

		for(int i = 0; i < this.levelStudents.size(); i++)
			this.university.positionStudent(rand.nextInt(5), this.levelStudents.get(i));
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

	private boolean isRendered(int index) {
		for(int i = 0; i < this.renderedStudents.size(); i++)
			if(this.renderedStudents.get(i) == index) return true;

		return false;
	}

	@Override
	public void run() {
		Random rand = new Random();

		// Allow player to hire professors
		try {
			Thread.sleep(StudentGenerator.REST_TIME);
		} catch(Exception e) {}

			// this.university.log();

		int studentToEnter = 0;
		while(this.university.isTimerActive()) {
			while(this.isRendered(studentToEnter)) studentToEnter = rand.nextInt(this.levelStudents.size());
			renderedStudents.add(studentToEnter);

			this.university.studentEnter(studentToEnter);

			// Pause
			try {
				Thread.sleep((rand.nextInt(4) * (2000 / this.university.getLevel())) + (this.university.isHellWeek() ? 4000 : 12000));
			} catch(Exception e) {}
			System.out.println(studentToEnter);
			// this.Universityy.log();
		}
	}
}