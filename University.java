package pvs;

import java.util.ArrayList;
import java.util.Random;

import pvs.essentials.Professor;

public class University {
	private ArrayList<Professor> profRoster;
	private Professor[][] professors;

	private int level;
	private int gameLength;
	private int studentCount;
	private int maxStudentCount;
	private int fund;
	private boolean isHellWeek;

	public University(int level, int gameLength) {
		this.profRoster = new ArrayList<Professor>();
		this.professors = new Professor[5][10];

		Random rand = new Random();

		this.level = level;
		this.gameLength = gameLength;
		this.maxStudentCount = (rand.nextInt(5) * this.level) + 20;
		this.isHellWeek = false;
	}

	public hireProfessor(int x, int y, Professor professor) {
		if(professor.canBeHired(this.fund)) professors[y][x] = professor;
	}

	// Getters
	public int getLevel() {
		return this.level;
	}

	public int getFund() {
		return this.fund;
	}

	public int getGameLength() {
		return this.gameLength;
	}

	public int getStudentCount() {
		return this.studentCount;
	}

	public boolean isHellWeek() {
		return this.isHellWeek;
	}
}