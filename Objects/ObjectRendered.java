package pvs.objects;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ObjectRendered extends JPanel {
	private int x, y;
	protected BufferedImage img;

	public ObjectRendered(int x, int y, String path) {
		this.x = x - 1;
		this.y = y - 1;
		this.setOpaque(false);

		try {
			this.img = ImageIO.read(new File(path));
		} catch(Exception e) {}

		this.setSize(this.img.getHeight(), this.img.getWidth());
	}

	public int getHeight() {
		return this.img.getHeight();
	}

	public int getWidth() {
		return this.img.getWidth();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setCoordinates(int x, int y) {
		this.x = x - 1;
		this.y = y - 1;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, 0, 0, null);
	}
}
