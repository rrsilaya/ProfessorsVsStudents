package pvs.screens;

import pvs.objects.ObjectRendered;
import pvs.objects.Button;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import java.io.File;

public class Background extends JPanel {
	private final String path;
	private BufferedImage img;

	public Background(String path) {
		this.path = path;

		this.setBackground(Color.BLACK);
		this.setLayout(null);

		try {
			this.img = ImageIO.read(new File(this.path));
		} catch(Exception e) {}
	}

	// protected void renderObject(Graphics2D g2d, ObjectRendered object) {
	// 	g2d.drawImage(object.getImage(), object.getX(), object.getY(), null);
	// }

	protected void renderObject(ObjectRendered object) {
		object.setLocation(object.getX(), object.getY());
		this.add(object);
	}

	protected void renderObject(Button btn) {
		btn.setLocation(btn.getX(), btn.getY());
		this.add(btn);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, 0, 0, null);
	}
}
