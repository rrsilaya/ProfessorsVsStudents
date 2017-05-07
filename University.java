package pvs;

import java.util.ArrayList;
import java.util.Random;

import pvs.essentials.GameElement;
import pvs.essentials.Professor;
import pvs.essentials.Student;
import pvs.objects.Timer;

public class University {
	private ArrayList<Professor> profRoster; // List of available prof (?)
	private Professor[][] professors; // Professors in the grid
	private Student[][] students;

	private ArrayList<Thread> professorsThread;
	private ArrayList<Thread> studentsThread;

	private int level;
	private int studentCount;
	private int maxStudentCount;
	private int fund;
	private boolean isHellWeek;

	private final static int GAME_LENGTH = 120;
	private final static int SCOPE = 6;

	// Game Element Identifiers
	private final static char PROF_ID = 'P';
	private final static char STUD_ID = 'S';
	private final static char BOTH_ID = 'B';
	private final static char NONE_ID = ' ';

	public University(int level) {
		this.profRoster = new ArrayList<Professor>();
		this.professors = new Professor[5][10];
		this.students = new Student[5][10];

		this.professorsThread = new ArrayList<Thread>();
		this.studentsThread = new ArrayList<Thread>();

		Random rand = new Random();

		this.level = level;
		this.maxStudentCount = (rand.nextInt(5) * this.level) + 20;
		this.isHellWeek = false;
	}

	private boolean isOccupied(int x, int y) {
		return professors[y][x] == null ? false : true;
	}

	public synchronized void hireProfessor(int x, int y, Professor professor) {
		if(/*professor.canBeHired(this.fund) && */!this.isOccupied(x, y)) {
			this.professors[y][x] = professor;
			professor.positionElement(x, y);

			// Add Threads
			this.professorsThread.add(new Thread(professor));
			this.professorsThread.get(this.professorsThread.size() - 1).start();
		}
	}

	public synchronized void positionStudent(int x, int y, Student student) {
		this.students[y][x] = student;
		student.positionElement(x, y);
	}

	public Student frontStudent(int x, int y) {
		for(int i = 0; i < 5; i++) {
			if(students[y][x + i] != null) {
				return students[y][x + i];
			}
		}

		return null;
	}

	public synchronized void elementRemover() {
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 10; col++) {
				if(this.students[row][col] != null &&
					this.students[row][col].getHP() == 0) this.students[row][col] = null;
				if(this.professors[row][col] != null &&
					this.professors[row][col].getHP() == 0) this.professors[row][col] = null;
			}
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
		else return University.NONE_ID;
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
		Professor prof;
		Student stud;
		int[] map;

		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 10; col++) {
				if(this.professors[row][col] != null || this.students[row][col] != null) {
					if(this.professors[row][col] != null) {
						prof = this.professors[row][col];
						map = new int[]{col, row};

						System.out.printf("|    PRF %14s [%2d,%d]   HP: %3d  /  DP: %3d       |\n",
				prof.getType(), map[0], map[1], prof.getHP(), prof.getDP());
					}

					if(this.students[row][col] != null) {
						stud = this.students[row][col];
						map = new int[]{col, row};

						System.out.printf("|    STD %14s [%2d,%d]   HP: %3d  /  DP: %3d       |\n",
				stud.getType(), map[0], map[1], stud.getHP(), stud.getDP());
					}
				}
			}
		}
		System.out.println("'---------------------------------------------------------'\n");
	}
}