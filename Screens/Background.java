package pvs.screens;

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

		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, 0, 0, null);
	}
}
