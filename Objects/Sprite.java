package pvs.objects;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import java.io.File;

public class Sprite extends JPanel {
	private int x;
	private int y;
	private BufferedImage img;

	public Sprite(int x, int y, String path) {
		this.x = x - 1;
		this.y = y - 1;

		try {
			this.img = ImageIO.read(new File(path));
		} catch (Exception e) {}

		this.setOpaque(false);
		this.setSize(1000, 600);
	}

	public void setX(int x) {
		this.x = x - 1;
	}

	public void setY(int y) {
		this.y = y - 1;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, this.x, this.y, null);
	}
}