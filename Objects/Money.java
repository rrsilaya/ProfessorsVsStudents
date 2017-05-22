package pvs.objects;

import pvs.University;

import pvs.screens.Gameplay;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Money extends JButton implements ActionListener, Runnable {
	private final static int FRAME_WIDTH = 1000;
	private final static int FRAME_LENGTH = 600;
	private final static int AMOUNT = 50;
	private final static int SPEED = 10;

	private final static String GRAPHICS = ".png";
	
	private Gameplay gameplay;
	private University university;

	private BufferedImage image;

	private int money;
	private int xPos;
	private int yPos;

	// Falling money
	public Money(University university) {
		this.money =  0;
		this.university = university;
		// this.randXPos();
		// this.randYPos();
		this.xPos = 0;
		this.yPos = 0;
		this.loadImage(Money.GRAPHICS);		this.setSize(this.image.getWidth(), this.image.getHeight());
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
	}

	// Tita producing money
	public Money(University university, Gameplay gameplay, int x, int y) {
		this.money =  0;
		this.university = university;
		this.gameplay = gameplay;
		this.xPos = x;
		this.yPos = y;
		this.loadImage(Money.GRAPHICS);
	}

	// Setters
	public void setMoney(){
		this.money += 50;
	}

	/*
	private void randXPos() {
		Random rand = new Random();
		NOTE: Randomize position in main frame
		this.xPos = rand.nextInt(COLUMN SIZES);
	}

	private void randYPos() {
		Random rand = new Random();
		return this.yPos;
	}
*/

	// Getters
	public int getMoney() {
		return this.money;
	}

	private void incYPos(int distance) {
		this.yPos += distance;
	}

	private void loadImage(String filename){
		try{
			this.image = ImageIO.read(new File(filename));
		} catch(Exception e){}	
	}

	private void fall() {
		if(this.yPos <= Money.FRAME_LENGTH) {
			this.incYPos(10); // Will change depending on GUI ROW SIZE
		}
	}

	@Override
	public void run() {
		while(this.university.isTimerActive()) {
			this.fall();
			gameplay.repaint();
			try {
				Thread.sleep(1000 * Money.SPEED);
			} catch(Exception e) {}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		this.setMoney();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.image, 0, 0, null);
	}
}
