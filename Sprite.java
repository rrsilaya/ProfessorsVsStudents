// To do: Rectangle Panel and intersection method

import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.io.File;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Sprite extends JPanel {
	protected Image img;
	protected int xPos, yPos;

	public Sprite(int xPos, int yPos, String filename) {
		this.xPos = this.xPos;
		this.yPos = this.yPos;
		this.setImage(filename);
		this.setOpaque(false);
	}

	// Setters
	private void setImage(String filename) {
		try {
			img = ImageIO.read(new File(filename));
		} catch(Exception e) {
		}	
	}

	public void incXPos(int distance) {
		this.xPos += distance;
	}

	public void incYPos(int distance) {
		this.yPos += distance;
	}

	// Getters
	public Image getImage() {
		return this.img;
	}

	public int getXPos() {
		return this.xPos;
	}

	public int getYPos() {
		return this.yPos;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.getImage(),this.getXPos(),this.getYPos(),null);
		Toolkit.getDefaultToolkit().sync();
	}
}
