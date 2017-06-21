package pvs.objects;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.imageio.ImageIO;
import java.io.File;

public class Sprite extends JPanel {
	protected int x;
	protected int y;
	private boolean isHurt;
	private BufferedImage img;
	private BufferedImage img_hurt;

	public Sprite(int x, int y, String path) {
		this.x = x - 1;
		this.y = y - 1;
		this.isHurt = false;

		try {
			this.img = ImageIO.read(new File(path));
		} catch (Exception e) {}

		String[] filename = path.split("\\.");
		try {
			this.img_hurt = ImageIO.read(new File(filename[0] + "_hurt." + filename[1]));
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

	public void indicateAttacked() {
		this.isHurt = true;
		try {
			Thread.sleep(300);
		} catch (Exception e) {}
		this.isHurt = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		if(this.isHurt) g2d.drawImage(this.img_hurt, this.x, this.y, null);
		else g2d.drawImage(this.img, this.x, this.y, null);
	}
}