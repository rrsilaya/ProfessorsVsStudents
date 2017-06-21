package pvs.objects;

import javax.swing.JButton;
// import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Dimension;

public class Button extends JButton {
	private int x;
	private int y;
	private BufferedImage img;

	public Button(int x, int y, String path) {
		try {
			this.img = ImageIO.read(new File(path));
		} catch (Exception e) {}

		this.x = x - 1;
		this.y = y - 1;

		this.setSize(this.img.getWidth(), this.img.getHeight());
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, 0, 0, null);
	}
}