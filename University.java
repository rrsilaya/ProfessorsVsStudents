package pvs;

import java.util.ArrayList;
import java.util.Random;

import pvs.essentials.GameElement;
import pvs.essentials.Professor;
import pvs.essentials.Student;

import pvs.objects.Timer;
import pvs.objects.Colorable;
import pvs.objects.StudentGenerator;

// GUI
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class University extends JPanel implements Colorable {
	private ArrayList<Professor> profRoster; // list of available prof

	private ArrayList<Professor> professors;
	private ArrayList<Thread> professorsThread;
	private ArrayList<Student> students;
	private ArrayList<Thread> studentsThread;

	private char[][] map; // "visual" representation

	private StudentGenerator randomizer;
	private Thread randomizerThread;
	private Timer timer;
	private Thread timerThread;

	private int level;
	private int maxStudentCount;
	private int fund;
	private boolean isHellWeek;

	private final static int GAME_LENGTH = 180;
	private final static int SCOPE = 6;

	// Game Area
	private final static int MAX_ROW = 5;
	private final static int MAX_COL = 10;

	// Game Element Identifiers
	private final static char PROF_ID = 'P';
	private final static char STUD_ID = 'S';
	private final static char BOTH_ID = 'B';
	private final static char NONE_ID = ' ';

	// GUI
	Image image;
	private final static String BACKGROUND = ".png";

	public University(int level) {
		this.profRoster = new ArrayList<Professor>();

		this.professors = new ArrayList<Professor>();
		this.students = new ArrayList<Student>();
		this.map = new char[University.MAX_ROW][University.MAX_COL];

		this.randomizer = new StudentGenerator(University.GAME_LENGTH, 20, this);
		this.timer = new Timer(University.GAME_LENGTH, this);

		this.professorsThread = new ArrayList<Thread>();
		this.studentsThread = new ArrayList<Thread>();
		this.randomizerThread = new Thread(this.randomizer);
		this.timerThread = new Thread(timer);

		Random rand = new Random();

		this.level = level;
		this.maxStudentCount = (rand.nextInt(5) * this.level) + 20;
		this.isHellWeek = false;

		// Start Required Threads
		this.randomizerThread.start();
		this.timerThread.start();

		this.loadImage(University.BACKGROUND);
		this.repaint();
	}

	private boolean isOccupied(int x, int y) {
		Professor professor;

		for(int i = 0; i < this.professors.size(); i++) {
			professor = this.professors.get(i);

			if(professor.getArrX() == x && professor.getArrY() == y) return true;
		}

		return false;
	}

	public synchronized void hireProfessor(int x, int y, Professor professor) {
		if(/*professor.canBeHired(this.fund) && */!this.isOccupied(x, y)) {
			professor.positionElement(x, y);
			professor.bindUniversity(this);

			this.professors.add(professor);

			// Add Threads
			this.professorsThread.add(new Thread(professor));
			this.professorsThread.get(this.professorsThread.size() - 1).start();
		}
	}

	public synchronized void positionStudent(int y, Student student) {
		student.positionElement(University.MAX_COL - 1, y);
		student.bindUniversity(this);

		this.students.add(student);

		// Add Threads
		this.studentsThread.add(new Thread(student));
		this.studentsThread.get(this.studentsThread.size() - 1).start();
	}

	public synchronized Student frontStudent(int x, int y) {
		Student student;

		for(int i = 0; i < this.students.size(); i++) {
			student = this.students.get(i);

			if(student.getArrY() == y) {
				for(int proximity = 0; proximity < University.SCOPE; proximity++) {
					if(student.getArrX() == x + proximity) return student;
				}
			}
		}

		return null;
	}

	public synchronized Professor frontProfessor(int x, int y) {
		Professor professor;		

		for(int i = 0; i < this.professors.size(); i++) {
			professor = this.professors.get(i);

			if(professor.getArrX() == x && professor.getArrY() == y) return professor;
		}

		return null;
	}

	public synchronized void elementRemover() {
		// Professors
		for(int i = 0; i < this.professors.size(); i++)
			if(this.professors.get(i).getHP() == 0) this.professors.remove(i);
		
		// Students
		for(int i = 0; i < this.students.size(); i++)
			if(this.students.get(i).getHP() == 0) this.students.remove(i);
	}

	// Setters
	public void addFund(int amount) {
		this.fund += amount;
	}

	void toggleHellWeek() {
		this.isHellWeek = !this.isHellWeek;
	}

	// Getters
	public int getLevel() {
		return this.level;
	}

	public int getFund() {
		return this.fund;
	}

	public int getTime() {
		return this.timer.getTime();
	}

	public boolean isTimerActive() {
		return this.timer.isActive();
	}

	public boolean isHellWeek() {
		return this.isHellWeek;
	}

	public synchronized boolean hasStudentsLeft() {
		return this.students.size() == 0 ? false : true;
	}

	// Helpers
	private void visualize() {
		// Reset
		for(int row = 0; row < University.MAX_ROW; row++)
			for(int col = 0; col < University.MAX_COL; col++)
				this.map[row][col] = University.NONE_ID;

		// Add Professors
		for(int i = 0; i < this.professors.size(); i++) {
			Professor professor = this.professors.get(i);

			this.map[professor.getArrY()][professor.getArrX()] = University.PROF_ID;
		}

		// Add Students
		for(int i = 0; i < this.students.size(); i++) {
			Student student = this.students.get(i);

			if(this.map[student.getArrY()][student.getArrX()] == University.PROF_ID)
				this.map[student.getArrY()][student.getArrX()] = University.BOTH_ID;
			else this.map[student.getArrY()][student.getArrX()] = University.STUD_ID;
		}
	}

	public synchronized void log() {
		System.out.print("\033[H\033[2J");
		System.out.flush();

		this.visualize();

		// Grid
		for(int row = 0; row < University.MAX_ROW; row++) {
			// Top
			for(int col = 0; col < University.MAX_COL; col++) {
				System.out.print(",---, ");
			} System.out.println();

			// Mid
			for(int col = 0; col < University.MAX_COL; col++) {
				System.out.printf("| %c | ", this.map[row][col]);
			} System.out.println();

			for(int col = 0; col < University.MAX_COL; col++) {
				System.out.print("'---' ");
			} System.out.println();
		}

		// Logs
		System.out.println(".---------------------------------------------------------.");
		GameElement element;

		System.out.printf("|                        TIME: %3d                        |\n", this.timer.getTime());
		for(int i = 0; i < this.professors.size(); i++) {
			element = this.professors.get(i);

			System.out.printf("|    %sPRF %14s [%2d,%d]%s   HP: %3d  /  DP: %3d      |\n",
				Colorable.YELLOW, element.getType(), element.getArrX(), element.getArrY(), Colorable.RESET, element.getHP(), element.getDP());
		}

		for(int i = 0; i < this.students.size(); i++) {
			element = this.students.get(i);

			System.out.printf("|    %sSTD %14s [%2d,%d]%s   HP: %3d  /  DP: %3d      |\n",
				Colorable.CYAN, element.getType(), element.getArrX(), element.getArrY(), Colorable.RESET, element.getHP(), element.getDP());
		}
		System.out.println("'---------------------------------------------------------'\n");
	}

	// GUI
	private void loadImage(String graphics){
		try{
			image = Toolkit.getDefaultToolkit().getImage(graphics);
		} catch(Exception e){}	
	}

	@Override
	public void paintComponent(Graphics image){
		super.paintComponent(image);
		Graphics2D background = (Graphics2D) image;

		background.drawImage(this.image, 0, 0,null);
		Toolkit.getDefaultToolkit().sync();
	}
}