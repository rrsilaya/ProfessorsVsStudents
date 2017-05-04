package pvs;

import java.util.ArrayList;
import java.util.Random;

import pvs.essentials.Professor;
import pvs.essentials.Student;

public class University {
	private ArrayList<Professor> profRoster; // List of available prof (?)
	private Professor[][] professors; // Professors in the grid
	private ArrayList<int[]> professorInfo; // Link list for prof info

	private Student[][] students;
	private ArrayList<int[]> studentInfo;

	private int level;
	private int studentCount;
	private int maxStudentCount;
	private int fund;
	private boolean isHellWeek;

	private final static int GAME_LENGTH = 120;

	// Game Element Identifiers
	private final static char PROF_ID = 'P';
	private final static char STUD_ID = 'S';
	private final static char BOTH_ID = 'B';

	public University(int level) {
		this.profRoster = new ArrayList<Professor>();
		this.professors = new Professor[5][10];
		this.students = new Student[5][10];

		this.professorInfo = new ArrayList<int[]>();
		this.studentInfo = new ArrayList<int[]>();

		Random rand = new Random();

		this.level = level;
		this.maxStudentCount = (rand.nextInt(5) * this.level) + 20;
		this.isHellWeek = false;
	}

	private boolean isOccupied(int x, int y) {
		return professors[y][x] == null ? false : true;
	}

	public void hireProfessor(int x, int y, Professor professor) {
		if(/*professor.canBeHired(this.fund) && */!this.isOccupied(x, y)) {
			this.professors[y][x] = professor;
			this.professorInfo.add(new int[]{x, y}); // Saves the coordinates of the prof
		}
	}

	// Setters
	public int addFund(int amount) {
		return this.fund += amount;
	}

	// Getters
	public int getLevel() {
		return this.level;
	}

	public int getFund() {
		return this.fund;
	}

	public int getStudentCount() {
		return this.studentCount;
	}

	public boolean isHellWeek() {
		return this.isHellWeek;
	}

	// Helpers
	private char elementIdentifier(int x, int y) {
		if(this.professors[y][x] != null && this.students[y][x] != null)
			return University.BOTH_ID;
		else if(this.professors[y][x] != null)
			return University.PROF_ID;
		else if(this.students[y][x] != null)
			return University.STUD_ID;
		else return ' ';
	}

	public void log() {
		// Grid
		for(int row = 0; row < 5; row++) {
			// Top
			for(int col = 0; col < 10; col++) {
				System.out.print(",---, ");
			} System.out.println();

			// Mid
			for(int col = 0; col < 10; col++) {
				System.out.printf("| %c | ", this.elementIdentifier(col, row));
			} System.out.println();

			for(int col = 0; col < 10; col++) {
				System.out.print("'---' ");
			} System.out.println();
		}

		// Logs
		System.out.println(".---------------------------------------------------------.");
		for(int i = 0; i < this.professorInfo.size(); i++) {
			int[] map = this.professorInfo.get(i);
			Professor prof = this.professors[map[1]][map[0]];

			System.out.printf("|  Prof [%2d,%d]   HP: %3d  /  DP: %3d  /  TYPE: %9s  |\n",
				map[0], map[1], prof.getHP(), prof.getDP(), prof.getType().length() > 6 ? prof.getType().substring(0,6) : prof.getType());
		}
		System.out.println("'---------------------------------------------------------'\n");
	}
}