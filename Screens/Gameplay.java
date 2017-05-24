package pvs.screens;

import pvs.objects.ObjectRendered;
import pvs.objects.Sprite;
import pvs.objects.Button;
import pvs.objects.Text;
import pvs.objects.MainFrame;
import pvs.objects.DragAndDrop;
import pvs.objects.Timer;
import pvs.objects.Kwatro;
import pvs.University;
import pvs.essentials.*;

import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
/* REVISE INTEGRATION */
import java.awt.Container;
import java.awt.BorderLayout;
/* END */
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import java.io.File;

public class Gameplay extends Background {
	private BufferedImage background;
	private Container container;
	private MainFrame frame;
	private Text money;
	private University university;
	private ArrayList<JPanel> lines;
	private ArrayList<String> renderedStudents;


	private boolean mouseDragged;
	private int mouseX, mouseY;

	public Gameplay(MainFrame frame) {
		super("Assets/UI/Gameplay/Background.jpg");

		// Back-end Integration
		this.university = new University(1);


		/********** REVISE INTEGRATION ***********/
		// this.container = container;
		this.frame = frame;
		/******* END *******/

		// Element Layers
		this.lines = new ArrayList<JPanel>();
		for(int i = 0; i < 5; i++) {
			this.lines.add(new JPanel());
			this.lines.get(i).setSize(1000, 600);
			this.lines.get(i).setOpaque(false);
			this.add(this.lines.get(i), i);
		}

		// Element Layers
		this.lines = new ArrayList<JPanel>();
		for(int i = 0; i < 5; i++) {
			this.lines.add(new JPanel());
			this.lines.get(i).setSize(1000, 600);
			this.lines.get(i).setOpaque(false);
			this.add(this.lines.get(i), i);
		}

		// UUID Holder
		this.renderedStudents = new ArrayList<String>();

		// Instantiate Menu Button
		Button menu_btn = new Button(850, 15, "Assets/UI/Gameplay/Menu.png");
		menu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// container.removeAll();
				// MainMenu menu = new MainMenu(container, frame);
				// container.add(menu, BorderLayout.CENTER);
				// university.endGame();
				// frame.pack();
				// frame.setLocationRelativeTo(null);
				// frame.setVisible(true);
			}
		});
		this.renderObject(menu_btn);

		this.add(this.university.getTimer());
		this.money = new Text(40, 55, this.university.getFund());
		this.add(this.money);

		this.renderStash();
		
		// this.repaint();
	}

	private void renderStash() {
		Button tita_card = new Button(130, -12, "Assets/UI/Gameplay/Cards/Tita.png");
		Button talker_card = new Button(214, -12, "Assets/UI/Gameplay/Cards/Talker.png");
		Button waterThrower_card = new Button(298, -12, "Assets/UI/Gameplay/Cards/WaterThrower.png");
		Button coffeeMaker_card = new Button(382, -12, "Assets/UI/Gameplay/Cards/CoffeeMaker.png");

		this.renderObject(tita_card);
		this.renderObject(talker_card);
		this.renderObject(waterThrower_card);
		this.renderObject(coffeeMaker_card);

		ObjectRendered tita_Image = new ObjectRendered(mouseX, mouseY, "Assets/Professors/Tita.png");
		ObjectRendered talker_Image = new ObjectRendered(mouseX, mouseY, "Assets/Professors/Talker.png");
		ObjectRendered waterThrower_Image = new ObjectRendered(mouseX, mouseY, "Assets/Professors/WaterThrower.png");
		ObjectRendered coffeeMaker_Image = new ObjectRendered(mouseX, mouseY, "Assets/Professors/CoffeeMaker.png");

		/* Mouse Listeners */
		// Tita
		tita_card.addMouseListener(new DragAndDrop(tita_Image, this.university, this, 1));
		tita_card.addMouseMotionListener(new DragAndDrop(tita_Image, this.university, this, 1));

		// Talker
		talker_card.addMouseListener(new DragAndDrop(talker_Image, this.university, this, 2));
		talker_card.addMouseMotionListener(new DragAndDrop(talker_Image, this.university, this, 2));

		// WaterThrower
		waterThrower_card.addMouseListener(new DragAndDrop(waterThrower_Image, this.university, this, 3));
		waterThrower_card.addMouseMotionListener(new DragAndDrop(waterThrower_Image, this.university, this, 3));

		// CoffeeMaker
		coffeeMaker_card.addMouseListener(new DragAndDrop(coffeeMaker_Image, this.university, this, 4));
		coffeeMaker_card.addMouseMotionListener(new DragAndDrop(coffeeMaker_Image, this.university, this, 4));

	}

	private void renderKwatro() {
		Kwatro[] kwatro = this.university.getKwatro();

		for(int i = 0; i < 5; i++) this.add(kwatro[i]);
	}

	private void renderProfessors() {
		ArrayList<Professor> professors = this.university.getProfessors();

		for(int i = 0; i < professors.size(); i++) {
			JPanel pane = this.lines.get(this.lines.size() - 1 - professors.get(i).getArrY());

			pane.add(professors.get(i));

			if (professors.get(i).getType().equals("Tita")){
				this.renderMoney(professors.get(i));
			}
      
		}
	}

	private void renderStudents() {
		ArrayList<Student> students = this.university.getStudents();

		for(int i = 0; i < students.size(); i++) {
			this.lines.get(this.lines.size() - 1 - students.get(i).getArrY()).add(students.get(i));
		}
	}

	private void renderMoney(Professor professor){
		if(professor.getChargeTime() == professor.getAtkSpeed() * 8){
			this.university.addFund(professor.getSalary());
			professor.resetChargeTime();

			this.remove(this.money);
			this.money = new Text(40, 55, this.university.getFund());
			this.add(this.money);

		}else{
			professor.incChargeTime();

		}
	}

	public void startGame() {
		this.university.startRequiredThreads();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.background, 0, 0, null);

		this.renderProfessors();
		this.renderKwatro();
		this.renderStudents();

		Toolkit.getDefaultToolkit().sync();
	}

	public void mouseDragging(ObjectRendered object, int mouseX, int mouseY){
		object.setCoordinates(mouseX, mouseY);
		object.repaint();
		this.add(object);
		this.repaint();

	}

	public void mouseDropping(ObjectRendered object, int mouseX, int mouseY, int value){
		this.remove(object);

		if(mouseY / 100 > 4){
			mouseY = 400;
		}else if(mouseY / 100 < 0){
			mouseY = 0;
		}

		switch(value){
			case 1:
				if(!this.university.isOccupied(mouseX / 113, (mouseY / 100))){
					this.university.hireProfessor(mouseX / 113, (mouseY / 100), new Tita());
					this.university.decFund(new Tita().getSalary());
				}
				break;
			case 2:
				if(!this.university.isOccupied(mouseX / 113, (mouseY / 100))){
					this.university.hireProfessor(mouseX / 113, (mouseY / 100), new Talker());
					this.university.decFund(new Talker().getSalary());
				}
				break;
			case 3:
				if(!this.university.isOccupied(mouseX / 113, (mouseY / 100))){
					this.university.hireProfessor(mouseX / 113, (mouseY / 100), new WaterThrower());
					this.university.decFund(new WaterThrower().getSalary());
				}
				break;
			case 4:
				if(!this.university.isOccupied(mouseX / 113, (mouseY / 100))){
					this.university.hireProfessor(mouseX / 113, (mouseY / 100) , new CoffeeMaker());
					this.university.decFund(new CoffeeMaker().getSalary());
				}
				break;
		}

		this.remove(this.money);
		this.money = new Text(40, 55, this.university.getFund());
		this.add(this.money);

		this.repaint();
	}

	// public Gameplay getGameplay(){
	// 	return this;
	// }
}
